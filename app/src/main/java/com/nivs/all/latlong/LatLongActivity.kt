package com.nivs.all.latlong

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.provider.Settings
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.nivs.all.databinding.ActivityLatlongBinding

//https://www.youtube.com/watch?v=mwzKYIB9cQs

class LatLongActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLatlongBinding
    private lateinit var fusedLocation : FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLatlongBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fusedLocation = LocationServices.getFusedLocationProviderClient(this)

        getYourPermission()

        binding.btn1.visibility = View.INVISIBLE
        binding.btn2.visibility = View.INVISIBLE

    }

    private fun getYourPermission() {
        if(checkAppPermission()){
            if(isYourLocationEnabled()){
                fusedLocation.lastLocation.addOnCompleteListener(this){ task->
                    val location: Location? = task.result
                    if(location==null)
                        Toast.makeText(this, "Not Received", Toast.LENGTH_SHORT).show()
                    else{
                        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
                        binding.textviewLat.text = ""+location.latitude
                        binding.textviewLong.text = ""+location.longitude
                    }
                }
            }else{
                Toast.makeText(this, "Turn on Loc", Toast.LENGTH_SHORT).show()
                val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                startActivity(intent)
            }
        } else {
            requestPermission()
        }
    }

    private fun isYourLocationEnabled(): Boolean {
        val locationManager: LocationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return  locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
    }

    private fun checkAppPermission(): Boolean {
        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            return true
        }
        return false
    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(
            this, arrayOf(android.Manifest.permission.ACCESS_COARSE_LOCATION,
                android.Manifest.permission.ACCESS_FINE_LOCATION),
            PERMISSION_ACCESS_LOCATION
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == PERMISSION_ACCESS_LOCATION){
            if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(applicationContext, "Granted", Toast.LENGTH_SHORT).show()
                getYourPermission()
            } else {
                Toast.makeText(applicationContext, "Denied", Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object{
        private const val PERMISSION_ACCESS_LOCATION = 100
    }
}