package com.krmen.project.questionnairesNotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.krmen.project.R
import com.krmen.project.menu.navBarIntentoNotes
import com.krmen.project.questionnairesNotes.exercisePiano.Constants
import com.krmen.project.questionnairesNotes.exercisePiano.tutorialExerciseOneActivity
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val correctAnswers=intent.getIntExtra(Constants.CORRECT_ANSWERS,0)
        val incorrectAnswers=intent.getIntExtra(Constants.INCORRECT_ANSWERS,0)
        val scoreCount = (correctAnswers * 100)-(incorrectAnswers * 25)
        incorrectAnswersText.text = "el numero de Respuestas Fallidas es: $incorrectAnswers"
        score.text = "Tu puntaje es: $scoreCount "
        btn_finish.setOnClickListener{
            startActivity(Intent(this, navBarIntentoNotes::class.java))
            finish()
        }
    }

    override fun onBackPressed() {
    super.onBackPressed()
        startActivity(Intent(this, tutorialExerciseOneActivity::class.java))
        finish()
    }
}