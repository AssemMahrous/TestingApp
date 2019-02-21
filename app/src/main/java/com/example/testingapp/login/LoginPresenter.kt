package com.example.testingapp.login

import com.example.moviesapp.ui.base.BasePresenter
import com.example.testingapp.R
import java.util.regex.Pattern


class LoginPresenter<V : LoginMvpView>() : BasePresenter<V>(), LoginMvpPresenter<V> {
    val EMAIL_ADDRESS_PATTERN = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    )

    override fun showMessage(id: Int) {
        getMvpView()?.showMessage(id)
    }

    override fun success() {
        getMvpView()?.success()
    }

    override fun signUpClick(): String {
        val email = getMvpView()?.getMail()

        val password = getMvpView()?.getPassword()

        if (email == null || password == null) {
            showMessage(R.string.fill_inputs)
            return "please fill the inputs"
        }


        if (email.equals("") || password.equals("")) {
            showMessage(R.string.dont_add_empty_string)
            return "please don't add empty strings"
        }


        if (!EMAIL_ADDRESS_PATTERN.matcher(email).matches()) {
            showMessage(R.string.wrong_email)
            return "please provide a valid email"
        }
        success()
        return "success"

    }
}