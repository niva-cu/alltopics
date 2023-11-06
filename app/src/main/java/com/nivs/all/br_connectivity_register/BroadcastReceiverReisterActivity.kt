package com.nivs.all.br_connectivity_register

import com.nivs.all.R
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


//https://www.tutorialspoint.com/how-to-register-a-broadcastreceiver-programmatically-in-android
//br_connectivity_register

class BroadcastReceiverRegisterActivity : AppCompatActivity() {
    var exampleBroadcastReceiver: ExampleBroadcastReceiver = ExampleBroadcastReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broadcastreceiver_register)
    }

    override fun onStart() {
        super.onStart()
        val filter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        registerReceiver(exampleBroadcastReceiver, filter)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(exampleBroadcastReceiver)
    }
}