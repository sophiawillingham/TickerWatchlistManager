package com.example.tickerwatchlistmanager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), TickerListFragment.OnTickerClickListener {

    private lateinit var infoWebFragment: InfoWebFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Add TickerListFragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.tickerListContainer, TickerListFragment())
            .commit()

        // Add InfoWebFragment
        infoWebFragment = InfoWebFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.infoWebContainer, infoWebFragment)
            .commit()
    }

    override fun onTickerClicked(ticker: String) {
        infoWebFragment.loadTicker(ticker)
    }
}


