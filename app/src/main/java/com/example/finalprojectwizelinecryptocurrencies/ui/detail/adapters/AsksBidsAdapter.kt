package com.example.finalprojectwizelinecryptocurrencies.ui.detail.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.finalprojectwizelinecryptocurrencies.R
import com.example.finalprojectwizelinecryptocurrencies.databinding.ItemAsksBidsBinding
import com.example.finalprojectwizelinecryptocurrencies.domain.model.AskBid

class AsksBidsAdapter : ListAdapter<AskBid, AsksBidsAdapter.ViewHolder>(AsksDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_asks_bids, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val askBid = getItem(position)
        holder.binding.apply {
            tvNameBook.text = askBid.book
            tvPriceCryptocurrency.text = askBid.price
            tvAmountCryptocurrency.text = askBid.amount
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemAsksBidsBinding.bind(view)
    }

    object AsksDiffCallback : DiffUtil.ItemCallback<AskBid>() {
        override fun areItemsTheSame(oldItem: AskBid, newItem: AskBid): Boolean {
            return oldItem.book == newItem.book
        }

        override fun areContentsTheSame(oldItem: AskBid, newItem: AskBid): Boolean {
            return oldItem == newItem
        }
    }
}
