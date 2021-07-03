package com.monofire.spacexapp.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

// Code with ❤
//┌─────────────────────────────┐
//│ Created by Ömer ATEŞ        │
//│ ─────────────────────────── │
//│ omerates760@gmail.com       │
//│ ─────────────────────────── │
//│ 3.07.2021 - 17:30          │
//└─────────────────────────────┘
abstract class BaseFragment<B : ViewDataBinding> : Fragment() {
    protected lateinit var binding: B
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    )
            : View? {
        binding = getFragmentBinding(inflater, container) as B
        return binding.root
    }

    abstract fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): ViewDataBinding

    fun showProgress() {
        (requireActivity() as BaseActivity<*>).showProgress()
    }

    fun hideProgress() {
        (requireActivity() as BaseActivity<*>).hideProgress()
    }

    fun showServiceError(throwable: Throwable) {
        (requireActivity() as BaseActivity<*>).showServiceError(throwable)
    }
}