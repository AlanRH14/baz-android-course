package com.example.finalprojectwizelinecryptocurrencies.data.source.remote.dto

data class PayloadOrder(
    val asks: List<AskBidDto>? = null,
    val bids: List<AskBidDto>? = null,
    val sequence: String? = null,
    val updated_at: String? = null
)