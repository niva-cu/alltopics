package com.nivs.all.dialog_alert_fragment

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.graphics.Color
import android.os.Bundle
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.nivs.all.R
import com.nivs.all.databinding.ActivityPusnotificationBinding
import java.util.*
import kotlin.collections.ArrayList

//https://www.digitalocean.com/community/tutorials/android-alert-dialog-using-kotlin

class AlertDialogActivityEg:AppCompatActivity() {
    private lateinit var binding : ActivityPusnotificationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPusnotificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.text = "Create Simple Alert Dialog"
        binding.button2.text = "Create Custom Alert Dialog"
        binding.button3.text = "Single Chioce List Alert"
        binding.button4.text = "Multi Chioce List Alert"
        binding.button5.text = "EditText ALert"
        binding.button6.text = "Centered Button ALert"

        binding.button1.setOnClickListener {
            basicAlert()
        }

        binding.button2.setOnClickListener {
            customAlert()
        }

        binding.button3.setOnClickListener {
            singleChioceListAlert()
        }

        binding.button4.setOnClickListener {
            multiChoiceListAlert()
        }

        binding.button5.setOnClickListener {
            withEditText()
        }

        binding.button6.setOnClickListener {
            withButtonCentered()
        }
    }

    private fun withButtonCentered() {
        val alertDialog = AlertDialog.Builder(this).create()
        alertDialog.setTitle("Title")
        alertDialog.setMessage("Message")
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Yes"
        ) { dialog, which -> dialog.dismiss() }
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "No"
        ) { dialog, which -> dialog.dismiss() }
        alertDialog.show()

        val btnPositive = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE)
        val btnNegative = alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE)
        val layoutParams = btnPositive.layoutParams as LinearLayout.LayoutParams
        layoutParams.weight = 10f
        btnPositive.layoutParams = layoutParams
        btnNegative.layoutParams = layoutParams
    }

    @SuppressLint("MissingInflatedId")
    private fun withEditText() {
        val builder = AlertDialog.Builder(this)
        val inflater = layoutInflater
        builder.setTitle("With EditText")
        val dialogLayout = inflater.inflate(R.layout.activity_apicall, null)
        val editText  = dialogLayout.findViewById<EditText>(R.id.eT)
        builder.setView(dialogLayout)
        builder.setPositiveButton("OK") { dialogInterface, i -> Toast.makeText(applicationContext, "EditText is " + editText.text.toString(), Toast.LENGTH_SHORT).show() }
        builder.show()
    }

    private fun multiChoiceListAlert() {
        val items = arrayOf("Microsoft", "Apple", "Amazon", "Google")
        val selectedList = ArrayList<Int>()
        val builder = AlertDialog.Builder(this)

        builder.setTitle("This is list choice dialog box")
        builder.setMultiChoiceItems(items, null
        ) { dialog, which, isChecked ->
            if (isChecked) {
                selectedList.add(which)
            } else if (selectedList.contains(which)) {
                selectedList.remove(Integer.valueOf(which))
            }
        }
        builder.setPositiveButton("DONE") { dialogInterface, i ->
            val selectedStrings = ArrayList<String>()

            for (j in selectedList.indices) {
                selectedStrings.add(items[selectedList[j]])
            }

            Toast.makeText(applicationContext, "Items selected are: " + Arrays.toString(selectedStrings.toTypedArray()), Toast.LENGTH_SHORT).show()
        }

        builder.show()

    }

    private fun singleChioceListAlert() {
        val items = arrayOf("Red", "Orange", "Yellow", "Blue")
        val builder = AlertDialog.Builder(this)
        with(builder)
        {
            setTitle("List of Items")
            setItems(items) { dialog, which ->
                Toast.makeText(applicationContext, items[which] + " is clicked", Toast.LENGTH_SHORT)
                    .show()
            }

            setPositiveButton("OK", positiveButtonClick)
            show()
        }
    }

    private fun customAlert() {
        val builder = AlertDialog.Builder(this)
        with(builder) {
            setTitle("Icon and Button Color")
            setMessage("We have a message")
            setPositiveButton("CALL", null)
            setNegativeButton("SMS", null)
            setNeutralButton("CANCEL", null)
            setPositiveButtonIcon(resources.getDrawable(android.R.drawable.ic_menu_call, theme))
            setIcon(resources.getDrawable(android.R.drawable.ic_dialog_alert, theme))
        }
        val alertDialog = builder.create()
        alertDialog.show()

        val button = alertDialog.getButton(DialogInterface.BUTTON_POSITIVE)
        with(button) {
            setBackgroundColor(Color.CYAN)
            setPadding(0, 0, 20, 0)
            setTextColor(Color.BLUE)
        }
    }

    private fun basicAlert(){
        val builder = AlertDialog.Builder(this)
        with(builder)
        {
            setTitle("Android Alert")
            setMessage("Message Section")
            setPositiveButton("OK", DialogInterface.OnClickListener(function = positiveButtonClick))
            setNegativeButton(android.R.string.no, negativeButtonClick)
            setNeutralButton("Maybe", neutralButtonClick)
            show()
        }
    }

    private val positiveButtonClick = { dialog: DialogInterface, message: Int ->
        Toast.makeText(applicationContext,
            android.R.string.yes, Toast.LENGTH_SHORT).show()
    }
    private val negativeButtonClick = { dialog: DialogInterface, message: Int ->
        Toast.makeText(applicationContext,
            android.R.string.no, Toast.LENGTH_SHORT).show()
    }
    private val neutralButtonClick = { dialog: DialogInterface, message: Int ->
        Toast.makeText(applicationContext,
            "Maybe", Toast.LENGTH_SHORT).show()
    }
}