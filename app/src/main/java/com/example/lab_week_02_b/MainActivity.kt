package com.example.lab_week_02_b

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.*
import com.google.android.material.textfield.TextInputEditText
import android.content.Intent

class MainActivity : AppCompatActivity() {
    companion object {
        private const val COLOR_KEY = "COLOR_KEY"
    }

    private val submitButton: Button
        get() = findViewById(R.id.submit_button)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        submitButton.setOnClickListener{
            val colorCode =
                findViewById<TextInputEditText>(R.id.color_code_input_field).text.toString()

            if(colorCode.isNotEmpty()){
                if (colorCode.length < 6){
                    Toast
                        .makeText(this,
                            getString(R.string.color_code_input_wrong_length), Toast.LENGTH_LONG)
                        .show()
                }
                else{
                    val ResultIntent = Intent(this, ResultActivity::class.java)
                    ResultIntent.putExtra(COLOR_KEY, colorCode)
                    startActivity(ResultIntent)
                }
            }
            else{
                Toast
                    .makeText(this, getString(R.string.color_code_input_empty),
                        Toast.LENGTH_LONG)
                    .show()
            }
        }
    }
}

//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
//    }
//}