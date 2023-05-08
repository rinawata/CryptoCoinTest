package edu.fullerton.fz.cryptocointest

// Crypto.kt
data class Crypto(
    val id: Int,
    val name: String,
    val symbol: String,
    val quote: Quote
)

data class Quote(
    val USD: CurrencyInfo
)

data class CurrencyInfo(
    val price: Double,
    val volume_24h: Double,
    val percent_change_1h: Double,
    val percent_change_24h: Double,
    val percent_change_7d: Double,
    val market_cap: Double,
    val coinName: String,
    val coinPrice: String
)

data class CryptoData(
    val name: String,
    val price: Double,
    val formattedPrice: String
)