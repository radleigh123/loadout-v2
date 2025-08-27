package com.eldroid.loadout.presenter.auth

import com.eldroid.loadout.contract.auth.RegisterContract
import com.eldroid.loadout.model.repository.AuthRepository

class RegisterPresenter(
    private val view: RegisterContract.View,
    private val authRepository: AuthRepository
) : RegisterContract.Presenter {
    override fun register(email: String, password: String) {
        view.showLoading()
        authRepository.register(email, password) { success, error ->
            view.hideLoading()
            if (success) {
                view.navigateToHome()
            } else {
                view.showError(error ?: "Unknown error")
            }
        }
    }

}