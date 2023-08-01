package com.example.trainingapp.a.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.trainingapp.R
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.textfield.TextInputEditText

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val edname = findViewById<TextInputEditText>(R.id.edName)
        val edage = findViewById<TextInputEditText>(R.id.edAge)
        val save = findViewById<Button>(R.id.saveBtn)
        val view = findViewById<Button>(R.id.viewBtn)
        val editText = findViewById<TextView>(R.id.dobPicker)
        val materialDateBuilder: MaterialDatePicker.Builder<*> =
            MaterialDatePicker.Builder.datePicker()
        materialDateBuilder.setTitleText("Select date")
        val materialDatePicker = materialDateBuilder.build()
        editText.setOnClickListener { //                calendar= Calendar.getInstance();
            //                year=calendar.get(Calendar.YEAR);
            //                month =calendar.get(Calendar.MONTH);
            //                dayOfMonth=calendar.get(Calendar.DAY_OF_MONTH);
            //                datePickerDialog=new DatePickerDialog(SecondActivity.this, new DatePickerDialog.OnDateSetListener() {
            //                    @Override
            //                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
            //                       editText.setText(day + "/" + (month + 1) + "/" + year);
            //                    }
            //                },year,month,dayOfMonth);
            //                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
            //                datePickerDialog.show();
            materialDatePicker.show(supportFragmentManager, "Date_Picker")
        }
        materialDatePicker.addOnPositiveButtonClickListener {
            editText.text = materialDatePicker.headerText
        }
        materialDatePicker.addOnCancelListener { editText.text = "" }
        save.setOnClickListener {
            val name = edname.text.toString()
            val age = edage.text.toString()
            val dob = editText.text.toString()
            if (name.isEmpty()) {
                Toast.makeText(applicationContext, "Please enter the name!!", Toast.LENGTH_LONG)
                    .show()
            } else if (age.isEmpty()) {
                Toast.makeText(applicationContext, "Please enter the age!!", Toast.LENGTH_LONG)
                    .show()
            } else if (dob.isEmpty()) {
                Toast.makeText(applicationContext, "Please enter the dob!!", Toast.LENGTH_LONG)
                    .show()
            } else {
                val sharedPreferences =
                    getSharedPreferences("MySharedPref", MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putString("name", name)
                editor.putString("age", age)
                editor.putString("dob", dob)
                editor.commit()
                Log.d("saved", "data")
            }
        }
        view.setOnClickListener {
            edname.text!!.clear()
            edage.text!!.clear()
            editText.text = ""
            val i = Intent(this@SecondActivity, ThirdActivity::class.java)
            startActivity(i)
        }
    }

}