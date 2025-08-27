package com.eldroid.loadout.presenter.auth.login

import com.eldroid.loadout.contract.auth.LoginContract
import com.eldroid.loadout.model.repository.AuthRepository

class LoginPresenter(
    private val view: LoginContract.View,
    private val authRepository: AuthRepository
) : LoginContract.Presenter {
    override fun login(email: String, password: String) {
        view.showLoading()
        authRepository.login(email, password) { success, error ->
            view.hideLoading()
            if (success) {
                view.navigateToHome()
            } else {
                view.showError(error ?: "Unknown error")
            }
        }
    }
}