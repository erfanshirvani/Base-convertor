package com.example1.baseconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.content.res.ResourcesCompat
import kotlin.math.pow


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edInput: EditText = findViewById(R.id.txt_input)
        val rbt2to10: RadioButton = findViewById(R.id.rbt_2to10)
        val rbt10to2: RadioButton = findViewById(R.id.rbt_10to2)
        val btnConvert: Button = findViewById(R.id.btn_convert)
        val btnClear: Button = findViewById(R.id.btn_Clear)
        val txtOutput: TextView = findViewById(R.id.txt_output)



        fun convertFrom2to10(num: Long): Int {
            var num = num
            var decimalNumber = 0
            var i = 0
            var remainder: Long

            while (num.toInt() != 0) {
                remainder = num % 10
                num /= 10
                decimalNumber += (remainder * 2.0.pow(i.toDouble())).toInt()
                ++i
            }
            return decimalNumber
        }


        fun convertFrom10to2(num:Int){
            var number:Int = num
            var reminder:Int
            var result: String = ""

            while (number !=0){
                reminder = number % 2
                result =  reminder.toString() + result
                number /= 2
            }
            txtOutput.text = result
        }

        btnConvert.setOnClickListener {

            if (edInput.text.isBlank()){
                Toast.makeText(this, "please enter value", Toast.LENGTH_SHORT).show()

            }
            else{

                if (rbt2to10.isChecked){
                    // Convert 2 to 10
                    val inputNumber: Long = edInput.text.toString().toLong()
                    val decimal = convertFrom2to10(inputNumber)
                    txtOutput.text = decimal.toString()
                }
                else{
                    // Convert 10 to 2
                    var inputNumber: Int = edInput.text.toString().toInt()
                    convertFrom10to2(inputNumber)
                }
            }
        } // end of setOnClickListener

        btnClear.setOnClickListener {
            edInput.text.clear()
            txtOutput.text = ""
            edInput.requestFocus()
        }
    } // end of onCreate
} // end of class







