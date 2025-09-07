package com.eldroid.loadout.contract.dashboard

import com.eldroid.loadout.model.entity.TrashBin

/**
 * Contract interface for Dashboard screen that defines the responsibilities 
 * for both View and Presenter in the MVP architecture.
 */
interface DashboardContract {
    
    /**
     * View interface defines UI-related operations that the view (Activity/Fragment) must implement
     */
    interface View {
        /**
         * Show a loading indicator while fetching data
         */
        fun showLoading()
        
        /**
         * Hide the loading indicator
         */
        fun hideLoading()
        
        /**
         * Display error message to the user
         */
        fun showError(message: String)
        
        /**
         * Update the UI with a list of trash bins
         */
        fun displayTrashBins(bins: List<TrashBin>)
        
        /**
         * Update a specific trash bin in the UI
         */
        fun updateTrashBinDisplay(bin: TrashBin)
    }
    
    /**
     * Presenter interface defines operations that the presenter must implement to handle business logic
     */
    interface Presenter {
        /**
         * Start listening for trash bin data updates
         */
        fun start()
        
        /**
         * Load all trash bins from the repository
         */
        fun loadTrashBins()
        
        /**
         * Clean up resources when presenter is no longer needed
         */
        fun onDestroy()
    }
}
