package com.nivs.all.sms_call_email_battery

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast
@Suppress("DEPRECATION")
class AlarmStartStopService : Service() {
    override fun onCreate() {
        Toast.makeText(this, "AlarmStartStopService.onCreate()", Toast.LENGTH_LONG).show();
        super.onCreate()
    }
    override fun onBind(intent: Intent?): IBinder? {
        Toast.makeText(this, "AlarmStartStopService.onBind()", Toast.LENGTH_LONG).show();
        return null
    }
    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "AlarmStartStopService.onDestroy()", Toast.LENGTH_LONG).show()
    }
    override fun onStart(intent: Intent?, startId: Int) {
        super.onStart(intent, startId)
        Toast.makeText(this, "AlarmStartStopService.onStart()", Toast.LENGTH_LONG).show()
    }
    override fun onUnbind(intent: Intent?): Boolean {
        Toast.makeText(this, "AlarmStartStopService.onUnbind()", Toast.LENGTH_LONG).show()
        return super.onUnbind(intent)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Toast.makeText(this, "AlarmStartStopService.onStartCommand()", Toast.LENGTH_LONG).show()
        return super.onStartCommand(intent, flags, startId)
    }
}