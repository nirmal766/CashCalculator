package com.example.cash_calculator

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

import com.example.cash_calculator.cash_calculator.CashCalulator
import com.example.cash_calculator.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText
import java.util.Locale


class MainActivity : AppCompatActivity() {
    lateinit var  sharePreferences:SharedPreferences


    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        sharePreferences = getSharedPreferences(
            getString(R.string.preferences),
            Context.MODE_PRIVATE
        )
        val isLogIn= sharePreferences.getBoolean("isLogin",false)
        if (isLogIn){
            val intent=Intent(this@MainActivity,CashCalulator::class.java)
            startActivity(intent)
            finish()
        }else{

            setContentView(R.layout.activity_main)
            val btnName=findViewById<Button>(R.id.btnName)
            btnName.setOnClickListener {
                val shopNam=findViewById<TextInputEditText>(R.id.Shop_name)
                val ssn= shopNam.text.toString().uppercase(Locale.ROOT)
                if (ssn.isNotEmpty()){
                    savePrefences(ssn)
                    val intent=Intent(this@MainActivity,CashCalulator::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }




    }
    fun savePrefences(tittle:String){
        sharePreferences.edit().putBoolean("isLogin", true).apply()
        sharePreferences.edit().putString("Tittle", tittle).apply()

    }
}
