package com.monofire.spacexapp.ui.common

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Window
import com.monofire.spacexapp.R

// Code with ❤
//┌─────────────────────────────┐
//│ Created by Ömer ATEŞ        │
//│ ─────────────────────────── │
//│ omerates760@gmail.com       │
//│ ─────────────────────────── │
//│ 3.07.2021 - 17:31          │
//└─────────────────────────────┘
class ProgressDialog(context: Context) : Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.progress_dialog)
        window?.setBackgroundDrawableResource(android.R.color.transparent)
        setCancelable(false)
    }

}