package com.example.testingapp.login

import com.example.moviesapp.ui.base.MvpView

interface LoginMvpView : MvpView {

    fun initViews()

    fun showMessage(id: Int)

    fun getMail(): String

    fun getPassword(): String

    fun success()
}