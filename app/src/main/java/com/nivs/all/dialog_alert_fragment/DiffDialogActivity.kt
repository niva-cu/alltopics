package com.nivs.all.dialog_alert_fragment

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import android.os.Bundle
import android.widget.TimePicker
import androidx.appcompat.app.AppCompatActivity
import com.nivs.all.R
import com.nivs.all.databinding.ActivityPusnotificationBinding
import java.util.*

class DiffDialogActivity:AppCompatActivity() {
    private lateinit var binding : ActivityPusnotificationBinding
    lateinit var bottomSheetFragment: BottomSheetFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPusnotificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.text = "Date Picker Dialog"
        binding.button2.text = "Time Picker Dialog"
        binding.button3.text = "Progress Dialog"
        binding.button4.text = "Dialog Fragment"
        binding.button5.text = "Bottomseet Dialo"
        binding.button6.text = "Centered Button ALert"

        binding.button1.setOnClickListener {
            dateSelectionDialog()
        }

        binding.button2.setOnClickListener {
            timePickerSelectionDialo()
        }

        binding.button3.setOnClickListener {
            sowProressDialog()
        }
        binding.button4.setOnClickListener {
            DialoFrament.newInstance("da", "da")
            .show(supportFragmentManager, DialoFrament.TAG)
        }
        binding.button5.setOnClickListener {
            bottomSheetFragment = BottomSheetFragment()
            bottomSheetFragment.show(supportFragmentManager, "BSDialogFragment")
        }
    }

    @SuppressLint("ObjectAnimatorBinding")
    private fun sowProressDialog() {
        /*val mProgressDialog = ProgressDialog(this)
        mProgressDialog.setTitle("TITLE")
        mProgressDialog.setMessage("MESSAGE")
        mProgressDialog.show()*/

        binding.progressBar.max=10
        ObjectAnimator.ofInt(binding.progressBar,"MESSAGE", 6 )
            .setDuration(2000)
            .start()

        /*val progressDialog = ProgressBar(this)
        progressDialog.max = 100
        progressDialog.min = 0
        progressDialog.accessibilityPaneTitle = "jhsf"
        progressDialog.progress*/
    }

    private fun dateSelectionDialog(){
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        val myFormat = "dd.MM.yyyy" // mention the format you need
        val sdf = SimpleDateFormat(myFormat, Locale.US)

        val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            binding.editText.setText("" + dayOfMonth + "/" + (monthOfYear+1) + "/" + year)
            //same as above but different way to set format
            c.set(Calendar.YEAR, year)
            c.set(Calendar.MONTH, monthOfYear)
            c.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            binding.editText2.setText(sdf.format(c.time))
        }, year, month, day)

        // below lines to set min and max date selection rane to te calendar
        dpd.datePicker.minDate = c.timeInMillis
        c.add(Calendar.YEAR, 0)
        dpd.datePicker.maxDate = c.timeInMillis+360000000

        dpd.show()
    }

    private fun timePickerSelectionDialo() {
        /*val cal = Calendar.getInstance()
        val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
            cal.set(Calendar.HOUR_OF_DAY, hour)
            cal.set(Calendar.MINUTE, minute)
            binding.editText3.setText(SimpleDateFormat("HH:mm").format(cal.time))
        }
        TimePickerDialog(this, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true).show()
    */
        val mTimePicker: TimePickerDialog
        val mcurrentTime = Calendar.getInstance()
        val hour = mcurrentTime.get(Calendar.HOUR_OF_DAY)
        val minute = mcurrentTime.get(Calendar.MINUTE)

        mTimePicker = TimePickerDialog(this, object : TimePickerDialog.OnTimeSetListener {
            override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
                binding.editText3.setText(String.format("%d : %d", hourOfDay, minute))
            }
        }, hour, minute, false)
        mTimePicker.show()
    }
}