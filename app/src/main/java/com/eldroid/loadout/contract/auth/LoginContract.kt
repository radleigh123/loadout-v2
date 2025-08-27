package com.eldroid.loadout.contract.auth

interface LoginContract {
    interface View {
        fun showLoading()
        fun hideLoading()
        fun showError(message: String)
        fun navigateToHome()
    }

    interface Presenter {
        fun login(email: String, password: String)
    }
}