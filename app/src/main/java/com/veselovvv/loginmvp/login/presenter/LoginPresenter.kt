package com.veselovvv.loginmvp.login.presenter

import com.veselovvv.loginmvp.ThreadUtil
import com.veselovvv.loginmvp.login.model.User
import com.veselovvv.loginmvp.login.view.ILoginView

class LoginPresenter(var iLoginView: ILoginView) : ILoginPresenter {

    override fun clear() {
        iLoginView.onClear()
    }

    override fun showProgress() {
        iLoginView.onShowProgress()
    }

    override fun hideProgress() {
        iLoginView.onHideProgress()
    }

    override fun login(id: String, password: String) {
        showProgress()

        LoginController.requestLogin(
            id = id,
            password = password,
            object : LoginController.LoginControllerDelegate {

                override fun onSuccess(response: String) {
                    // Parsing data

                    // Dummy data:
                    val user = User()
                    user.nickname = "User"
                    user.age = 30

                    // UI thread:
                    ThreadUtil.startUIThread(0) {
                        hideProgress()
                        iLoginView.onUpdateLoginResult(nickname = user.nickname, age = user.age)
                    }
                }

                override fun onFailed() {
                    hideProgress()
                }
            }
        )
    }
}