package com.eldroid.loadout.view.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.eldroid.loadout.contract.auth.LoginContract
import com.eldroid.loadout.databinding.ActivityLoginBinding
import com.eldroid.loadout.model.repository.AuthRepository
import com.eldroid.loadout.presenter.auth.LoginPresenter
import com.eldroid.loadout.view.dashboard.DashboardActivity

class LoginActivity : AppCompatActivity(), LoginContract.View {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var presenter: LoginContract.Presenter
    private lateinit var emailInput: EditText
    private lateinit var passwordInput: EditText
    private lateinit var loginButton: Button
    private lateinit var registerLink: TextView
    private lateinit var progressBar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        emailInput = binding.emailEt
        passwordInput = binding.passEt
        loginButton = binding.loginBtn
        registerLink = binding.registerLinkTv
        progressBar = binding.progressBar

        presenter = LoginPresenter(this, AuthRepository())

        registerLink.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        loginButton.setOnClickListener {
            val email = emailInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()
            presenter.login(email, password)
        }
    }

    override fun showLoading() {
        progressBar.visibility = ProgressBar.VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility = ProgressBar.GONE
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun navigateToHome() {
        Toast.makeText(this, "Login success!", Toast.LENGTH_LONG).show()
        val intent = Intent(this, DashboardActivity::class.java)
        startActivity(intent)
        finish()
    }
}