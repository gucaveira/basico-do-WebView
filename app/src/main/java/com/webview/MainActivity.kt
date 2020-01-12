package com.webview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        web_view.loadUrl("file:///android_asset/www/index.html")
        web_view.settings.javaScriptEnabled = true
        web_view.addJavascriptInterface(JsInterface(this, edit_text_nativo), "jsInterfaceNoAndroid")
        button_nativo.setOnClickListener {
            web_view.evaluateJavascript(
                "javascript:" +
                        "enviaParaWebView(\" " + edit_text_nativo.text + "\")", null
            )
        }
    }
}


