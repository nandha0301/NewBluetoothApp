package com.nandhu.onedatabluetoothapp

import android.Manifest.permission.BLUETOOTH_CONNECT
import android.Manifest.permission.BLUETOOTH_SCAN
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.getSystemService

class MainActivity : AppCompatActivity() {

    lateinit var apicall_btn : Button
    lateinit var bluetooth_btn : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        apicall_btn = findViewById(R.id.apicall_btn)
        bluetooth_btn =findViewById(R.id.bluetooth_btn)



        apicall_btn.setOnClickListener {

            val intent = Intent(this,ApiActivity::class.java)
            startActivity(intent)
        }

        bluetooth_btn.setOnClickListener {

            val intent = Intent(this,BluetoothActivity::class.java)
            startActivity(intent)
        }


        }

    }
