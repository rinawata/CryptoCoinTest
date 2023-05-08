package edu.fullerton.fz.cryptocointest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import java.text.NumberFormat

class CryptoViewModel : ViewModel() {

    private val _cryptoLiveData = MutableLiveData<CryptoData>()
    val cryptoLiveData: LiveData<CryptoData> = _cryptoLiveData

    private val apiService = RetrofitClient.apiService

    suspend fun fetchCryptoData(): CryptoData {
        val response = RetrofitClient.apiService.getCryptoData()
        val crypto = response.body()?.data?.firstOrNull()
        val coinName = crypto?.name ?: ""
        val coinPrice = crypto?.quote?.USD?.price ?: 0.0
        val formattedPrice = NumberFormat.getCurrencyInstance().format(coinPrice)
        val cryptoData = CryptoData(coinName, coinPrice, formattedPrice)
        _cryptoLiveData.postValue(cryptoData)
        return cryptoData
        println(response)
        println(response.body())
    }
}
