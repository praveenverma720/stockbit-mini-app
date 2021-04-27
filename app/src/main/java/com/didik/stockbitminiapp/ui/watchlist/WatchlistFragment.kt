package com.didik.stockbitminiapp.ui.watchlist

import android.view.LayoutInflater
import android.view.ViewGroup
import com.didik.stockbitminiapp.base.BindingFragment
import com.didik.stockbitminiapp.databinding.FragmentWatchlistBinding

class WatchlistFragment : BindingFragment<FragmentWatchlistBinding>() {

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentWatchlistBinding {
        return FragmentWatchlistBinding.inflate(inflater, container, false)
    }

    override fun renderView() {
        // TODO render view
    }
}