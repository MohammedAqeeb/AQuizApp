package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val rUserName = intent.getStringExtra(Constants.USER_NAME)
        tvUserName.text=rUserName.toString()

        val rCorrectAnswer = intent.getIntExtra(Constants.CORRECT_ANSWER,0)
        val rTotalQuestion = intent.getIntExtra(Constants.TOTAL_QUESTION,0)

        tvScore.text="You are Total Score $rCorrectAnswer out of $rTotalQuestion"

        btnFinish.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

    }
}
