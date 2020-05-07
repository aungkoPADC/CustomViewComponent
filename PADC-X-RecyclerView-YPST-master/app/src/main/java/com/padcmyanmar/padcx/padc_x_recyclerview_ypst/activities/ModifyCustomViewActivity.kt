package com.padcmyanmar.padcx.padc_x_recyclerview_ypst.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.R
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.veiws.viewpods.StateProgressViewPod
import kotlinx.android.synthetic.main.activity_modify_custom_view.*

class ModifyCustomViewActivity : AppCompatActivity() {

    private lateinit var mViewPodStateProgress: StateProgressViewPod

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modify_custom_view)

        setUpViewPod()

        setListener()
    }

    private fun setUpViewPod() {
        mViewPodStateProgress = viewPodStateProgress as StateProgressViewPod
        mViewPodStateProgress.apply {
            setStepDescription("Survey", "Cabling", "Splicing", "Activate")
        }
    }

    private fun setListener() {

        btn1.setOnClickListener {
            mViewPodStateProgress.onTapStep1()
        }

        btn2.setOnClickListener {
            mViewPodStateProgress.onTapStep2()
        }

        btn3.setOnClickListener {
            mViewPodStateProgress.onTapStep3()
        }

        btn4.setOnClickListener {
            mViewPodStateProgress.onTapStep4()
            mViewPodStateProgress.completeAllSteps()
        }

    }


    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, ModifyCustomViewActivity::class.java)
        }
    }
}