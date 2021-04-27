package com.didik.feature_watchlist.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.didik.core.base.BindingFragment
import com.didik.feature_watchlist.databinding.WatchlistFragmentBinding

class WatchlistFragment : BindingFragment<WatchlistFragmentBinding>() {

    private lateinit var viewModel: WatchlistViewModel

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): WatchlistFragmentBinding {
        return WatchlistFragmentBinding.inflate(inflater, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(WatchlistViewModel::class.java)
    }

    override fun renderView() {
        // TODO
    }
}