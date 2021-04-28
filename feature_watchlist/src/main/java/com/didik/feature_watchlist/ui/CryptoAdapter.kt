package com.didik.feature_watchlist.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.didik.feature_watchlist.databinding.ItemStockBinding
import com.didik.feature_watchlist.domain.model.CryptoModel

class CryptoAdapter : PagingDataAdapter<CryptoModel, CryptoAdapter.CryptoViewHolder>(CryptoDiffUtil) {

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
                    crypto.changePercentageDay < 0 -> Color.parseColor("#ee4a49")
                    crypto.changePercentageDay > 0 -> Color.parseColor("#00ab6b")
                    else -> Color.parseColor("#b5b5b5")
                }
                percentageChangeTextView.setTextColor(textColor)
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