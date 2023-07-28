package com.example.cash_calculator.cash_calculator

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.cash_calculator.R
import com.google.android.material.textfield.TextInputEditText
import java.util.Locale

lateinit var ed2000: TextInputEditText
lateinit var ed500: EditText
lateinit var ed200: EditText
lateinit var ed100: EditText
lateinit var ed50: EditText
lateinit var ed20: EditText
lateinit var ed10: EditText
lateinit var ed5: EditText
lateinit var ed2: EditText
lateinit var ed1: EditText

lateinit var tv2000: TextView
lateinit var tv500: TextView
lateinit var tv200: TextView
lateinit var tv100: TextView
lateinit var tv50: TextView
lateinit var tv20: TextView
lateinit var tv10: TextView
lateinit var tv5: TextView
lateinit var tv2: TextView
lateinit var tv1: TextView

lateinit var totalSum: TextView
lateinit var totalNum: TextView

lateinit var word: TextView
lateinit var plus: EditText
lateinit var minus: EditText


private  var tts: TextToSpeech?=null

class CashCalulator : AppCompatActivity(), TextToSpeech.OnInitListener {
  var tittle: String?="Cash Calculator"
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences=getSharedPreferences(getString(R.string.preferences),Context.MODE_PRIVATE)
        setContentView(R.layout.activity_cash_calulator)

       // toolbarTittle = getSharedPreferences(getString(R.string.preferences), Context.MODE_PRIVATE)
        tittle=sharedPreferences.getString("Tittle","Cash")
        val tittleHeader=findViewById<TextView>(R.id.name)
          tittleHeader.text=tittle
        ed2000 = findViewById(R.id.Ed2000)
        ed500 = findViewById(R.id.Ed500)
        ed200 = findViewById(R.id.Ed200)
        ed100 = findViewById(R.id.Ed100)
        ed50 = findViewById(R.id.Ed50)
        ed20 = findViewById(R.id.Ed20)
        ed10 = findViewById(R.id.Ed10)
        ed5 = findViewById(R.id.Ed5)
        ed2 = findViewById(R.id.Ed2)
        ed1 = findViewById(R.id.Ed1)



        tv2000 = findViewById(R.id.rst2000)
        tv500 = findViewById(R.id.rst500)
        tv200 = findViewById(R.id.rst200)
        tv100 = findViewById(R.id.rst100)
        tv50 = findViewById(R.id.rst50)
        tv20 = findViewById(R.id.rst20)
        tv10 = findViewById(R.id.rst10)
        tv5 = findViewById(R.id.rst5)
        tv2 = findViewById(R.id.rst2)
        tv1 = findViewById(R.id.rst1)

        totalSum = findViewById(R.id.totalSum)
        totalNum = findViewById(R.id.totalpic)
        word = findViewById(R.id.word)
        plus = findViewById(R.id.plus)
        minus = findViewById(R.id.minuse)




