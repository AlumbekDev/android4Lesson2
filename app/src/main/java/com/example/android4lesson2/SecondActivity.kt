package com.example.android4lesson2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.android4lesson2.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        click()
        getDataFromMain()
    }

    private fun click() {
        binding.acButton.setOnClickListener {
            val text = binding.text2.text.toString()
            if (text.trim().isEmpty()) {
                Toast.makeText(this, "ТЕКСТ НЕ МОЖЕТ БЫТЬ ПУСТЫМ", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra(TOTAL_COUNT1, text)
                startActivity(intent)
            }
        }
    }

    private fun getDataFromMain() {
        val getText = intent.getStringExtra(TOTAL_COUNT)
        binding.text2.setText(getText)
    }

    companion object{
        const val TOTAL_COUNT = "name"
        const val TOTAL_COUNT1 = "fame"
    }
}