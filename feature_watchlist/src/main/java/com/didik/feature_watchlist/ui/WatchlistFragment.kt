package com.didik.feature_watchlist.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.DividerItemDecoration
import com.didik.core.base.BindingFragment
import com.didik.feature_watchlist.R
import com.didik.feature_watchlist.databinding.FragmentWatchlistBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class WatchlistFragment : BindingFragment<FragmentWatchlistBinding>() {

    private lateinit var cryptoAdapter: CryptoAdapter
    private val viewModel: WatchlistViewModel by viewModel()

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentWatchlistBinding {
        return FragmentWatchlistBinding.inflate(inflater, container, false)
    }

    override fun renderView() {
        initCryptoAdapter()
        initStockRecyclerView()
        setupSwipeRefresh()
        setupViewClickListener()
        fetchTopCrypto()
    }

    private fun initCryptoAdapter() {
        cryptoAdapter = CryptoAdapter()
        cryptoAdapter.addLoadStateListener { state ->
            binding.progressBar.isVisible = (state.append == LoadState.Loading)
            binding.swipeRefreshLayout.isRefreshing = state.refresh == LoadState.Loading

            if (state.refresh is LoadState.NotLoading) {
                binding.stockRecyclerView.isVisible = true
                binding.errorConnectionView.isVisible = false
            } else if (state.refresh is LoadState.Error) {
                binding.errorConnectionView.isVisible = true
                binding.stockRecyclerView.isVisible = false
            }
        }
    }

    private fun initStockRecyclerView() {
        binding.stockRecyclerView.run {
            adapter = cryptoAdapter
            addItemDecoration(
                DividerItemDecoration(
                    context,
                    DividerItemDecoration.VERTICAL
                )
            )
        }
    }

    private fun setupSwipeRefresh() {
        binding.swipeRefreshLayout.setOnRefreshListener {
            lifecycleScope.launch {
                cryptoAdapter.refresh()
            }
        }
    }

    private fun fetchTopCrypto() {
        lifecycleScope.launch {
            viewModel.cryptoList.collectLatest { pagingData ->
                cryptoAdapter.submitData(pagingData)
            }
        }
    }

    private fun setupViewClickListener() {
        binding.drawerIconImageView.setOnClickListener {
            showToast(getString(R.string.label_open_drawer))
        }

        binding.notificationIconImageView.setOnClickListener {
            showToast(getString(R.string.label_open_notification))
        }

        binding.watchlistButton.setOnClickListener {
            showToast(getString(R.string.label_all_watchlist))
        }

        binding.addSymbolButton.setOnClickListener {
            showToast(getString(R.string.label_add_symbol))
        }

        binding.tapRetryButton.setOnClickListener {
            cryptoAdapter.retry()
        }
    }
}