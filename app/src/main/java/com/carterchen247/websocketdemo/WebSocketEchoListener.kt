package com.carterchen247.websocketdemo

import android.util.Log
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener

class WebSocketEchoListener : WebSocketListener() {

    companion object {
        private val TAG = WebSocketEchoListener::class.java.simpleName
    }

    override fun onOpen(webSocket: WebSocket, response: Response?) {
        webSocket.send("Hello...")
        webSocket.send("...World!")
        webSocket.close(1000, "Goodbye, World!")
    }

    override fun onMessage(webSocket: WebSocket?, text: String) {
        Log.d(TAG, "MESSAGE: $text")
    }

    override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
        webSocket.close(1000, null)
        Log.d(TAG, "CLOSE: $code $reason")
    }

    override fun onFailure(webSocket: WebSocket?, t: Throwable, response: Response?) {
        Log.e(TAG, t.toString())
    }
}