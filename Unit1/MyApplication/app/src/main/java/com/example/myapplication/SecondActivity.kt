// SecondActivity.kt
package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // (tuỳ chọn) nhận dữ liệu từ Activity 1
        val greeting = intent.getStringExtra("extra_greeting")

        val edt = findViewById<EditText>(R.id.edtReply)
        val btnOk = findViewById<Button>(R.id.btnOk)
        val btnCancel = findViewById<Button>(R.id.btnCancel)

        // Trả dữ liệu về Activity gốc
        btnOk.setOnClickListener {
            val replyText = edt.text.toString().ifBlank { "No input" }
            val replyIntent = Intent().apply {
                putExtra(MainActivity.EXTRA_REPLY, replyText)
            }
            setResult(Activity.RESULT_OK, replyIntent)
            finish() // kết thúc Activity 2, đẩy khỏi stack → quay về Activity 1
        }

        // Hủy và không trả data
        btnCancel.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }
}
