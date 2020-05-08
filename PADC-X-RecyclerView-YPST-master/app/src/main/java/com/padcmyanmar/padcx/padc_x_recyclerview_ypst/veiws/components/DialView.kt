package com.padcmyanmar.padcx.padc_x_recyclerview_ypst.veiws.components

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.PointF
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.View
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.R

// 1 To represent the available fan speeds.
private enum class FanSpeed(val label: Int) {
    OFF(R.string.fan_off),
    LOW(R.string.fan_low),
    MEDIUM(R.string.fan_medium),
    HIGH(R.string.fan_high);
}

// 2
private const val RADIUS_OFFSET_LABEL = 30      // position for label
private const val RADIUS_OFFSET_INDICATOR = -35 // position for circle indicator

//3
private var radius = 0.0f                   // Radius of the circle.
private var fanSpeed = FanSpeed.OFF         // The active selection.

// position variable which will be used to draw label and indicator circle position
private val pointPosition: PointF = PointF(0.0f, 0.0f)

class DialView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        // Paint styles used for rendering are initialized here. This
        // is a performance optimization, since onDraw() is called
        // for every screen refresh.
        style = Paint.Style.FILL
        textAlign = Paint.Align.CENTER
        textSize = 55.0f
        typeface = Typeface.create("", Typeface.BOLD)
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }

}