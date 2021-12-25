package com.veselovvv.loginmvp.login.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textview.MaterialTextView
import com.veselovvv.loginmvp.R

class LoginActivity : AppCompatActivity(), ILoginView {

    private lateinit var idEditText: TextInputEditText
    private lateinit var passwordEditText: TextInputEditText
    private lateinit var loginButton: MaterialButton
    private lateinit var loginResultTextView: MaterialTextView
    private lateinit var progressFrameLayout: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        idEditText = findViewById(R.id.idEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        loginButton = findViewById(R.id.loginButton)
        loginResultTextView = findViewById(R.id.loginResultTextView)
        progressFrameLayout = findViewById(R.id.progressFrameLayout)

        loginButton.setOnClickListener {

        }
    }

    override fun onClear() {

    }

    override fun onShowProgress() {

    }

    override fun onHideProgress() {

    }

    override fun onUpdateLoginResult(nickname: String, age: Int) {

    }
}