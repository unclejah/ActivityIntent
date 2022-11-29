package com.example.activityintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonToActivity: Button = findViewById(R.id.btnToActivity)
        val editNumber: EditText = findViewById(R.id.editNumber)

        buttonToActivity.setOnClickListener() {

            val number = editNumber.getText().toString()
                val intent = Intent(this, SecondActivity::class.java)
                Intent(intent)
                intent.putExtra("number", number)
                startActivity(intent);
        }
    }
}