package com.nandhu.onedatabluetoothapp

import android.annotation.SuppressLint
import android.app.Activity
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class BluetoothActivity : AppCompatActivity() {

    private val MY_PERMISSIONS_REQUEST_BLUETOOTH_CONNECT = 123


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bluetooth)


        val tvName = findViewById<TextView>(R.id.nameTv)


        val tvMac = findViewById<TextView>(R.id.macAddressTv)


        val btn = findViewById<Button>(R.id.btnGet)


        val bAdapter = BluetoothAdapter.getDefaultAdapter()


        checkBluetoothPermission()
        btn.setOnClickListener {



            if (bAdapter == null) {
                Toast.makeText(applicationContext, "Bluetooth Not Supported", Toast.LENGTH_SHORT).show()
            } else {
                // Arraylist of all the bonded (paired) devices
                val pairedDevices = bAdapter.bondedDevices
                if (pairedDevices.size > 0) {
                    for (device in pairedDevices) {

                        // get the device name
                        val deviceName = device.name

                        // get the mac address
                        val macAddress = device.address

                        // append in the two separate views
                        tvName.append("$deviceName\n")
                        tvMac.append("$macAddress\n")
                    }
                }
            }
        }
    }

    private fun checkBluetoothPermission() {
        // Check if the permission is not granted
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.BLUETOOTH_CONNECT)
            != PackageManager.PERMISSION_GRANTED) {
            // Request the permission
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.BLUETOOTH_CONNECT),
                MY_PERMISSIONS_REQUEST_BLUETOOTH_CONNECT
            )
        } else {
            // Permission already granted, you can now perform Bluetooth operations
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            MY_PERMISSIONS_REQUEST_BLUETOOTH_CONNECT -> {
                // Check if the permission was granted
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    // Permission granted, you can now perform Bluetooth operations
                } else {
                    // Permission denied, handle accordingly (e.g., inform the user)
                }
                return
            }
            // Handle other permission requests if needed
            // ...
        }
    }
}