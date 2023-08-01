package com.example.trainingapp.a.activity

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.trainingapp.R
import com.example.trainingapp.a.fragment.MapsFragment
import com.example.trainingapp.a.fragment.ResultFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        //        name=findViewById(R.id.name);
//        age=findViewById(R.id.age);
//        dob=findViewById(R.id.dob);
//        SharedPreferences sharedPreferences=getSharedPreferences("MySharedPref",MODE_PRIVATE);
//        name.setText(sharedPreferences.getString("name",""));
//        age.setText(sharedPreferences.getString("age",""));
//        dob.setText(sharedPreferences.getString("dob",""));
        val back=findViewById<ImageView>(R.id.backBtn)
        back.setOnClickListener {
            finish()
        }
        val navigationView = findViewById<BottomNavigationView>(R.id.bottomBar)
//        navigationView.setOnItemSelectedListener(this);
        //        navigationView.setOnItemSelectedListener(this);
        supportFragmentManager.beginTransaction().replace(R.id.container, ResultFragment()).commit()
        navigationView.setOnItemSelectedListener(NavigationBarView.OnItemSelectedListener { item ->
            var fragment: Fragment? = null
            when (item.itemId) {
                R.id.result -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, ResultFragment()).commit()
                    return@OnItemSelectedListener true
                }

                R.id.navigation -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, MapsFragment()).commit()
                    return@OnItemSelectedListener true
                }

                else -> fragment = ResultFragment()
            }
            false
        })

    }

}