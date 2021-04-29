package com.didik.feature_watchlist.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.didik.feature_watchlist.R
import com.didik.feature_watchlist.databinding.ItemStockBinding
import com.didik.feature_watchlist.domain.model.CryptoModel

class CryptoAdapter
    : PagingDataAdapter<CryptoModel, CryptoAdapter.CryptoViewHolder>(CryptoDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoViewHolder {
        val binding = ItemStockBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CryptoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CryptoViewHolder, position: Int) {
        getItem(position)?.let { data ->
            holder.bind(data)
        }
    }

    inner class CryptoViewHolder(
        private val binding: ItemStockBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(crypto: CryptoModel) {
            with(binding) {
                nameTextView.text = crypto.name
                fullNameTextView.text = crypto.fullName
                priceTextView.text = crypto.price
                percentageChangeTextView.text = crypto.changePercentageDay.toString()

                val textColor = when {
                    crypto.changePercentageDay < 0 -> R.color.redCinnabar
                    crypto.changePercentageDay > 0 -> R.color.greenJade
                    else -> R.color.greyNobel
                }
                percentageChangeTextView.setTextColor(
                    ContextCompat.getColor(percentageChangeTextView.context, textColor)
                )
            }
        }
    }
}

object CryptoDiffUtil : DiffUtil.ItemCallback<CryptoModel>() {
    override fun areItemsTheSame(oldItem: CryptoModel, newItem: CryptoModel): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: CryptoModel, newItem: CryptoModel): Boolean {
        return oldItem == newItem
    }
}