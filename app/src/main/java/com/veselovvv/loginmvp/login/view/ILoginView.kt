package com.veselovvv.loginmvp.login.view

interface ILoginView {
    fun onClear()
    fun onShowProgress()
    fun onHideProgress()
    fun onUpdateLoginResult(nickname: String, age: Int)
}