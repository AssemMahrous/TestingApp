package com.example.testingapp

import com.example.testingapp.login.LoginMvpView
import com.example.testingapp.login.LoginPresenter
import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class LoginUnitTest {

    lateinit var presenter: LoginPresenter<LoginMvpView>
    @Mock
    lateinit var view: LoginMvpView


    @Before
    fun setup() {
        presenter = LoginPresenter()
        presenter.onAttach(view)
    }

    @Test
    fun checkButtonClick() {
        val result = presenter.signUpClick()
        assertEquals(result, "please fill the inputs")
    }

    @Test
    fun checkWrongInputs() {
        Mockito.`when`(view.getMail()).thenReturn("")
        Mockito.`when`(view.getPassword()).thenReturn("")
        val result = presenter.signUpClick()
        assertEquals(result, "please don't add empty strings")
    }


    @Test
    fun checkWrongEmail() {
        Mockito.`when`(view.getMail()).thenReturn("assem")
        Mockito.`when`(view.getPassword()).thenReturn("test")
        val result = presenter.signUpClick()
        assertEquals(result, "please provide a valid email")
    }

    @Test
    fun checkIdealCase() {
        Mockito.`when`(view.getMail()).thenReturn("assem@Ibtikar.net.sa")
        Mockito.`when`(view.getPassword()).thenReturn("test")
        val result = presenter.signUpClick()
        assertEquals(result, "success")
    }


    @After
    @Throws(Exception::class)
    fun tearDown() {
        presenter.onDetach()
    }
}