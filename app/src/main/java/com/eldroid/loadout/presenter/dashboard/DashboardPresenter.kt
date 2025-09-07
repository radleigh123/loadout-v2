package com.eldroid.loadout.presenter.dashboard

import com.eldroid.loadout.contract.dashboard.DashboardContract
import com.eldroid.loadout.model.entity.TrashBin
import com.eldroid.loadout.model.repository.TrashBinRepository
import com.google.firebase.database.ValueEventListener

/**
 * Presenter implementation for the Dashboard screen.
 * Handles the business logic and communication between View and Repository.
 */
class DashboardPresenter(
    private var view: DashboardContract.View?,
    private val repository: TrashBinRepository
) : DashboardContract.Presenter {

    // List to store active listeners so they can be removed when the presenter is destroyed
    private val activeListeners = mutableMapOf<String, ValueEventListener>()
    
    override fun start() {
        loadTrashBins()
    }
    
    override fun loadTrashBins() {
        view?.showLoading()
        
        repository.getAllBins { bins, error ->
            view?.hideLoading()
            
            if (error != null) {
                view?.showError("Failed to load trash bins: $error")
                return@getAllBins
            }
            
            view?.displayTrashBins(bins)
            
            // Set up real-time listeners for each bin
            setupBinListeners(bins)
        }
    }
    
    /**
     * Set up individual listeners for each bin for real-time updates
     */
    private fun setupBinListeners(bins: List<TrashBin>) {
        // Remove any existing listeners
        clearActiveListeners()
        
        // Add new listeners for each bin
        bins.forEach { bin ->
            val listener = repository.listenForBinUpdates(bin.binId) { updatedBin, error ->
                if (error != null) {
                    view?.showError("Failed to get updates for bin ${bin.binId}: $error")
                    return@listenForBinUpdates
                }
                
                updatedBin?.let {
                    view?.updateTrashBinDisplay(it)
                }
            }
            
            activeListeners[bin.binId] = listener
        }
    }
    
    /**
     * Clear all active listeners to prevent memory leaks
     */
    private fun clearActiveListeners() {
        activeListeners.forEach { (binId, listener) ->
            repository.removeListener(binId, listener)
        }
        activeListeners.clear()
    }
    
    override fun onDestroy() {
        clearActiveListeners()
        view = null
    }
}
