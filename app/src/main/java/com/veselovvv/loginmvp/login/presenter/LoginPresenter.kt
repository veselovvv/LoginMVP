package com.veselovvv.loginmvp.login.presenter

import com.veselovvv.loginmvp.ThreadUtil
import com.veselovvv.loginmvp.login.model.User
import com.veselovvv.loginmvp.login.view.ILoginView

class LoginPresenter(private var iLoginView: ILoginView) : ILoginPresenter {
    override fun clear() = iLoginView.onClear()
    override fun showProgress() = iLoginView.onShowProgress()
    override fun hideProgress() = iLoginView.onHideProgress()

    override fun login(id: String, password: String) {
        clear()
        showProgress()

        LoginController.requestLogin(
            id,
            password,
            object : LoginController.LoginControllerDelegate {
                override fun onSuccess(response: String) {
                    // Parsing data

                    // Dummy data:
                    val user = User()
                    user.nickname = "User"
                    user.age = 30

                    // UI thread:
                    ThreadUtil.Base.startUIThread(0) {
                        hideProgress()
                        iLoginView.onUpdateLoginResult(user.nickname, user.age)
                    }
                }
                override fun onFailed() = hideProgress()
            }
        )
    }
}