package com.shweta.mvvmkoindemo.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputMethodManager

object ActivityExtensions {
    inline fun <reified T : Any> Context.launchActivity(options: Bundle? = null, noinline init: Intent.() -> Unit = {}) {
        val intent = newIntent<T>(this)
        intent.init()
        startActivity(intent, options)
    }

    inline fun <reified T : Any> Activity.launchActivityWithResult(options: Bundle? = null, resultCode: Int, noinline init: Intent.() -> Unit = {}) {
        val intent = newIntent<T>(this)
        intent.init()
        startActivityForResult(intent, resultCode, options)
    }

    inline fun <reified T : Any> newIntent(context: Context): Intent = Intent(context, T::class.java)

    inline fun <reified T : Any> Activity.launchActivityAndFinish(options: Bundle? = null, noinline init: Intent.() -> Unit = {}) {
        val intent = newIntent<T>(this)
        intent.init()
        startActivity(intent, options)
        finish()
    }

    fun Activity.hideKeyBoard() {
        (getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager)?.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
    }
}