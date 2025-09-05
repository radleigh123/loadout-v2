package com.eldroid.loadout.view.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.eldroid.loadout.contract.auth.RegisterContract
import com.eldroid.loadout.databinding.ActivityRegisterBinding
import com.eldroid.loadout.model.repository.AuthRepository
import com.eldroid.loadout.presenter.auth.RegisterPresenter

class RegisterActivity : AppCompatActivity(), RegisterContract.View {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var presenter: RegisterContract.Presenter
    private lateinit var firstNameInput: EditText
    private lateinit var lastNameInput: EditText
    private lateinit var emailInput: EditText
    private lateinit var passwordInput: EditText
    private lateinit var confirmPasswordInput: EditText
//    private lateinit var checkBox: CheckBox
    private lateinit var progressBar: ProgressBar
    private lateinit var registerButton: Button
    private lateinit var loginLink: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firstNameInput = binding.fNameEt
        lastNameInput = binding.lNameEt
        emailInput = binding.emailEt
        passwordInput = binding.passEt
        confirmPasswordInput = binding.pass2Et
//        checkBox = binding.checkboxMeat
        registerButton = binding.registerBtn
        progressBar = binding.progressBar
        loginLink = binding.loginLinkTv

        presenter = RegisterPresenter(this, AuthRepository())

        loginLink.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        registerButton.setOnClickListener {
            val firstName = firstNameInput.text.toString().trim()
            val lastName = lastNameInput.text.toString().trim()
            val email = emailInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()
            val confirmPassword = confirmPasswordInput.text.toString().trim()
//            val isChecked = checkBox.isChecked

            if (firstName.isEmpty()) {
                firstNameInput.error = "First name is required"
                firstNameInput.requestFocus()
                return@setOnClickListener
            }

            if (lastName.isEmpty()) {
                lastNameInput.error = "Last name is required"
                lastNameInput.requestFocus()
                return@setOnClickListener
            }

            if (email.isEmpty()) {
                emailInput.error = "Email is required"
                emailInput.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                passwordInput.error = "Password is required"
                passwordInput.requestFocus()
                return@setOnClickListener
            }

            if (password.length < 6) {
                passwordInput.error = "Password must be at least 6 characters"
                passwordInput.requestFocus()
                return@setOnClickListener
            }

            if (password != confirmPassword) {
                confirmPasswordInput.error = "Passwords do not match"
                confirmPasswordInput.requestFocus()
                return@setOnClickListener
            }

//            if (!isChecked) {
//                checkBox.error = "You must agree to the terms"
//                checkBox.requestFocus()
//                return@setOnClickListener
//            }

            presenter.register(email, password)
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
        Toast.makeText(this, "Registration success!", Toast.LENGTH_LONG).show()
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}