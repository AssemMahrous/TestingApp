package com.example.testingapp.login

import com.example.moviesapp.ui.base.MvpPresenter

interface LoginMvpPresenter<V : LoginMvpView> : MvpPresenter<V> {

    fun signUpClick(): String

    fun showMessage(id: Int)

    fun success()


}