package com.veselovvv.loginmvp.login.view

import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textview.MaterialTextView
import com.veselovvv.loginmvp.R
import com.veselovvv.loginmvp.login.presenter.ILoginPresenter
import com.veselovvv.loginmvp.login.presenter.LoginPresenter

class LoginActivity : AppCompatActivity(), ILoginView {
    lateinit var iLoginPresenter: ILoginPresenter
    private lateinit var idEditText: TextInputEditText
    private lateinit var passwordEditText: TextInputEditText
    private lateinit var progressFrameLayout: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        idEditText = findViewById(R.id.idEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        progressFrameLayout = findViewById(R.id.progressFrameLayout)

        initPresenter()

        findViewById<MaterialButton>(R.id.loginButton).setOnClickListener {
            iLoginPresenter.login(
                idEditText.text.toString().trim(),
                passwordEditText.text.toString().trim())
        }
    }

    private fun initPresenter() {
        iLoginPresenter = LoginPresenter(this)
    }

    override fun onClear() {
        idEditText.setText("")
        passwordEditText.setText("")
    }

    override fun onShowProgress() {
        progressFrameLayout.visibility = View.VISIBLE
    }

    override fun onHideProgress() {
        progressFrameLayout.visibility = View.GONE
    }

    override fun onUpdateLoginResult(nickname: String, age: Int) {
        findViewById<MaterialTextView>(R.id.loginResultTextView).text =
            "Nickname is $nickname, age is $age"
    }
}