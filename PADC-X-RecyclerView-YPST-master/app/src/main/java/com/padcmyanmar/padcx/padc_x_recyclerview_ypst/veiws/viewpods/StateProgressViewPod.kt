package com.padcmyanmar.padcx.padc_x_recyclerview_ypst.veiws.viewpods

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.R
import kotlinx.android.synthetic.main.view_pod_state_progress.view.*

class StateProgressViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var isCompleteAllSteps = false

    private var mDelegate : Delegate? = null

    override fun onFinishInflate() {
        super.onFinishInflate()
        setUpListeners()
    }

    fun setDelegate(delegate: Delegate){
        mDelegate=delegate
    }

    fun completeAllSteps(){
        isCompleteAllSteps = true
    }

    fun setStepDescription(
        step1Desc: String,
        step2Desc: String,
        step3Desc: String,
        step4Desc: String
    ) {

        tvDesc1.text = step1Desc
        tvDesc2.text = step2Desc
        tvDesc3.text = step3Desc
        tvDesc4.text = step4Desc
    }

    fun onTapStep1() {
        setCircle1Selected()
        setCircle2UnSelected()
        setCircle3UnSelected()
        setCircle4UnSelected()
    }

    fun onTapStep2() {
        setCircle1Selected()
        setCircle2Selected()
        setCircle3UnSelected()
        setCircle4UnSelected()
    }

    fun onTapStep3() {
        setCircle1Selected()
        setCircle2Selected()
        setCircle3Selected()
        setCircle4UnSelected()
    }

    fun onTapStep4() {
        setCircle1Selected()
        setCircle2Selected()
        setCircle3Selected()
        setCircle4Selected()
    }

    private fun setUpListeners() {
        tvCircle1.setOnClickListener {
            if (isCompleteAllSteps) {
                onTapStep1()
                mDelegate?.onTapStep1()
            }
        }

        tvCircle2.setOnClickListener {
            if (isCompleteAllSteps) {
                onTapStep2()
                mDelegate?.onTapStep2()
            }
        }

        tvCircle3.setOnClickListener {
            if (isCompleteAllSteps) {
                onTapStep3()
                mDelegate?.onTapStep3()
            }
        }

        tvCircle4.setOnClickListener {
            if (isCompleteAllSteps) {
                onTapStep4()
                mDelegate?.onTapStep4()
            }
        }
    }

    private fun setCircle1Selected() {
        tvCircle1.background = context.getDrawable(R.drawable.shape_circle_accent)
        tvCircle1.text = "1"
    }

    private fun setCircle2Selected() {
        tvCircle2.background = context.getDrawable(R.drawable.shape_circle_accent)
        view2.setBackgroundColor(ContextCompat.getColor(context, R.color.colorAccent))
        tvCircle2.text = "2"
    }

    private fun setCircle3Selected() {
        tvCircle3.background = context.getDrawable(R.drawable.shape_circle_accent)
        view3.setBackgroundColor(ContextCompat.getColor(context, R.color.colorAccent))
        tvCircle3.text = "3"
    }

    private fun setCircle4Selected() {
        tvCircle4.background = context.getDrawable(R.drawable.shape_circle_accent)
        view4.setBackgroundColor(ContextCompat.getColor(context, R.color.colorAccent))
        tvCircle4.text = "4"
    }

    private fun setCircle2UnSelected() {
        tvCircle2.background = context.getDrawable(R.drawable.shape_circle)
        view2.setBackgroundColor(ContextCompat.getColor(context, android.R.color.darker_gray))
        tvCircle2.text = ""
    }

    private fun setCircle3UnSelected() {
        tvCircle3.background = context.getDrawable(R.drawable.shape_circle)
        view3.setBackgroundColor(ContextCompat.getColor(context, android.R.color.darker_gray))
        tvCircle3.text = ""
    }

    private fun setCircle4UnSelected() {
        tvCircle4.background = context.getDrawable(R.drawable.shape_circle)
        view4.setBackgroundColor(ContextCompat.getColor(context, android.R.color.darker_gray))
        tvCircle4.text = ""
    }

    interface Delegate{
        fun onTapStep1()
        fun onTapStep2()
        fun onTapStep3()
        fun onTapStep4()
    }

}