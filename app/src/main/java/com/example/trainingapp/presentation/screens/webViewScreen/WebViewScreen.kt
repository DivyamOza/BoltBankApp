package com.example.trainingapp.presentation.screens.webViewScreen

import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView

/**
 * Web view screen
 *
 * @param url
 */
@Composable
fun WebViewScreen(url: String) {
    AndroidView(factory = { ctx ->
        WebView(ctx).apply {
            settings.javaScriptEnabled = true
            webViewClient = WebViewClient()
            webChromeClient = WebChromeClient()
            loadUrl(url)
        }
    }, modifier = Modifier.fillMaxSize(), update = {
        it.loadUrl(url)
    })
}

@Preview
@Composable
fun WebViewPreview() {
    WebViewScreen(url = "https://google.com")
}

