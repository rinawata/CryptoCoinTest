package edu.fullerton.fz.cryptocointest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import android.widget.TextView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    private val cryptoViewModel: CryptoViewModel by viewModels()

    private lateinit var coinNameTextView: TextView
    private lateinit var coinPriceTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        coinNameTextView = findViewById(R.id.coinNameTextView)
        coinPriceTextView = findViewById(R.id.coinPriceTextView)

        GlobalScope.launch(Dispatchers.IO) {
            val cryptoData = cryptoViewModel.fetchCryptoData()
            launch(Dispatchers.Main) {
                // Update the UI with the fetched cryptocurrency data
                coinNameTextView.text = cryptoData.name
                coinPriceTextView.text = cryptoData.formattedPrice
            }
        }
    }
}



