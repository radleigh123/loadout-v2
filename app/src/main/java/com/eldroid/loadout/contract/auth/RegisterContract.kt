package com.eldroid.loadout.contract.auth

interface RegisterContract {
    interface View {
        fun showLoading()
        fun hideLoading()
        fun showError(message: String)
        fun navigateToHome()
    }

    interface Presenter {
        fun register(email: String, password: String)
    }
}