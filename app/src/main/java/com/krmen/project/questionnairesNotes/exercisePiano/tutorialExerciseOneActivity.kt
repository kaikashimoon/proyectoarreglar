package com.krmen.project.questionnairesNotes.exercisePiano

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.krmen.project.R
import com.krmen.project.questionnairesNotes.ResultActivity
import kotlinx.android.synthetic.main.activity_tutorial_notes.*
import java.util.Random
class tutorialExerciseOneActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mCorrectAnswers: Int = 0
    private var mIncorrectAnswers: Int = 0
    private var mSelectedOptionPosition: Int = 0
    private var randomValue: Int = 0
    private var mQuestionsList: ArrayList<Question> = ArrayList()
    private var mSelectionEventClick: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_tutorial_notes)
        mQuestionsList = Constants.getQuestions()

        setQuestion()

        btnOptionOne.setOnClickListener(this)
        btnOptionTwo.setOnClickListener(this)
        btnOptionThree.setOnClickListener(this)
        btnOptionFour.setOnClickListener(this)

        buttonSubmit.setOnClickListener(this)

    }

    override fun onClick(v: View?) {

        when (v?.id) {

            R.id.btnOptionOne -> {
                mSelectionEventClick = "Yes"
                selectedOptionView(btnOptionOne, 1)
            }

            R.id.btnOptionTwo -> {
                mSelectionEventClick = "Yes"
                selectedOptionView(btnOptionTwo, 2)
            }

            R.id.btnOptionThree -> {
                mSelectionEventClick = "Yes"
                selectedOptionView(btnOptionThree, 3)
            }

            R.id.btnOptionFour -> {
                mSelectionEventClick = "Yes"
                selectedOptionView(btnOptionFour, 4)
            }

            R.id.buttonSubmit -> {
                if (mSelectionEventClick.isEmpty()) {
                    Toast.makeText(this, "debe de Selecionar una Opcion", Toast.LENGTH_SHORT).show()
                }else{

                    if (mSelectedOptionPosition == 0) {

                        mCurrentPosition++

                        when {

                            mCurrentPosition <= mQuestionsList!!.size -> {

                                setQuestion()
                            }
                            else -> {
                                routeView(1)
                            }
                        }
                    } else {

                        val question = mQuestionsList?.get(mCurrentPosition - 1)

                        if (question!!.correctAnswer != mSelectedOptionPosition) {
                            answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                            incorrectAnswers()
                        } else {
                            mCorrectAnswers++
                        }

                        answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                        if (mCurrentPosition == mQuestionsList!!.size) {
                            buttonSubmit.text = "Completado"
                        } else {
                            buttonSubmit.text = "Siguiente pregunta"
                        }

                        mSelectedOptionPosition = 0
                    }
                }
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setTitle("Seguro que desea salir del tutorial?")
        dialogBuilder.setMessage("ALERTA: al salir del tutorial los datos no seran guardados.")
            .setCancelable(false)
            .setPositiveButton("Proceed", DialogInterface.OnClickListener {
                    dialog, id ->
                startActivity(Intent(this, tutorialExerciseOneActivity::class.java))
                finish()
            })
            .setNegativeButton("Cancel", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
        val alert = dialogBuilder.create()
        alert.show()
    }

    private fun incorrectAnswers() {
        mIncorrectAnswers++
        incorretCount.text = mIncorrectAnswers.toString()
        Toast.makeText(applicationContext, "Respuesta Incorrecta", Toast.LENGTH_LONG).show()
        defaultOptionsView()
        if (mIncorrectAnswers > 3) {
            routeView(2)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setQuestion() {
        getRandom()
        val question = mQuestionsList!![randomValue]

        defaultOptionsView()

        if (mCurrentPosition == mQuestionsList!!.size) {
            buttonSubmit.text = "Completado"
        } else {
            buttonSubmit.text = "Siguiente"
        }

        progressBar.progress = mCurrentPosition
        progressBarTutorial.text = "$mCorrectAnswers" + "/" + progressBar.getMax()

        iv_image.setImageResource(question.image)
        tv_question.text = question.question
        btnOptionOne.text = question.optionOne
        btnOptionTwo.text = question.optionTwo
        btnOptionThree.text = question.optionThree
        btnOptionFour.text = question.optionFour
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {

        defaultOptionsView()

        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(
            Color.parseColor("#363A43")
        )
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this@tutorialExerciseOneActivity,
            R.drawable.selected_option_border_bg
        )
    }

    private fun defaultOptionsView() {

        val options = ArrayList<TextView>()
        options.add(0, btnOptionOne)
        options.add(1, btnOptionTwo)
        options.add(2, btnOptionThree)
        options.add(3, btnOptionFour)
        mSelectionEventClick= ""
        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this@tutorialExerciseOneActivity,
                R.drawable.default_option_border_bg
            )
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {

        when (answer) {

            1 -> {
                btnOptionOne.background = ContextCompat.getDrawable(
                    this@tutorialExerciseOneActivity,
                    drawableView
                )
            }
            2 -> {
                btnOptionTwo.background = ContextCompat.getDrawable(
                    this@tutorialExerciseOneActivity,
                    drawableView
                )
            }
            3 -> {
                btnOptionThree.background = ContextCompat.getDrawable(
                    this@tutorialExerciseOneActivity,
                    drawableView
                )
            }
            4 -> {
                btnOptionFour.background = ContextCompat.getDrawable(
                    this@tutorialExerciseOneActivity,
                    drawableView
                )
            }
        }
    }

    private fun routeView(x: Int) {

        if (x == 1) {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
            intent.putExtra(Constants.INCORRECT_ANSWERS, mIncorrectAnswers)
            startActivity(intent)
            finish()
        } else if (x == 2) {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
            intent.putExtra(Constants.INCORRECT_ANSWERS, mIncorrectAnswers)
            startActivity(intent)
            finish()
        }
    }

    private fun getRandom() {
        val random = Random()
        randomValue = random.nextInt(mQuestionsList.count())
        mQuestionsList.removeAt(randomValue)
    }


}
