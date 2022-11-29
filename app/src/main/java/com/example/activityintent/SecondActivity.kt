package com.example.activityintent

import android.Manifest
import android.Manifest.permission.CALL_PHONE
import android.content.Intent
import android.content.Intent.ACTION_CALL
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

class SecondActivity: AppCompatActivity(R.layout.activity_second) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val number: TextView =findViewById<TextView>(R.id.tvNumberCall)
        val buttonToCall: Button = findViewById(R.id.btnCall)

        var numberFromFirstActivity :String = intent.getStringExtra("number").toString()
        number.setText("Вызвать \n $numberFromFirstActivity ?")

        val numberForCall ="+7"+numberFromFirstActivity

        buttonToCall.setOnClickListener() {

            val intentNumber = Intent (ACTION_CALL)
            intentNumber.data = Uri.parse ("tel:" + numberForCall)

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                startActivity (intentNumber)
            }
        }
    }
}