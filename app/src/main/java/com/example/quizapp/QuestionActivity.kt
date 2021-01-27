package com.example.quizapp


import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_question.*

class QuestionActivity : AppCompatActivity () , View.OnClickListener {


    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOption: Int = 0
    private var mCorrectAnswer : Int = 0
    private var mUSERNAME :String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        mUSERNAME = intent.getStringExtra(Constants.USER_NAME)

        mQuestionList = Constants.getQuestion()
        setQuestion()

        tvOptionOne.setOnClickListener(this)
        tvOptionTwo.setOnClickListener(this)
        tvOptionThree.setOnClickListener(this)
        tvOptionFour.setOnClickListener(this)
        btnNext.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {

            R.id.tvOptionOne -> {
                selectedOptionView(tvOptionOne, 1)
            }
            R.id.tvOptionTwo -> {
                selectedOptionView(tvOptionTwo, 2)
            }
            R.id.tvOptionThree -> {
                selectedOptionView(tvOptionThree, 3)
            }
            R.id.tvOptionFour -> {
                selectedOptionView(tvOptionFour, 4)
            }
            R.id.btnNext -> {
                if(mSelectedOption == 0) {
                    mCurrentPosition++

                    when {
                        mCurrentPosition <= mQuestionList!!.size -> {
                            setQuestion()
                        }
                        else -> {

                            val intents = Intent(this,ResultActivity::class.java)
                            intents.putExtra(Constants.USER_NAME,mUSERNAME)
                            intents.putExtra(Constants.CORRECT_ANSWER,mCorrectAnswer)
                            intents.putExtra(Constants.TOTAL_QUESTION,mQuestionList!!.size)
                            startActivity(intents)
                            finish()

                        }

                    }
                }else{
                    val question = mQuestionList?.get(mCurrentPosition - 1)
                    if(question!!.correctAnswer != mSelectedOption){
                        answerView(mSelectedOption, R.drawable.wrong_option_bg)
                    }else{
                        mCorrectAnswer++
                    }
                        answerView(question.correctAnswer, R.drawable.right_option_bg)

                    if(mCurrentPosition == mQuestionList!!.size){

                        btnNext.text="FINISH"
                    }
                    else{
                        btnNext.text="GO TO NEXT QUESTION"
                    }
                    mSelectedOption=0
                }
            }
        }
    }

    private fun answerView( answer : Int , drawableView : Int){
        when(answer){
            1 -> {
                tvOptionOne.background= ContextCompat.getDrawable(this,drawableView)
            }
            2->{
                tvOptionTwo.background = ContextCompat.getDrawable(this,drawableView)
            }
            3->{
                tvOptionThree.background = ContextCompat.getDrawable(this,drawableView)
            }
            4->{
            tvOptionFour.background = ContextCompat.getDrawable(this,drawableView)
            }
        }
    }


    private fun setQuestion() {

        val question = mQuestionList!![mCurrentPosition - 1]

        defaultOptions()

        if(mCurrentPosition == mQuestionList!!.size){

            btnNext.text="FINISH"
        }
        else{
            btnNext.text="SUBMIT"
        }

        progressBar.progress = mCurrentPosition
        tvProgress.text = "$mCurrentPosition" + "/" + progressBar.max

        tvQuestions.text = question.question
        iv_image.setImageResource(question.image)

        tvOptionOne.text = question.optionOne
        tvOptionTwo.text = question.optionTwo
        tvOptionThree.text = question.optionThree
        tvOptionFour.text = question.optionFour
    }

    private fun defaultOptions() {

        val options = ArrayList<TextView>()
        options.add(0, tvOptionOne)
        options.add(1, tvOptionTwo)
        options.add(2, tvOptionThree)
        options.add(3, tvOptionFour)

        for (option in options) {
            option.setTextColor(Color.parseColor("#FF8000"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_bg)
        }

    }

    private fun selectedOptionView(tv: TextView, mSelectedOptionNumber: Int) {

        defaultOptions()
        mSelectedOption = mSelectedOptionNumber

        tv.setTextColor(Color.parseColor("#0000FF"))
        tv.setTypeface(tv.typeface, Typeface.BOLD_ITALIC)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_bg)

    }
}

