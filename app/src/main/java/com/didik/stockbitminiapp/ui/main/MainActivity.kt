package com.didik.stockbitminiapp.ui.main

import android.view.LayoutInflater
import com.didik.core.base.BindingActivity
import com.didik.stockbitminiapp.databinding.ActivityMainBinding

class MainActivity : BindingActivity<ActivityMainBinding>() {

    override fun inflateBinding(inflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(inflater)
    }

    override fun renderView() {
        // TODO
    }
}