package com.example.quizapp

object Constants{

    const  val USER_NAME : String = "user_name"
    const val TOTAL_QUESTION : String = "total_question"
    const val CORRECT_ANSWER : String = "correct_answer"


    fun getQuestion() : ArrayList<Question>{

         val questionList = ArrayList<Question>()

        val que1 = Question(1,
            R.drawable.img_chernonbyol,
            "Which of the following city has been abandoned since a catastrophic nuclear accident",
            "Copehill Down",
            "Chernobyl",
            "Ghost town",
            "Alabama",
            2)
        questionList.add(que1)

        val que2 = Question(2,
            R.drawable.football_img,
            "80 percent of  footballs worldwide are produced in",
            "China",
            "England",
            "Pakistan",
            "India",
            3)
        questionList.add(que2)

        val que3 = Question(3,
            R.drawable.maruti_img,
            "In Maruti 800, what does the 800 stand for?",
            "Safety",
            "Wheel diameter",
            "Comfortability",
            "Capacity of engine",
            4)
        questionList.add(que3)

        val que4 = Question(4,
            R.drawable.cricket_img,
            "India won the first World Cup in 1983, against which country ?",
            "Australia",
            " West Indies",
            "New Zealand",
            "Sri Lanka",
            2)
        questionList.add(que4)

        val que5 = Question(5,
            R.drawable.youtube_png,
            "Which is the most watched Youtube video with over 7.05 billion+ views.",
            "Despacito",
            "Shape of You",
            "Baby Shark dance",
            "Gangnam Style",
            3)
        questionList.add(que5)

        val que6 = Question(6,
            R.drawable.unicorn_img,
            "The unicorn is the national animal of which country ?",
            "Scotland",
            "Canada",
            "England",
            "Denmark",
            1
            )
        questionList.add(que6)

        val que7 = Question(7,
            R.drawable.aqua_img,
            "An Indian National Aquatic Animal is",
            "River Dolphin",
            "Bengal fish",
            "Whale",
            "Turtle",
            1
            )
        questionList.add(que7)

        val que8 = Question(8,
            R.drawable.andro_img,
            "What is the andriod 1.6 verison is referred to as",
            "Cupcake",
            "Donut",
            "Kitkat",
            "Eclair",
            2
            )
        questionList.add(que8)

        val que9 = Question(9,
            R.drawable.internet_logo,
            "India's first publicly accessible internet service was introduced by",
            "BSNL",
            "Reliance Com",
            "VSNL",
            "SIFY",
            3
            )
        questionList.add(que9)

        val que10 = Question(10,
            R.drawable.tesla_symbol,
            "Identify the logo",
            "Tata",
            "Tech Mahindra",
            "Titan",
            "Tesla",
            4
            )
        questionList.add(que10)

        return questionList

    }

}