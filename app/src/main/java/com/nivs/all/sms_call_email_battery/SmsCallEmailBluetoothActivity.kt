package com.nivs.all.sms_call_email_battery

import android.Manifest
import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.icu.util.Calendar
import android.net.Uri
import android.os.BatteryManager
import android.os.Build
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.nivs.all.databinding.ActivityPusnotificationBinding

class SmsCallEmailBluetoothActivity: AppCompatActivity() {
    lateinit var binding: ActivityPusnotificationBinding
    private val reqSendSMS = 1
    private val reqPhoneCall = 2
    var title = ""
    var subject = ""
    var body = ""
    lateinit var pendingIntent: PendingIntent

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPusnotificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.text = "Ceck Battery Status"
        binding.button1.setOnClickListener() {
            //https://developer.android.com/training/monitoring-device-state/battery-monitoring
            val batteryManager: BatteryManager = this.getSystemService(BatteryManager::class.java)
            if (Build.VERSION.SDK_INT >= 23) {
                var percentage =
                    batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY)
                binding.editText3.setText("Battery % is $percentage %")
            }
        }

        binding.button2.setOnClickListener {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.SEND_SMS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.SEND_SMS),
                    reqSendSMS
                )
            } else {
                sendSms()
            }
        }

        binding.button3.setOnClickListener {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(android.Manifest.permission.CALL_PHONE),
                    reqPhoneCall
                )
            } else {
                makeCall()
            }
        }

        binding.button4.setOnClickListener {
            /*if(ActivityCompat.checkSelfPermission(this, Manifest.permission.Ema) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,arrayOf(android.Manifest.permission.CALL_PHONE),reqPhoneCall)
            }else{*/
            sendEmail()
            //}
        }

        binding.button5.setOnClickListener {
            //https://www.tutorialspoint.com/how-to-start-service-using-alarmmanager-in-kotlin-android
            val myIntent =
                Intent(this@SmsCallEmailBluetoothActivity, AlarmStartStopService::class.java)
            pendingIntent =
                PendingIntent.getService(this@SmsCallEmailBluetoothActivity, 0, myIntent, 0)
            val alarmManager: AlarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
            val calendar: Calendar = Calendar.getInstance()
            calendar.timeInMillis = System.currentTimeMillis()
            calendar.add(Calendar.SECOND, 3)
            alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, pendingIntent)
            Toast.makeText(baseContext, "Starting Service Alarm", Toast.LENGTH_LONG).show()
        }
        binding.button6.setOnClickListener {
            val alarmManager: AlarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
            alarmManager.cancel(pendingIntent)
            Toast.makeText(baseContext, "Service Cancelled", Toast.LENGTH_LONG).show()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == reqPhoneCall){
            makeCall()
        }
        else if (requestCode==reqSendSMS) {
            sendSms()
        }
    }

    private fun sendSms() {
        val message = binding.editText2.text.toString()
        val number = binding.editText.text.toString()
        /*var total: Int = binding.editText3.toString().toInt()
        if(number.isNotEmpty() && message.isNotEmpty()) {
            for (i in 0 until total) {
                SmsManager.getDefault().sendTextMessage(number, null, message, null, null)
            }
            Toast.makeText(this, "SENDED " + total, Toast.LENGTH_SHORT).show()
        }  else {
        Toast.makeText(this, "Enter number and messae ", Toast.LENGTH_SHORT).show();
        }*/
        try {
            // on below line we are initializing sms manager.
            //as after android 10 the getDefault function no longer works
            //so we have to check that if our android version is greater
            //than or equal toandroid version 6.0 i.e SDK 23
            val smsManager: SmsManager
            if (Build.VERSION.SDK_INT>=23) {
                //if SDK is greater that or equal to 23 then
                //this is how we will initialize the SmsManager
                smsManager = this.getSystemService(SmsManager::class.java)
            }
            else{
                //if user's SDK is less than 23 then
                //SmsManager will be initialized like this
                smsManager = SmsManager.getDefault()
            }

            // on below line we are sending text message.
            smsManager.sendTextMessage(number, null, message, null, null)

            // on below line we are displaying a toast message for message send,
            Toast.makeText(applicationContext, "Message Sent", Toast.LENGTH_LONG).show()

        } catch (e: Exception) {

            // on catch block we are displaying toast message for error.
            Toast.makeText(applicationContext, "Please enter all the data.."+e.message.toString(), Toast.LENGTH_LONG)
                .show()
        }
    }
    /*private fun sendSMS(){
        val phoneNumber = "8897262639"
        val message = "Testin App"
        val sentPI: PendingIntent = PendingIntent.getBroadcast(this, 0, Intent("SMS_SENT"), 0)
        SmsManager.getDefault().sendTextMessage(phoneNumber, null, message, sentPI, null)
    }*/

    private fun makeCall(){
        title = binding.editText.text.toString().trim { it <= ' ' }
        subject = binding.editText2.text.toString().trim { it <= ' ' }
        body = binding.editText3.text.toString().trim { it <= ' ' }
        val intent= Intent(Intent.ACTION_CALL)
        intent.setData(Uri.parse("tel:$title"))
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED
        ) {
            Toast.makeText(this,"Permission denied", Toast.LENGTH_LONG).show()
            return
        }
        startActivity(intent)
    }

    private fun sendEmail()
    {
        title = binding.editText.text.toString()
        subject = binding.editText2.text.toString()
        body = binding.editText3.text.toString()

        //now create an intent object
        val intent = Intent(Intent.ACTION_SENDTO)

        //provide email address of the recipient as data
        intent.data = Uri.parse("mailto:$title")

        //now we will add extras with the mail
        intent.putExtra(Intent.EXTRA_SUBJECT, subject)
        intent.putExtra(Intent.EXTRA_TEXT, body)

        //set the type of mail
        intent.type = "text/plain"

        //start your intent
        startActivity(Intent.createChooser(intent, "Select your Email app"))
    }

}