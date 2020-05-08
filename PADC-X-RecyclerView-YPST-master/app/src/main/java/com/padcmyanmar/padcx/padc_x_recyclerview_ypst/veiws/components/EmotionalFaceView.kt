package com.padcmyanmar.padcx.padc_x_recyclerview_ypst.veiws.components

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class EmotionalFaceView(context: Context, attrs: AttributeSet) : View(context, attrs) {

    // Paint object for coloring and styling
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    // Some colors for the face background, eyes and mouth.
    private var faceColor = Color.YELLOW
    private var eyesColor = Color.BLACK
    private var mouthColor = Color.BLACK
    private var borderColor = Color.BLACK

    // Face border width in pixels
    private var borderWidth = 4.0f

    // View size in pixels
    private var size = 320

    // To draw mouth on a path
    private val mouthPath = Path()

    override fun onDraw(canvas: Canvas) {
        // call the super method to keep any drawing from the parent side.
        super.onDraw(canvas)

        drawFaceBackground(canvas)
        drawEyes(canvas)
        drawMouth(canvas)
    }

    private fun drawFaceBackground(canvas: Canvas) {

        // 1 set background color to faceColor and fill that color.
        paint.color = faceColor
        paint.style = Paint.Style.FILL

        // 2 calculate the radius of the circle  (320/2) => 160
        val radius = size / 2f

        /**
         * 3
         * @param cx is x-coordinate of circle => 160
         * @param cy is y-coordinate of circle => 160
         *
         * start draw the circle from the center position (x,y) with radius 160 and paint
         */
        canvas.drawCircle(size / 2f, size / 2f, radius, paint)

        // 4 set background stroke color to border color and make it stroke.
        paint.color = borderColor
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = borderWidth

        // 5
        canvas.drawCircle(size / 2f, size / 2f, radius - borderWidth / 2f, paint)

    }

    private fun drawEyes(canvas: Canvas) {

        // 1 set background color to eyesColor and fill that color
        paint.color = eyesColor
        paint.style = Paint.Style.FILL

        /* 2  for left eye
           the first four parameter is left,top,right,bottom to define four point
           eg. (left,top) , (left,bottom) , (right,top) , (right,bottom)
           percentages of the size: (32%, 23%, 43%, 50%)
         */
        val leftEyeRect = RectF(size * 0.32f, size * 0.23f, size * 0.43f, size * 0.50f)

        canvas.drawOval(leftEyeRect, paint)

        /* 3 for right eye
           percentages of the size: (57%, 23%, 68%, 50%)
         */
        val rightEyeRect = RectF(size * 0.57f, size * 0.23f, size * 0.68f, size * 0.50f)

        // 4
        canvas.drawOval(rightEyeRect, paint)

    }

    private fun drawMouth(canvas: Canvas) {

        /* 1
           the starting point of the path to (x0,y0) by using the moveTo()
           (22,70)
         */
        mouthPath.moveTo(size * 0.22f, size * 0.7f)

        /* 2
           draw a curved path from the starting point and through (x1,y1) that ends with (x2,y2)
           (50,80) , (78,70)
         */
        mouthPath.quadTo(size * 0.50f, size * 0.80f, size * 0.78f, size * 0.70f)

        /* 3
           Draw a curved path starting from the last end point (x2,y2) and through (x3,y3) and that ends with (x0,y0)
           (50,90) , (22,70)
         */
        mouthPath.quadTo(size * 0.50f, size * 0.90f, size * 0.22f, size * 0.70f)

        // 4 set background color to mouthColor and fill that color
        paint.color = mouthColor
        paint.style = Paint.Style.FILL

        // 5
        canvas.drawPath(mouthPath, paint)
    }
}