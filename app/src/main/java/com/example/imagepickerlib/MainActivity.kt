package com.example.imagepickerlib

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.github.dhaval2404.imagepicker.ImagePicker

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var buttonImagePicker = findViewById<Button>(R.id.buttonImagePicker)

        buttonImagePicker.setOnClickListener {
            ImagePicker.with(this)
                .start()
        }


    }
}