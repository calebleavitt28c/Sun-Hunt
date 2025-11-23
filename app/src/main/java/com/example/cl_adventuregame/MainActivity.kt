package com.example.cl_adventuregame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent

class MainActivity : AppCompatActivity() {
    lateinit var drawView: DrawView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawView = findViewById(R.id.drawView) //pointer to drawView
     }

    override fun onTouchEvent(event: MotionEvent): Boolean { //this code draws the file where ever the user taps
        if (event.action == MotionEvent.ACTION_UP) {
            Log.i("CS3680", "Touch event ${event.x}, ${event.y}")

            var offset = IntArray(2)
            drawView.getLocationInWindow(offset) //This grabs the x and y coordinates of drawView for the whole screen and puts them in to the local Array
            Log.i("CS3680", "Offset ${offset[0]}, ${offset[1]}")

            if (event.x - offset[0] in 223F..855F && event.y - offset[1] in 150F..308F) {
                //Log.i("CS3680", "x: ${event.x - offset[0]}, y: ${event.y - offset[1]}")
                Log.i("CS3680", "Moving North")
                if (drawView.guySRow == 0) {
                    if (drawView.guyWRow == 0)
                    else {
                        drawView.guyWRow--
                        drawView.screenY--
                    }
                }
                else {
                    drawView.guySRow--
                    drawView.guyWRow--
                    drawView.guyY -= 158F
                }
            }
            if (event.x - offset[0] in 65F..223F && event.y - offset[1] in 308F..940F) {
                //Log.i("CS3680", "x: ${event.x - offset[0]}, y: ${event.y - offset[1]}")
                Log.i("CS3680", "Moving West")
                if (drawView.guySCol == 0) {
                    if (drawView.guyWCol == 0)
                    else {
                        drawView.guyWCol--
                        drawView.screenX--
                    }
                }
                else {
                    drawView.guySCol--
                    drawView.guyWCol--
                    drawView.guyX -= 158F
                }
            }
            if (event.x - offset[0] in 223F..855F && event.y - offset[1] in 940F..1098F) {
                //Log.i("CS3680", "x: ${event.x - offset[0]}, y: ${event.y - offset[1]}")
                Log.i("CS3680", "Moving South")
                if (drawView.guySRow == 5) {
                    if (drawView.guyWRow == 11)
                    else {
                        drawView.guyWRow++
                        drawView.screenY++
                    }
                }
                else {
                    drawView.guySRow++
                    drawView.guyWRow++
                    drawView.guyY += 158F
                }
            }
            if (event.x - offset[0] in 855F..1013F && event.y - offset[1] in 308F..940F) {
                //Log.i("CS3680", "x: ${event.x - offset[0]}, y: ${event.y - offset[1]}")
                Log.i("CS3680", "Moving East")
                if (drawView.guySCol == 5) {
                    if (drawView.guyWCol == 11)
                    else {
                        drawView.guyWCol++
                        drawView.screenX++
                    }
                }
                else {
                    drawView.guySCol++
                    drawView.guyWCol++
                    drawView.guyX += 158F
                }
            }
            drawView.invalidate()
            return true
        }
        return true
    }
}