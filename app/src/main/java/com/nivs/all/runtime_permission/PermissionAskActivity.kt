package com.nivs.all.runtime_permission




import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.Manifest.permission.CAMERA
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat.requestPermissions
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.nivs.all.R
import androidx.appcompat.app.AlertDialog
//https://www.digitalocean.com/community/tutorials/android-runtime-permissions-example
class PermissionAskActivity : AppCompatActivity(), View.OnClickListener {
    private var view: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_databinding_twoway)
        /*val toolbar: Toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)*/
        val check_permission: Button = findViewById<View>(R.id.btn1) as Button
        val request_permission: Button = findViewById<View>(R.id.btn2) as Button
        check_permission.setOnClickListener(this)
        request_permission.setOnClickListener(this)

        check_permission.text = "Check if permission already granted"
        request_permission.text = "Ask to grant permission"
    }

    override fun onClick(v: View) {
        view = v
        val id: Int = v.getId()
        when (id) {
            R.id.btn1 -> if (checkPermission()) {
                Snackbar.make(view!!, "Permission already granted.", Snackbar.LENGTH_LONG).show()
            } else {
                Snackbar.make(view!!, "Please request permission.", Snackbar.LENGTH_LONG).show()
            }
            R.id.btn2 -> if (!checkPermission()) {
                requestPermission()
            } else {
                Snackbar.make(view!!, "Permission already granted.", Snackbar.LENGTH_LONG).show()
            }
        }
    }

    private fun checkPermission(): Boolean {
        val result = ContextCompat.checkSelfPermission(applicationContext, ACCESS_FINE_LOCATION)
        val result1 = ContextCompat.checkSelfPermission(applicationContext, CAMERA)
        return result == PackageManager.PERMISSION_GRANTED && result1 == PackageManager.PERMISSION_GRANTED
    }

    private fun requestPermission() {
        requestPermissions(this, arrayOf(ACCESS_FINE_LOCATION, CAMERA), PERMISSION_REQUEST_CODE)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            PERMISSION_REQUEST_CODE -> if (grantResults.size > 0) {
                val locationAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED
                val cameraAccepted = grantResults[1] == PackageManager.PERMISSION_GRANTED
                if (locationAccepted && cameraAccepted) view?.let {
                    Snackbar.make(
                        it,
                        "Permission Granted, Now you can access location data and camera.",
                        Snackbar.LENGTH_LONG
                    ).show()
                } else {
                    view?.let {
                        Snackbar.make(
                            it,
                            "Permission Denied, You cannot access location data and camera.",
                            Snackbar.LENGTH_LONG
                        ).show()
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if (shouldShowRequestPermissionRationale(ACCESS_FINE_LOCATION)) {
                            showMessageOKCancel(
                                "You need to allow access to both the permissions"
                            ) { dialog, which ->
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                    requestPermissions(
                                        arrayOf(
                                            ACCESS_FINE_LOCATION,
                                            CAMERA
                                        ),
                                        PERMISSION_REQUEST_CODE
                                    )
                                }
                            }
                            return
                        }
                    }
                }
            }
        }
    }

    private fun showMessageOKCancel(message: String, okListener: DialogInterface.OnClickListener) {
        AlertDialog.Builder(this@PermissionAskActivity)
            .setMessage(message)
            .setPositiveButton("OK", okListener)
            .setNegativeButton("Cancel", null)
            .create()
            .show()
    }

    companion object {
        private const val PERMISSION_REQUEST_CODE = 200
    }
}