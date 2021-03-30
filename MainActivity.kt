package org.hyperskill.calculator.tip

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.slider.Slider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var editText: EditText = findViewById(R.id.edit_text)
        var slider: Slider = findViewById(R.id.slider)
        var textInput: TextView = findViewById(R.id.text_view)
        var sliderData = 0
        var editTextData = 0.0

        editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (s.toString() == "") {
                    textInput.text = ""
                } else {
                    editTextData = s.toString().toDouble()
                    textInput.text = "Tip amount: ${String.format("%.2f", ((editTextData * sliderData) / 100))}"
                }

            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
        slider.addOnChangeListener { _, value, _ ->
            sliderData = value.toInt()
            if (textInput.text !== "") {
                textInput.text = "Tip amount: ${String.format("%.2f", ((editTextData * sliderData) / 100))}"
            }
        }
    }




}