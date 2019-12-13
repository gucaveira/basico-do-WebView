package com.webview

import android.content.Context
import android.os.Bundle
import android.webkit.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        web_view.loadUrl("file:///android_asset/www/index.html")
        web_view.settings.javaScriptEnabled = true
        web_view.addJavascriptInterface(jsInterface(this), "android")
        button_nativo.setOnClickListener {
            web_view.evaluateJavascript(
                "javascript:" +
                        "enviaParaWebView(\" " + edit_text_nativo.text + "\")", null
            )
        }
    }

    private inner class jsInterface(context: Context) {

        @JavascriptInterface
        fun enviaParaNativo(texto: String) {
            edit_text_nativo.setText(texto)
        }

        @JavascriptInterface
        fun limpar(texto: String) {
            edit_text_nativo.setText("")
        }

    }
}


