package com.example.homework300819.presenter

import androidx.annotation.CallSuper

open class BasePresenter<T : BasePresenter.View> {

    var view: T? = null



    @CallSuper
    open fun onViewAttached(view: T) {
        if (this.view != null) {
            throw IllegalStateException("View is already attached!")
        } else {
            this.view = view
        }
    }



    interface View
}