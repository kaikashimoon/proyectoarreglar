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

class instrumentFluter : AppCompatActivity() {

    private lateinit var keysResourseFlauta: Array<Int>
    private lateinit var keysFlauta: Array<Button>

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flauta)
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }

        keysResourseFlauta = arrayOf(
            R.raw.bambooflute535hz,
            R.raw.bambooflute800hz,
            R.raw.bambooflute714hz,
            R.raw.bambooflute607hz,
            R.raw.bambooflute605hz,
            R.raw.bambooflute916hz,
            R.raw.bambooflute1008hz,
            R.raw.bambooflute1077hz

        )
        keysFlauta = arrayOf(
            findViewById(R.id.b1),
            findViewById(R.id.b2),
            findViewById(R.id.b3),
            findViewById(R.id.b4),
            findViewById(R.id.b5),
            findViewById(R.id.b6),
            findViewById(R.id.b7),
            findViewById(R.id.b8)

        )
        keysFlauta.forEach { keyS ->
            val indexKey = keysFlauta.indexOf(keyS)

            val color = (keyS.background as ColorDrawable).color
            keyS.setOnTouchListener { C, Click ->
                val mp = MediaPlayer.create(applicationContext, keysResourseFlauta[indexKey])
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