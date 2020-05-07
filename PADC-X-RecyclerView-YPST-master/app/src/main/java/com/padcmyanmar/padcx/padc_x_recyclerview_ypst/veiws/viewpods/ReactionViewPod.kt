package com.padcmyanmar.padcx.padc_x_recyclerview_ypst.veiws.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.view_pod_reaction.view.*

class ReactionViewPods @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    override fun onFinishInflate() {
        super.onFinishInflate()
        setUpListener()
    }

    private fun setUpListener() {
        tvLike.setOnClickListener {

        }

        tvComment.setOnClickListener {

        }

        tvShare.setOnClickListener {
            
        }
    }
}