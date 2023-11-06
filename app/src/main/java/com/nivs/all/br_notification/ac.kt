package com.nivs.all.br_notification
import android.R
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.ListView
import android.widget.SimpleCursorAdapter
import androidx.appcompat.app.AppCompatActivity

class ac : AppCompatActivity() {
    // on below line creating a variable for list view.
    private var contactsLV: ListView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*setContentView(R.layout.activity_main)

        // on below line we are initializing our variables.
        contactsLV = findViewById(R.id.listView)

        // create cursor and querying the data on below line
        val cursor = contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            null,
            null,
            null,
            null
        )

        // on below line calling method to manage the cursor.
        startManagingCursor(cursor)

        // on below line getting the data from contacts
        val data = arrayOf(
            ContactsContract.CommonDataKinds.Phone.NUMBER,
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
            ContactsContract.CommonDataKinds.Phone._ID
        )

        // on below line specifying id to which we have to set the data.
        val to = intArrayOf(R.id.idTVContactNumber, R.id.idTVContactName)

        // on below line creating and initializing simple cursor adapter and passing the layout file which we have to display.
        val adapter = SimpleCursorAdapter(this, R.layout.contacts_list_item, cursor, data, to)

        // on below line setting adapter to our list view.
        contactsLV.setAdapter(adapter)

        // on below line setting choice mode for list view.
        contactsLV.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE)*/
    }
}