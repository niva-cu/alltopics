package com.nivs.all.pus_notification

import android.app.*
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.app.TaskStackBuilder
import androidx.core.content.ContextCompat
import com.nivs.all.R
import com.nivs.all.app_navigation.AllTopicsActivity
import com.nivs.all.databinding.ActivityPusnotificationBinding

/*
https://androidgeek.co/notifications-in-kotlin-beginner-in-depth-guide-13fa7d0748fc
*/
class PusNotificationActivity : AppCompatActivity() {
    val CHANNEL_ID = "channelID"
    val CHANNEL_NAME = "channelName"
    val NOTIF_ID = 0
    lateinit var binding: ActivityPusnotificationBinding
    var title = ""
    var subject = ""
    var body = ""

    lateinit var notificationChannel: NotificationChannel
    lateinit var notificationManager: NotificationManager
    lateinit var builder: Notification.Builder
    private val channelIds = "12345"
    private val description = "Test Notification"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPusnotificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        createNotifChannel()

        onNewIntent(intent)

        val extras = intent.extras
        if (extras != null) {
            val cameFromNotification = extras!!.getString("NotificationMessage")
            Log.d("Came from notification--", cameFromNotification.toString())
        }


        binding.button1.text = "Send Notification without show message"
        binding.button2.text = "Notification with Show and Click message"
        binding.button3.text = "Send Notification Params to Activity"
        binding.button5.text = "Send Notification with start service"
        binding.button6.text = "Send Notification wit stop service"

        binding.button1.setOnClickListener {
            title = binding.editText.text.toString().trim { it <= ' ' }
            subject = binding.editText2.text.toString().trim { it <= ' ' }
            body = binding.editText3.text.toString().trim { it <= ' ' }
            /*val notif =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager?
            val notify: Notification =
                Notification.Builder(ApplicationProvider.getApplicationContext<Context>())
                    .setContentTitle(tittle).setContentText(body).setContentTitle(subject)
                    .setSmallIcon(R.drawable.ic_close).build()
            notify.flags = notify.flags or Notification.FLAG_AUTO_CANCEL
            notif!!.notify(0, notify)*/

            val pendingIntent = TaskStackBuilder.create(this).run {
                addNextIntentWithParentStack(intent)
                getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
            }

            val notiff = NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle(title)
                .setContentText(body)
                .setSmallIcon(R.drawable.ic_close)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(pendingIntent)
                .build()

            if (title.isNotEmpty() && body.isNotEmpty()) {
                val notifManger = NotificationManagerCompat.from(this)
                notifManger.notify(NOTIF_ID, notiff)
            } else {
                Toast.makeText(this, "Enter some data", Toast.LENGTH_SHORT).show()
            }
        }


        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        binding.button2.setOnClickListener {
            //https://www.tutorialspoint.com/how-to-create-a-notification-alert-using-kotlin
            title = binding.editText.text.toString().trim { it <= ' ' }
            subject = binding.editText2.text.toString().trim { it <= ' ' }
            body = binding.editText3.text.toString().trim { it <= ' ' }

            val intent = Intent(this, AllTopicsActivity::class.java)
            val pendingIntent =
                PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                notificationChannel = NotificationChannel(
                    channelIds,
                    description,
                    NotificationManager.IMPORTANCE_HIGH
                )
                notificationChannel.lightColor = Color.BLUE
                notificationChannel.enableVibration(true)
                notificationManager.createNotificationChannel(notificationChannel)
                builder = Notification.Builder(this, channelIds).setContentTitle(
                    "NOTIFICATION USING " +
                            "KOTLIN"
                ).setContentText("Test Notification").setSmallIcon(R.drawable.ic_close)
                    .setLargeIcon(
                        BitmapFactory.decodeResource(
                            this.resources, R.drawable
                                .ic_launcher_background
                        )
                    ).setContentIntent(pendingIntent)
            }
            notificationManager.notify(12345, builder.build())
        }


        binding.button3.setOnClickListener() {
            val notificationIntent = Intent(this, PusNotificationActivity::class.java)
            notificationIntent.putExtra("NotificationMessage", "I am from Notification")
            notificationIntent.action = Intent.ACTION_MAIN
            notificationIntent.addCategory(Intent.CATEGORY_LAUNCHER)
            //notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            val resultIntent = PendingIntent.getActivity(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                notificationChannel = NotificationChannel(
                    channelIds,
                    description,
                    NotificationManager.IMPORTANCE_HIGH
                )
                notificationChannel.lightColor = Color.BLUE
                notificationChannel.enableVibration(true)
                notificationManager.createNotificationChannel(notificationChannel)
                builder = Notification.Builder(this, channelIds).setContentTitle(
                    "NOTIFICATION"
                ).setContentText("Test 3").setSmallIcon(R.drawable.ic_close)
                    .setLargeIcon(
                        BitmapFactory.decodeResource(
                            this.resources, R.drawable
                                .ic_launcher_background
                        )
                    ).setContentIntent(resultIntent)
            }
            notificationManager.notify(12345, builder.build())
        }

        binding.button5.setOnClickListener(){
            startService()
        }
        binding.button6.setOnClickListener(){
            stopService()
        }
    }

    /*fun Context.hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }*/
    // ide keybowrd on screen click otertan edittext
    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if (currentFocus != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        }
        return super.dispatchTouchEvent(ev)
    }

        private fun createNotifChannel() {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val channel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT).apply {
                    lightColor = Color.BLUE
                    enableLights(true)
                }
                val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
                manager.createNotificationChannel(channel)
            }
        }

    private fun startService() {
        val input: String = binding.editText.text.toString()
        val serviceIntent = Intent(this, NotificationStartStopService::class.java)
        serviceIntent.putExtra("inputExtra", input)
        ContextCompat.startForegroundService(this, serviceIntent)
    }
    private fun stopService() {
        val serviceIntent = Intent(this, NotificationStartStopService::class.java)
        stopService(serviceIntent)
    }


    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        var extras : Bundle? = intent.extras
        Log.d("Came from notification", "NotificationMessage    "+extras)
        if (extras != null ) {
            if (extras.containsKey( "NotificationMessage" )) {
                var msg = extras.getString( "NotificationMessage" ) ;
                binding.button3.text = msg
            }
        }
    }
}