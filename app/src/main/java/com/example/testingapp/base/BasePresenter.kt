package com.example.moviesapp.ui.base


open class BasePresenter<V : MvpView> : MvpPresenter<V> {

    private var mMvpView: V? = null
    override fun onAttach(mvpView: V?) {
        mMvpView = mvpView
    }

    override fun onDetach() {
        mMvpView = null
    }

    override fun getMvpView(): V? = mMvpView

}