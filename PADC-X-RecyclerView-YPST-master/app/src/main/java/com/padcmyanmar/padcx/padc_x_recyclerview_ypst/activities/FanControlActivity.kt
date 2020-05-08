package com.padcmyanmar.padcx.padc_x_recyclerview_ypst.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.R

class FanControlActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fan_control)
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, FanControlActivity::class.java)
        }
    }
}