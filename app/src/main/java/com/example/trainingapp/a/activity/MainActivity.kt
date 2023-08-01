package com.example.trainingapp.a.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.trainingapp.R

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById<TextView>(R.id.txtAware)
        textView.text = "Hello Abhishek Here!"
        val btn = findViewById<Button>(R.id.btn1)
        btn.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            startActivity(intent)
        })
        Toast.makeText(this, "onCreate MainActivity", Toast.LENGTH_LONG).show()
        Log.d(TAG, "onCreate")
    }
    override fun onStart() {
        Toast.makeText(this, "onStart MainActivity", Toast.LENGTH_LONG).show()
        Log.d(TAG, "MainActivity onStart")
        super.onStart()
    }

    override fun onPause() {
        Toast.makeText(this, "onPause MainActivity", Toast.LENGTH_LONG).show()
        Log.d(TAG, "MainActivity onPause")
        super.onPause()
    }

    override fun onResume() {
        Toast.makeText(this, "onResume MainActivity", Toast.LENGTH_LONG).show()
        Log.d(TAG, "MainActivity onResume")
        super.onResume()
    }

    override fun onStop() {
        Toast.makeText(this, "onStop MainActivity", Toast.LENGTH_LONG).show()
        Log.d(TAG, "onStop MainActivity")
        super.onStop()
    }

    override fun onRestart() {
        Toast.makeText(this, "onRestart MainActivity", Toast.LENGTH_LONG).show()
        Log.d(TAG, "onRestart MainActivity")
        super.onRestart()
    }

    override fun onDestroy() {
        Toast.makeText(this, "onDestroy MainActivity", Toast.LENGTH_LONG).show()
        Log.d(TAG, "onDestroy MainActivity")
        super.onDestroy()
    }
}