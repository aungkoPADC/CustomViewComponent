package com.padcmyanmar.padcx.padc_x_recyclerview_ypst.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.R
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.veiws.components.EmotionalFaceView
import kotlinx.android.synthetic.main.activity_custom_component.*

class CustomComponentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_component)

        happyButton.setOnClickListener {
            emotionalFaceView.happinessState = EmotionalFaceView.HAPPY
        }

        sadButton.setOnClickListener {
            emotionalFaceView.happinessState = EmotionalFaceView.SAD
        }

        btnNavigate.setOnClickListener {
            startActivity(FanControlActivity.newIntent(this))
        }
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, CustomComponentActivity::class.java)
        }
    }
}