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

class instrumentGuitar : AppCompatActivity() {

    private lateinit var keysResourseGuitarra: Array<Int>
    private lateinit var keysGuitarra: Array<Button>

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guitarra)
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }

        keysResourseGuitarra = arrayOf(
            R.raw.e1v1guitarra,
            R.raw.e1v2guitarra,
            R.raw.e1v3guitarra,
            R.raw.e1v4guitarra,
            R.raw.e1v5guitarra,
            R.raw.e2v1guitarra,
            R.raw.e2v2guitarra,
            R.raw.e2v3guitarra,
            R.raw.e2v4guitarra,
            R.raw.e2v5guitarra,
            R.raw.e3v1guitarra,
            R.raw.e3v2guitarra,
            R.raw.e3v3guitarra,
            R.raw.e3v4guitarra,
            R.raw.e3v5guitarra,
            R.raw.c1v1guitarra,
            R.raw.c1v2guitarra,
            R.raw.c1v3guitarra,
            R.raw.c1v4guitarra,
            R.raw.c1v5guitarra,

            R.raw.a1v1guitarra,
            R.raw.a1v2guitarra,
            R.raw.a1v3guitarra,
            R.raw.a1v4guitarra,
            R.raw.a1v5guitarra,
            R.raw.a2v1guitarra,
            R.raw.a2v2guitarra,
            R.raw.a2v3guitarra,
            R.raw.a2v4guitarra,
            R.raw.a2v5guitarra,
            R.raw.a3v1guitarra,
            R.raw.a3v2guitarra,
            R.raw.a3v3guitarra,
            R.raw.a3v4guitarra,
            R.raw.a3v5guitarra,
            R.raw.c2v1guitarra,
            R.raw.c2v2guitarra,
            R.raw.c2v3guitarra,
            R.raw.c2v4guitarra,
            R.raw.c2v5guitarra,

            R.raw.a1v1guitarra,
            R.raw.a1v2guitarra,
            R.raw.a1v3guitarra,
            R.raw.a1v4guitarra,
            R.raw.a1v5guitarra,
            R.raw.a2v1guitarra,
            R.raw.a2v2guitarra,
            R.raw.a2v3guitarra,
            R.raw.a2v4guitarra,
            R.raw.a2v5guitarra,
            R.raw.a3v1guitarra,
            R.raw.a3v2guitarra,
            R.raw.a3v3guitarra,
            R.raw.a3v4guitarra,
            R.raw.a3v5guitarra,
            R.raw.c2v1guitarra,
            R.raw.c2v2guitarra,
            R.raw.c2v3guitarra,
            R.raw.c2v4guitarra,
            R.raw.c2v5guitarra,

            R.raw.a1v1guitarra,
            R.raw.a1v2guitarra,
            R.raw.a1v3guitarra,
            R.raw.a1v4guitarra,
            R.raw.a1v5guitarra,
            R.raw.a2v1guitarra,
            R.raw.a2v2guitarra,
            R.raw.a2v3guitarra,
            R.raw.a2v4guitarra,
            R.raw.a2v5guitarra,
            R.raw.a3v1guitarra,
            R.raw.a3v2guitarra,
            R.raw.a3v3guitarra,
            R.raw.a3v4guitarra,
            R.raw.a3v5guitarra,
            R.raw.c2v1guitarra,
            R.raw.c2v2guitarra,
            R.raw.c2v3guitarra,
            R.raw.c2v4guitarra,
            R.raw.c2v5guitarra,

            R.raw.a1v1guitarra,
            R.raw.a1v2guitarra,
            R.raw.a1v3guitarra,
            R.raw.a1v4guitarra,
            R.raw.a1v5guitarra,
            R.raw.a2v1guitarra,
            R.raw.a2v2guitarra,
            R.raw.a2v3guitarra,
            R.raw.a2v4guitarra,
            R.raw.a2v5guitarra,
            R.raw.a3v1guitarra,
            R.raw.a3v2guitarra,
            R.raw.a3v3guitarra,
            R.raw.a3v4guitarra,
            R.raw.a3v5guitarra,
            R.raw.c2v1guitarra,
            R.raw.c2v2guitarra,
            R.raw.c2v3guitarra,
            R.raw.c2v4guitarra,
            R.raw.c2v5guitarra,

            R.raw.a1v1guitarra,
            R.raw.a1v2guitarra,
            R.raw.a1v3guitarra,
            R.raw.a1v4guitarra,
            R.raw.a1v5guitarra,
            R.raw.a2v1guitarra,
            R.raw.a2v2guitarra,
            R.raw.a2v3guitarra,
            R.raw.a2v4guitarra,
            R.raw.a2v5guitarra,
            R.raw.a3v1guitarra,
            R.raw.a3v2guitarra,
            R.raw.a3v3guitarra,
            R.raw.a3v4guitarra,
            R.raw.a3v5guitarra,
            R.raw.c2v1guitarra,
            R.raw.c2v2guitarra,
            R.raw.c2v3guitarra,
            R.raw.c2v4guitarra,
            R.raw.c2v5guitarra,

           /* R.raw.d1v1guitarra,
            R.raw.d1v2guitarra,
            R.raw.d1v3guitarra,
            R.raw.d1v4guitarra,
            R.raw.d1v5guitarra,
            R.raw.d2v1guitarra,
            R.raw.d2v2guitarra,
            R.raw.d2v3guitarra,
            R.raw.d2v4guitarra,
            R.raw.d2v5guitarra,
            R.raw.d3v1guitarra,
            R.raw.d3v2guitarra,
            R.raw.d3v3guitarra,
            R.raw.d3v4guitarra,
            R.raw.d3v5guitarra,
            R.raw.c3v1guitarra,
            R.raw.c3v2guitarra,
            R.raw.c3v3guitarra,
            R.raw.c3v4guitarra,
*/





        )
        keysGuitarra = arrayOf(
            findViewById(R.id.bgg),
            findViewById(R.id.bgg2),
            findViewById(R.id.bgg3),
            findViewById(R.id.bgg4),
            findViewById(R.id.bgg6),
            findViewById(R.id.bgg7),
            findViewById(R.id.bgg8),
            findViewById(R.id.bgg9),
            findViewById(R.id.bgg10),
            findViewById(R.id.bgg11),
            findViewById(R.id.bgg12),
            findViewById(R.id.bgg13),
            findViewById(R.id.bgg14),
            findViewById(R.id.bgg15),
            findViewById(R.id.bgg16),
            findViewById(R.id.bgg17),
            findViewById(R.id.bgg18),
            findViewById(R.id.bgg19),
            findViewById(R.id.bgg20),
            findViewById(R.id.bgg21),

            findViewById(R.id.bgg25),
            findViewById(R.id.bgg26),
            findViewById(R.id.bgg27),
            findViewById(R.id.bgg28),
            findViewById(R.id.bgg29),
            findViewById(R.id.bgg30),
            findViewById(R.id.bgg31),
            findViewById(R.id.bgg32),
            findViewById(R.id.bgg33),
            findViewById(R.id.bgg34),
            findViewById(R.id.bgg35),
            findViewById(R.id.bgg36),
            findViewById(R.id.bgg37),
            findViewById(R.id.bgg38),
            findViewById(R.id.bgg39),
            findViewById(R.id.bgg40),
            findViewById(R.id.bgg41),
            findViewById(R.id.bgg42),
            findViewById(R.id.bgg43),
            findViewById(R.id.bgg62),

            findViewById(R.id.bgg63),
            findViewById(R.id.bgg64),
            findViewById(R.id.bgg65),
            findViewById(R.id.bgg66),
            findViewById(R.id.bgg67),
            findViewById(R.id.bgg68),
            findViewById(R.id.bgg69),
            findViewById(R.id.bgg70),
            findViewById(R.id.bgg71),
            findViewById(R.id.bgg72),
            findViewById(R.id.bgg73),
            findViewById(R.id.bgg74),
            findViewById(R.id.bgg75),
            findViewById(R.id.bgg76),
            findViewById(R.id.bgg77),
            findViewById(R.id.bgg78),
            findViewById(R.id.bgg79),
            findViewById(R.id.bgg80),
            findViewById(R.id.bgg81),
            findViewById(R.id.bgg82),

            findViewById(R.id.bgg84),
            findViewById(R.id.bgg85),
            findViewById(R.id.bgg86),
            findViewById(R.id.bgg87),
            findViewById(R.id.bgg88),
            findViewById(R.id.bgg89),
            findViewById(R.id.bgg90),
            findViewById(R.id.bgg91),
            findViewById(R.id.bgg92),
            findViewById(R.id.bgg93),
            findViewById(R.id.bgg94),
            findViewById(R.id.bgg95),
            findViewById(R.id.bgg96),
            findViewById(R.id.bgg97),
            findViewById(R.id.bgg98),
            findViewById(R.id.bgg99),
            findViewById(R.id.bgg100),
            findViewById(R.id.bgg101),
            findViewById(R.id.bgg102),
            findViewById(R.id.bgg103),

            findViewById(R.id.bgg104),
            findViewById(R.id.bgg105),
            findViewById(R.id.bgg106),
            findViewById(R.id.bgg107),
            findViewById(R.id.bgg108),
            findViewById(R.id.bgg109),
            findViewById(R.id.bgg110),
            findViewById(R.id.bgg111),
            findViewById(R.id.bgg112),
            findViewById(R.id.bgg113),
            findViewById(R.id.bgg114),
            findViewById(R.id.bgg115),
            findViewById(R.id.bgg116),
            findViewById(R.id.bgg117),
            findViewById(R.id.bgg118),
            findViewById(R.id.bgg119),
            findViewById(R.id.bgg120),
            findViewById(R.id.bgg121),
            findViewById(R.id.bgg122),
            findViewById(R.id.bgg123),

            findViewById(R.id.bgg124),
            findViewById(R.id.bgg125),
            findViewById(R.id.bgg126),
            findViewById(R.id.bgg127),
            findViewById(R.id.bgg128),
            findViewById(R.id.bgg129),
            findViewById(R.id.bgg130),
            findViewById(R.id.bgg131),
            findViewById(R.id.bgg132),
            findViewById(R.id.bgg133),
            findViewById(R.id.bgg134),
            findViewById(R.id.bgg135),
            findViewById(R.id.bgg136),
            findViewById(R.id.bgg137),
            findViewById(R.id.bgg138),
            findViewById(R.id.bgg139),
            findViewById(R.id.bgg140),
            findViewById(R.id.bgg141),
            findViewById(R.id.bgg142),
            findViewById(R.id.bgg143),



        )



        keysGuitarra.forEach { keyS ->
            val indexKey = keysGuitarra.indexOf(keyS)

            val color = (keyS.background as ColorDrawable).color
            keyS.setOnTouchListener { C, Click ->
                val mp = MediaPlayer.create(applicationContext, keysResourseGuitarra[indexKey])
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