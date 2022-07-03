package com.veselovvv.loginmvp.login.presenter

import com.veselovvv.loginmvp.ThreadUtil

object LoginController {
    interface LoginControllerDelegate {
        fun onSuccess(response: String)
        fun onFailed()
    }

    fun requestLogin(id: String, password: String, delegate: LoginControllerDelegate) {
        ThreadUtil.startThread {
            Thread.sleep(3000)
            delegate.onSuccess("Response from server")
        }
    }
}