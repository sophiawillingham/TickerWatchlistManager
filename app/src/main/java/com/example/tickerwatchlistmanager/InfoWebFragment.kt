package com.example.tickerwatchlistmanager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment

class InfoWebFragment : Fragment() {

    private lateinit var webView: WebView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_info_web, container, false)
        webView = view.findViewById(R.id.webView)
        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://seekingalpha.com") // default
        return view
    }

    fun loadTicker(ticker: String) {
        webView.loadUrl("https://seekingalpha.com/symbol/$ticker")
    }
}