        totalSum.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                numberToWord()
            }

        })

        ed2000.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                tv2000.text = add(ed2000, 2000)

            }

            override fun afterTextChanged(s: Editable?) {}
        })
        ed500.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                tv500.text = add(ed500, 500)
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })
        ed200.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                tv200.text = add(ed200, 200)
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })
        ed100.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                tv100.text = add(ed100, 100)
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })
        ed50.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                tv50.text = add(ed50, 50)
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })
        ed20.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                tv20.text = add(ed20, 20)
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })
        ed10.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                tv10.text = add(ed10, 10)
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })
        ed5.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                tv5.text = add(ed5, 5)
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })
        ed2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                tv2.text = add(ed2, 2)
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })
        ed1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                tv1.text = add(ed1, 1)
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })

        val resultTextWatcher: TextWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val t2000 = tv2000.text.toString().toLongOrNull() ?: 0
                val t500 = tv500.text.toString().toLongOrNull() ?: 0
                val t200 = tv200.text.toString().toLongOrNull() ?: 0
                val t100 = tv100.text.toString().toLongOrNull() ?: 0
                val t50 = tv50.text.toString().toLongOrNull() ?: 0
                val t20 = tv20.text.toString().toLongOrNull() ?: 0
                val t10 = tv10.text.toString().toLongOrNull() ?: 0
                val t5 = tv5.text.toString().toLongOrNull() ?: 0
                val t2 = tv2.text.toString().toLongOrNull() ?: 0
                val t1 = tv1.text.toString().toLongOrNull() ?: 0


                val plus = plus.text.toString().toLongOrNull() ?: 0
                val mis = minus.text.toString().toLongOrNull() ?: 0
                val total = t2000 + t500 + t200 + t100 + t50 + t20 + t10 + t5 + t2 + t1 + plus
                val final = total - mis
                totalSum.text = final.toString()
            }

            override fun afterTextChanged(s: Editable?) {
            }

        }


        tv2000.addTextChangedListener(resultTextWatcher)
        tv500.addTextChangedListener(resultTextWatcher)
        tv200.addTextChangedListener(resultTextWatcher)
        tv100.addTextChangedListener(resultTextWatcher)
        tv50.addTextChangedListener(resultTextWatcher)
        tv20.addTextChangedListener(resultTextWatcher)
        tv10.addTextChangedListener(resultTextWatcher)
        tv5.addTextChangedListener(resultTextWatcher)
        tv2.addTextChangedListener(resultTextWatcher)
        tv1.addTextChangedListener(resultTextWatcher)


        plus.addTextChangedListener(resultTextWatcher)
        minus.addTextChangedListener(resultTextWatcher)

        val totQtr: TextWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val ed2000 = ed2000.text.toString().toLongOrNull() ?: 0
                val ed500 = ed500.text.toString().toLongOrNull() ?: 0
                val ed200 = ed200.text.toString().toLongOrNull() ?: 0
                val ed100 = ed100.text.toString().toLongOrNull() ?: 0
                val ed50 = ed50.text.toString().toLongOrNull() ?: 0
                val ed20 = ed20.text.toString().toLongOrNull() ?: 0
                val ed10 = ed10.text.toString().toLongOrNull() ?: 0
                val ed5 = ed5.text.toString().toLongOrNull() ?: 0
                val ed2 = ed2.text.toString().toLongOrNull() ?: 0
                val ed1 = ed1.text.toString().toLongOrNull() ?: 0
                val totalQtr = ed2000 + ed500 + ed200 + ed100 + ed50 + ed20 + ed10 + ed5 + ed2 + ed1
                totalNum.text = totalQtr.toString()
            }

            override fun afterTextChanged(s: Editable?) {

            }

        }

        ed2000.addTextChangedListener(totQtr)
        ed500.addTextChangedListener(totQtr)
        ed200.addTextChangedListener(totQtr)
        ed100.addTextChangedListener(totQtr)
        ed50.addTextChangedListener(totQtr)
        ed20.addTextChangedListener(totQtr)
        ed10.addTextChangedListener(totQtr)
        ed5.addTextChangedListener(totQtr)
        ed2.addTextChangedListener(totQtr)
        ed1.addTextChangedListener(totQtr)

        /// text Share


        tts = TextToSpeech(this, this@CashCalulator)
        val speak=findViewById<ImageView>(R.id.speak)
       speak.setOnClickListener {
            if (word.text!!.isEmpty()) {
                Toast.makeText(this, "empty", Toast.LENGTH_SHORT).show()
            } else {
                TextToSpeetch(word.text.toString())
            }
        }
    }


    fun numberToWord() {
        val Nagivate = totalSum.text.toString().toLong()
        if (Nagivate > 0) {
            try {
                val totalInNumber = totalSum.text.toString().toLong()
                val textInWord = NumberToWordsConverter.numToWords(totalInNumber)
                word.text = textInWord
            } catch (e: ArithmeticException) {
                Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()

            }
        } else word.text = ""

    }

    private fun TextToSpeetch(text: String) {
        tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, "")
    }

    override fun onDestroy() {
        super.onDestroy()
        if (tts != null) {
            tts?.stop()
            tts?.shutdown()
        }
        //binding = null
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val result = tts!!.setLanguage(Locale.ENGLISH)
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTs", "the languages specified is not supported")
            } else Log.e("TTs", "the languages specified is not supported")
        }
    }


    // comman function
    fun add(num1: EditText, num2: Long): String {
        val no1 = num1.text.toString().toLongOrNull() ?: 0
        val result = (no1 * num2).toString()
        return result
    }

    fun shareText(view: View) {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, StringText())
            type = "text/rtf"
        }
        println("hello")
        val shareIntent = Intent.createChooser(sendIntent, "null")
        startActivity(shareIntent)
    }

    fun StringText(): String {

        val t2000 = tv2000.text.toString()
        val t500 = tv500.text.toString()
        val t200 = tv200.text.toString()
        val t100 = tv100.text.toString()
        val t50 = tv50.text.toString()
        val t20 = tv20.text.toString()
        val t10 = tv10.text.toString()
        val t5 = tv5.text.toString()
        val t2 = tv2.text.toString()
        val t1 = tv1.text.toString()
        val ttlAmount = totalSum.text.toString()
        val wordTxt = word.text.toString()


        val et2000 = ed2000.text.toString()
        val et500 = ed500.text.toString()
        val et200 = ed200.text.toString()
        val et100 = ed100.text.toString()
        val et50 = ed50.text.toString()
        val et20 = ed20.text.toString()
        val et10 = ed10.text.toString()
        val et5 = ed5.text.toString()
        val et2 = ed2.text.toString()
        val et1 = ed1.text.toString()
        return " $tittle \n" +
                "Words:- $wordTxt \n" +
                "2000 X $et2000 = $t2000 \n" +
                "500 x $et500 =   $t500 \n" +
                "200 x $et200 =   $t200 \n" +
                "100 x $et100 =   $t100\n" +
                "50  x $et50  =   $t50\n" +
                "20  x $et20  =   $t20\n" +
                "10  x $et10  =   $t10\n" +
                "5   x $et5   =   $t5\n" +
                "2   x $et2   =   $t2\n" +
                "1   x $et1   =   $t1\n" +
                "total amount =   $ttlAmount"
    }

    fun SupportBar(tittle: String) {
       // setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.title = tittle
    }
}