package com.example.tickerwatchlistmanager

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment

class TickerListFragment : Fragment() {

    private var listener: OnTickerClickListener? = null
    private val tickers = mutableListOf("NEE", "AAPL", "DIS") // default tickers

    interface OnTickerClickListener {
        fun onTickerClicked(ticker: String)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnTickerClickListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnTickerClickListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_ticker_list, container, false)
        val listView: ListView = view.findViewById(R.id.tickerListView)
        listView.adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, tickers)
        listView.setOnItemClickListener { _, _, position, _ ->
            listener?.onTickerClicked(tickers[position])
        }
        return view
    }

    fun addTicker(ticker: String) {
        if (tickers.size >= 6) {
            tickers[5] = ticker
        } else {
            tickers.add(ticker)
        }
        view?.findViewById<ListView>(R.id.tickerListView)?.adapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, tickers)
    }
}

