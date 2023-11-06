package com.nivs.all.contentProvi_shardPref

import android.Manifest
import android.R
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.View
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.cursoradapter.widget.SimpleCursorAdapter
import com.nivs.all.databinding.ActivityApicallBinding

class MainContentProviderActivity: AppCompatActivity() {
    private val reqContentProvider = 1
    private lateinit var binding : ActivityApicallBinding
    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityApicallBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //binding.contactListView.visibility = View.VISIBLE

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_CONTACTS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.READ_CONTACTS),
                reqContentProvider
            )
        } else {
            accessContentProvider()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == reqContentProvider && grantResults[0] == 0){
            accessContentProvider()
        }
    }

    private fun accessContentProvider(){
        /*val cursor = contentResolver.query(
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
        Log.d("ContentProvider", ">>>   ${data.size}")

        lateinit var list_view: ListView

        var destination = intArrayOf(android.R.id.text1, android.R.id.text2)

        var result_set = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            data, null, null, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)

        var adapter = SimpleCursorAdapter(this, R.layout.simple_list_item_2, result_set,
            data, destination, 0);

        list_view.adapter = adapter*/
        binding.listView.visibility = View.VISIBLE
        listView = binding.listView
        var contactFields = listOf<String>(
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
            ContactsContract.CommonDataKinds.Phone.NUMBER,
            ContactsContract.CommonDataKinds.Phone._ID

        ).toTypedArray()

        var source = listOf<String>(
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
            ContactsContract.CommonDataKinds.Phone.NUMBER

        ).toTypedArray()

        var destination = intArrayOf(android.R.id.text1, android.R.id.text2)

        var resultSet = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            contactFields, null, null, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)

        var adapter = SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, resultSet,
            source, destination, 0);

        listView.adapter = adapter

    }
}