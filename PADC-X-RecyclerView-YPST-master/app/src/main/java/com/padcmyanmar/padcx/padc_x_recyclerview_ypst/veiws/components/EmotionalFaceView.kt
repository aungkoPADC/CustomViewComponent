package com.padcmyanmar.padcx.padc_x_recyclerview_ypst.veiws.components

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import androidx.core.content.withStyledAttributes
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.R

class EmotionalFaceView(context: Context, attrs: AttributeSet) : View(context, attrs) {

    // Paint object for coloring and styling
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    // 2
    // Some colors for the face background, eyes and mouth.
    private var faceColor = DEFAULT_FACE_COLOR
    private var eyesColor = DEFAULT_EYES_COLOR
    private var mouthColor = DEFAULT_MOUTH_COLOR
    private var borderColor = DEFAULT_BORDER_COLOR

    // Face border width in pixels
    private var borderWidth = DEFAULT_BORDER_WIDTH

    // View size in pixels
    private var size = 0

    // To draw mouth on a path
    private val mouthPath = Path()

    // 3
    var happinessState = HAPPY
        set(state) {
            field = state
            // 4
            invalidate()
        }

    // 5
    init {
        paint.isAntiAlias = true
        setupAttributes(attrs)
    }

    private fun setupAttributes(attrs: AttributeSet?) {

        // 6
        // get custom attribute values from xml
        context.withStyledAttributes(attrs, R.styleable.EmotionalFaceView) {
            happinessState = getString(R.styleable.EmotionalFaceView_state)?.toLongOrNull() ?: HAPPY
            faceColor = getColor(R.styleable.EmotionalFaceView_faceColor, DEFAULT_FACE_COLOR)
            eyesColor = getColor(R.styleable.EmotionalFaceView_eyesColor, DEFAULT_EYES_COLOR)
            mouthColor = getColor(R.styleable.EmotionalFaceView_mouthColor, DEFAULT_MOUTH_COLOR)
            borderColor = getColor(R.styleable.EmotionalFaceView_borderColor, DEFAULT_BORDER_COLOR)
            borderWidth = getDimension(R.styleable.EmotionalFaceView_borderWidth, DEFAULT_BORDER_WIDTH)
        }
    }

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

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        // 1 get minimum value
        size = measuredWidth.coerceAtMost(measuredHeight)

        // 2 override width and height
        setMeasuredDimension(size, size)
    }

    // 1
    companion object {

        private const val DEFAULT_FACE_COLOR = Color.YELLOW
        private const val DEFAULT_EYES_COLOR = Color.BLACK
        private const val DEFAULT_MOUTH_COLOR = Color.BLACK
        private const val DEFAULT_BORDER_COLOR = Color.BLACK
        private const val DEFAULT_BORDER_WIDTH = 4.0f

        const val HAPPY = 0L
        const val SAD = 1L
    }
}