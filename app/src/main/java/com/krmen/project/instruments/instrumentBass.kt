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

class instrumentBass : AppCompatActivity() {

    private lateinit var keysResourseBajo: Array<Int>
    private lateinit var keysBajo: Array<Button>

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bajo)

        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }

        keysResourseBajo = arrayOf(
            R.raw.d1e2bajo,
            R.raw.d1chartbajo,
            R.raw.c1d1bajo,
            R.raw.c1c1bajo,
            R.raw.b1bajo,
            R.raw.a1b1bajo,
            R.raw.a1bajo,
            R.raw.g1a1bajo,
            R.raw.g1bajo,
            R.raw.f1bajo,
            R.raw.f1chartbajo,
            R.raw.e1bajo,
            R.raw.d1d1bajo,
            R.raw.chart2dbajo,
            R.raw.c1d1bajo1,
            R.raw.b1c1bajo,
            R.raw.a1a1bajo,
            R.raw.a1chartbajo,
            R.raw.a1c1bajo,
            R.raw.g1bajoa1,

            R.raw.a2chartbajo,
            R.raw.a2baa2jo,
            R.raw.g2bajo,
            R.raw.f2bajo,
            R.raw.e2bajo,
            R.raw.d2d2d2bajo,
            R.raw.g2bajog2,
            R.raw.c2bajobajo,
            R.raw.c2c2c2bajo,
            R.raw.b2bajo,
            R.raw.a2bajoa2,
            R.raw.a2bajo,
            R.raw.bajoe1f1,
            R.raw.g3chartbajo,
            R.raw.g3bajo,
            R.raw.f2bajobajo,
            R.raw.e2e2e2bajo,
            R.raw.d2bajo,
            R.raw.f2f2bajo,
            R.raw.d2chartbajo,

            R.raw.f3bajo,
            R.raw.a3bajo,
            R.raw.g1chartbajo,
            R.raw.f3chartbajo,
            R.raw.e3e3e3bajo,
            R.raw.d3bajo,
            R.raw.d3chartbajo,
            R.raw.c3bajo,
            R.raw.c3bajo,
            R.raw.b3bajo,
            R.raw.a3bajo,
            R.raw.a3chartbajo,
            R.raw.c3chartbajo,
            R.raw.d4bajo,
            R.raw.d4chartbajo,
            R.raw.c5bajo,
            R.raw.f1f1bajo,
            R.raw.b1c1chartbajo,
            R.raw.f2chartbajo,
            R.raw.g2chartbajo,

            R.raw.c4bajo,
            R.raw.b4bajo,
            R.raw.a4bajo,
            R.raw.a4chartbajo,
            R.raw.g4bajo,
            R.raw.f4bajo,
            R.raw.e4chartbajo,
            R.raw.c4chartbajo,
            R.raw.f4chartbajo,
            R.raw.c2chartbajo,
            R.raw.e1f1bajo,
            R.raw.a1g1bajo,
            R.raw.d1e2bajo,
            R.raw.d1chartbajo,
            R.raw.c1d1bajo,
            R.raw.c1c1bajo,
            R.raw.b1bajo,
            R.raw.a1b1bajo,
            R.raw.a1bajo,
            R.raw.g1a1bajo,
            R.raw.g1bajo,

            R.raw.d3chartbajo,
            R.raw.c3bajo,
            R.raw.c3bajo,
            R.raw.b3bajo,
            R.raw.a3bajo


        )
        keysBajo = arrayOf(
            findViewById(R.id.bb94),
            findViewById(R.id.bb95),
            findViewById(R.id.bb96),
            findViewById(R.id.bb97),
            findViewById(R.id.bb98),
            findViewById(R.id.bb99),
            findViewById(R.id.bb100),
            findViewById(R.id.bb101),
            findViewById(R.id.bb102),
            findViewById(R.id.bb103),
            findViewById(R.id.bb104),
            findViewById(R.id.bb105),
            findViewById(R.id.bb106),
            findViewById(R.id.bb107),
            findViewById(R.id.bb108),
            findViewById(R.id.bb109),
            findViewById(R.id.bb110),
            findViewById(R.id.bb111),
            findViewById(R.id.bb112),
            findViewById(R.id.bb113),
            findViewById(R.id.bb114),
            findViewById(R.id.bb115),
            findViewById(R.id.bb116),
            findViewById(R.id.bb117),
            findViewById(R.id.bb118),
            findViewById(R.id.bb119),
            findViewById(R.id.bb120),
            findViewById(R.id.bb121),
            findViewById(R.id.bb122),
            findViewById(R.id.bb123),
            findViewById(R.id.bb124),
            findViewById(R.id.bb125),
            findViewById(R.id.bb126),
            findViewById(R.id.bb127),
            findViewById(R.id.bb128),
            findViewById(R.id.bb129),
            findViewById(R.id.bb130),
            findViewById(R.id.bb131),
            findViewById(R.id.bb132),
            findViewById(R.id.bb133),
            findViewById(R.id.bb134),
            findViewById(R.id.bb135),
            findViewById(R.id.bb136),
            findViewById(R.id.bb137),
            findViewById(R.id.bb138),
            findViewById(R.id.bb139),
            findViewById(R.id.bb140),
            findViewById(R.id.bb142),
            findViewById(R.id.bb143),
            findViewById(R.id.bb144),
            findViewById(R.id.bb145),
            findViewById(R.id.bb146),
            findViewById(R.id.bb147),
            findViewById(R.id.bb148),
            findViewById(R.id.bb149),
            findViewById(R.id.bb150),
            findViewById(R.id.bb151),
            findViewById(R.id.bb152),
            findViewById(R.id.bb153),
            findViewById(R.id.bb154),
            findViewById(R.id.bb155),
            findViewById(R.id.bb156),
            findViewById(R.id.bb157),
            findViewById(R.id.bb158),
            findViewById(R.id.bb159),
            findViewById(R.id.bb160),
            findViewById(R.id.bb161),
            findViewById(R.id.bb162),
            findViewById(R.id.bb163),
            findViewById(R.id.bb164),
            findViewById(R.id.bb165),
            findViewById(R.id.bb166),
            findViewById(R.id.bb167),
            findViewById(R.id.bb168),
            findViewById(R.id.bb169),
            findViewById(R.id.bb170),
            findViewById(R.id.bb3),
            findViewById(R.id.bb4),
            findViewById(R.id.bb5),
            findViewById(R.id.bb6),

        )



        keysBajo.forEach { keyS ->
            val indexKey = keysBajo.indexOf(keyS)

            val color = (keyS.background as ColorDrawable).color
            keyS.setOnTouchListener { C, Click ->
                val mp = MediaPlayer.create(applicationContext, keysResourseBajo[indexKey])
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