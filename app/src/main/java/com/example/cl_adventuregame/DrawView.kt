package com.example.cl_adventuregame

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Paint
import android.graphics.Color
import android.graphics.Canvas
//import android.graphics.*
import android.util.AttributeSet
import android.view.View

open class DrawView(context: Context, attrs: AttributeSet? = null): View(context, attrs) {

    var nextX: Float = 65F
    var nextY: Float = 150F
    var guyX: Float = 381F
    var guyY: Float = 460F
    var guyWCol: Int = 5
    var guyWRow: Int = 5
    var guySCol: Int = 2
    var guySRow: Int = 2
    var screenX: Int = 3
    var screenY: Int = 3
    var bitmapM: Bitmap
    var bitmapF: Bitmap
    var bitmapP: Bitmap
    var bitmapW: Bitmap
    var bitmapG: Bitmap


    init {
        bitmapM = BitmapFactory.decodeResource(resources, R.drawable.mountain, null)
        bitmapF = BitmapFactory.decodeResource(resources, R.drawable.forest, null)
        bitmapP = BitmapFactory.decodeResource(resources, R.drawable.plain, null)
        bitmapW = BitmapFactory.decodeResource(resources, R.drawable.water, null)
        bitmapG = BitmapFactory.decodeResource(resources, R.drawable.guy, null)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        // Random Screen Map Generator
//        val terrains = listOf('M','F','P','W')
//        //var worldRow = CharArray(6)
//        var world = Array(6) {CharArray(6)}
//        for (i in 0..5) {
//            for (j in 0..5) {
//                var randomIndex = Random.nextInt(terrains.size)
//                world[i][j] = terrains[randomIndex]
//                Log.i("CS3680", world.toString())
//            }
//        }

        //Create World Map
        var worldMap = arrayOf(
            charArrayOf('M','M','M', 'M','M','M','M','M','M', 'F','W','W'),
            charArrayOf('M','M','M', 'M','M','W','W','M','F', 'F','W','W'),
            charArrayOf('M','M','M', 'M','M','W','W','M','M', 'W','W','W'),

            charArrayOf('M','P','P', 'M','M','M','M','M','W', 'W','W','W'),
            charArrayOf('M','P','P', 'M','P','P','W','M','W', 'W','P','M'),
            charArrayOf('M','P','M', 'M','P','P','W','W','W', 'W','P','P'),
            charArrayOf('F','F','F', 'F','P','P','P','P','W', 'W','W','W'),
            charArrayOf('F','F','F', 'F','F','P','P','P','W', 'W','W','W'),
            charArrayOf('F','F','F', 'F','F','M','M','M','W', 'W','W','W'),

            charArrayOf('M','F','F', 'F','F','M','M','M','P', 'W','W','W'),
            charArrayOf('M','F','F', 'W','W','W','W','W','W', 'W','W','W'),
            charArrayOf('M','F','F', 'F','F','F','F','F','M', 'W','W','W'),
        )

        // Create Screen Map from World Map
        var screenMap = arrayOf(charArrayOf(), charArrayOf(), charArrayOf(), charArrayOf(), charArrayOf(), charArrayOf())
        for (y in 0..5) {
            screenMap[y] = worldMap[screenY+y].copyOfRange(screenX, screenX+6)
        }

        for (i in screenMap) {
            for (j in i) {
                when (j) {
                    'M' -> canvas?.drawBitmap(bitmapM, nextX, nextY, null)
                    'F' -> canvas?.drawBitmap(bitmapF, nextX, nextY, null)
                    'P' -> canvas?.drawBitmap(bitmapP, nextX, nextY, null)
                    'W' -> canvas?.drawBitmap(bitmapW, nextX, nextY, null)
                }
                nextX += 158F
            }
            nextX = 65F // reset to starting x
            nextY += 158F
        }
        nextY = 158F // reset to starting y
        canvas?.drawBitmap(bitmapG, guyX, guyY, null)
    }
}