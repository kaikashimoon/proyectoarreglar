package com.krmen.project.instruments

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.Button
import com.krmen.project.R
import java.util.*
import kotlin.concurrent.schedule

class instrumentHarmonica : AppCompatActivity() {

    private lateinit var keysResourseArmonica: Array<Int>
    private lateinit var keysArmonica: Array<Button>
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_armonica)
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }

        keysResourseArmonica = arrayOf(
            R.raw.carmonica,
            R.raw.earmonica,
            R.raw.garmonica,
            R.raw.darmonica,
            R.raw.farmonica,
            R.raw.g2armonica,
            R.raw.barmonica,
            R.raw.e2armonica,
            R.raw.f2armonica,
            R.raw.aarmonica
        )
        keysArmonica = arrayOf(
            findViewById(R.id.cArmonica1),
            findViewById(R.id.eArmonica2),
            findViewById(R.id.gArmonica3),
            findViewById(R.id.dArmonica4),
            findViewById(R.id.fArmonica5),
            findViewById(R.id.g2Armonica6),
            findViewById(R.id.bArmonica7),
            findViewById(R.id.e2Armonica8),
            findViewById(R.id.f2Armonica9),
            findViewById(R.id.aArmonica10),
        )



        keysArmonica.forEach { keyS ->
            val indexKey = keysArmonica.indexOf(keyS)

            val color = (keyS.background as ColorDrawable).color
            keyS.setOnTouchListener { C, Click ->
                val mp = MediaPlayer.create(applicationContext, keysResourseArmonica[indexKey])
                when (Click?.action) {
                    MotionEvent.ACTION_DOWN, MotionEvent.ACTION_HOVER_ENTER, MotionEvent.ACTION_HOVER_MOVE, MotionEvent.ACTION_POINTER_DOWN -> {
                        keyS.setBackgroundColor(Color.GRAY)
                        keyS.invalidate()
                        mp.start()
                        Timer().schedule(2500) {
                            mp.stop()
                            mp.reset()
                            mp.release()
                        }
                    }
                    MotionEvent.ACTION_UP -> {
                        Timer().schedule(100) {
                            keyS.setBackgroundColor(color)
                            keyS.invalidate()
                        }
                    }


                }
                C?.onTouchEvent(Click) ?: true

            }
        }

    }
}