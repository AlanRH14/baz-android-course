package com.example.finalprojectwizelinecryptocurrencies.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.finalprojectwizelinecryptocurrencies.R
import com.example.finalprojectwizelinecryptocurrencies.databinding.ItemCryptocurrenciesBinding
import com.example.finalprojectwizelinecryptocurrencies.domain.model.Book

class CryptocurrencyAdapter(private val onClick: (Book) -> Unit) :
    ListAdapter<Book, CryptocurrencyAdapter.ViewHolder>(CryptocurrencyDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cryptocurrencies, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cryptocurrency = getItem(position)
        holder.binding.apply {
            root.setOnClickListener { onClick(cryptocurrency) }

            Glide.with(imgCryptoCurrencies.context)
                .load(cryptocurrency.image)
                .into(imgCryptoCurrencies)

            tvNameCryptocurrency.text = cryptocurrency.nameCrypto
            tvNameBook.text = cryptocurrency.book
            tvPriceMinCryptocurrency.text = cryptocurrency.minimum_price
            tvPriceMaxCryptocurrency.text = cryptocurrency.maximum_price
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemCryptocurrenciesBinding.bind(view)
    }

    object CryptocurrencyDiffCallback : DiffUtil.ItemCallback<Book>() {
        override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean {
            return oldItem.book == newItem.book
        }

        override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean {
            return oldItem == newItem
        }
    }
}
