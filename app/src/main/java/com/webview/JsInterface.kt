package com.webview

import android.content.Context
import android.webkit.JavascriptInterface
import android.widget.EditText

class JsInterface(var context: Context, var editText: EditText) {

    @JavascriptInterface
    fun recebendoDaWeb(texto: String) {
        editText.setText(texto)
    }

    @JavascriptInterface
    fun limpar(texto: String) {
        editText.setText("")
    }
}