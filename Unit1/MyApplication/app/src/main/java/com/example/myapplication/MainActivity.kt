// MainActivity.kt
package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    companion object {
        private const val REQ_CHOOSE_TEXT = 1001 // requestCode để định danh
        const val EXTRA_REPLY = "extra_reply"    // key để nhận dữ liệu trả về
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnOpen = findViewById<Button>(R.id.btnOpenSecond)
        btnOpen.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            // Gửi dữ liệu sang Activity 2
            intent.putExtra("extra_greeting", "Hello from MainActivity")
            // GỌI activity 2 và chờ kết quả
            @Suppress("DEPRECATION")
            startActivityForResult(intent, REQ_CHOOSE_TEXT)
        }
    }

    // Nhận kết quả trả về từ SecondActivity
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQ_CHOOSE_TEXT) {
            val tvResult = findViewById<TextView>(R.id.tvResult)

            if (resultCode == Activity.RESULT_OK && data != null) {
                val reply = data.getStringExtra(EXTRA_REPLY) ?: "(empty)"
                tvResult.text = "Kết quả nhận được: $reply"
            } else if (resultCode == Activity.RESULT_CANCELED) {
                tvResult.text = "Người dùng đã hủy."
            } else {
                tvResult.text = "Không có dữ liệu trả về."
            }
        }
    }
}
