package com.monofire.spacexapp.ui.base

import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import com.monofire.spacexapp.data.remote.ApiErrorException
import com.monofire.spacexapp.ui.common.ProgressDialog

// Code with ❤
//┌─────────────────────────────┐
//│ Created by Ömer ATEŞ        │
//│ ─────────────────────────── │
//│ omerates760@gmail.com       │
//│ ─────────────────────────── │
//│ 3.07.2021 - 17:30          │
//└─────────────────────────────┘
abstract class BaseActivity<B : ViewDataBinding> : AppCompatActivity() {
    protected lateinit var binding: B
    private var progressBar: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getActivityBinding() as B
        initProgressBar()
    }

    abstract fun getActivityBinding(): ViewDataBinding
    private fun initProgressBar() {
        progressBar = ProgressDialog(this)
    }

    fun showProgress() {
        if (progressBar?.isShowing == false) {
            progressBar?.show()
        }
        window?.setFlags(
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
        )
    }

    fun hideProgress() {
        progressBar?.dismiss()
        window?.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
    }

    fun showServiceError(throwable: Throwable) {
        if (throwable is ApiErrorException) {
            showServiceErrorDialog(throwable.errorMessage)
        } else {
            showServiceErrorDialog(throwable.message)
        }
    }

    private fun showServiceErrorDialog(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}