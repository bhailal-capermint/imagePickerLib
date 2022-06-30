package com.github.bhailal.imagepicker.listener


internal interface ResultListener<T> {

    fun onResult(t: T?)
}
