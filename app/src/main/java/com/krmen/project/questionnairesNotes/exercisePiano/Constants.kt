package com.krmen.project.questionnairesNotes.exercisePiano

import com.krmen.project.R

object Constants {

    const val TOTAL_QUESTIONS: String = "total_questions"
    const val INCORRECT_ANSWERS: String = "incorrect_answers"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions(): ArrayList<Question>{

        val questionsList=ArrayList<Question>()

        val questionOne = Question(
            2, "¿Qué nota es?",
            R.drawable.re,
            "Fa", "Si",
            "Re", "La", 3
        )

        questionsList.add(questionOne)

        // 3
        val questionTwo= Question(
            3, "¿Qué nota es?",
            R.drawable.mi,
            "Sol", "Do",
            "Fa", "Mi", 4
        )

        questionsList.add(questionTwo)

        // 4
        val questionThre = Question(
            4, "¿Qué nota es?",
            R.drawable.do2,
            "La", "Do",
            "Si", "Re", 2
        )

        questionsList.add(questionThre)

        // 5
        val questionFour = Question(
            5, "¿Qué nota es?",
            R.drawable.mi2,
            "Re", "La",
            "Mi", "Do", 3
        )

        questionsList.add(questionFour)

        val questionFive= Question(1,
            "¿Qué nota es?",
            R.drawable.dodo,
            "Do",
            "Re",
            "Fa",
            "Sol",
            1
        )

        questionsList.add(questionFive)

        return questionsList

    }
}