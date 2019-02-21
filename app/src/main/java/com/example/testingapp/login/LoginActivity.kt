package com.example.testingapp.login

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.moviesapp.ui.base.BaseActivity
import com.example.testingapp.R
import kotlinx.android.synthetic.main.activity_login.*

/**
 * A login screen that offers login via email/password.
 */
class LoginActivity : BaseActivity(), LoginMvpView {
    override fun success() {
        success_text.visibility = View.VISIBLE
    }

    override fun getPassword(): String {
        return password.text.toString()
    }

    override fun getMail(): String {
        return email_input.text.toString()
    }

    private lateinit var presenter: LoginPresenter<LoginMvpView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        presenter = LoginPresenter()
        presenter.onAttach(this)
        initViews()
    }


    override fun showMessage(id: Int) {
        Toast.makeText(this, id, Toast.LENGTH_LONG).show()
    }

    override fun initViews() {
        done_btn.setOnClickListener {
            presenter.signUpClick()

        }
    }


}
