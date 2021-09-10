package com.example.android4lesson2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.android4lesson2.SecondActivity.Companion.TOTAL_COUNT
import com.example.android4lesson2.SecondActivity.Companion.TOTAL_COUNT1
import com.example.android4lesson2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        click()
        getDataFromSecond()
    }

    private fun getDataFromSecond() {
        val setText = intent.getStringExtra(TOTAL_COUNT1)
        binding.text.setText(setText)
    }


    private fun click() {
        binding.toastButton.setOnClickListener {
            val text = binding.text.text.toString()
            if (text.trim().isEmpty()) {
                Toast.makeText(this, "ТЕКСТ НЕ МОЖЕТ БЫТЬ ПУСТЫМ", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra(TOTAL_COUNT, text)
                    startActivity(intent)
            }
        }
    }
}