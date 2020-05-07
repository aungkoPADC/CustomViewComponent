package com.padcmyanmar.padcx.padc_x_recyclerview_ypst.delegates

import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.veiws.viewpods.ReactionViewPods

/**
 * Created by Ye Pyae Sone Tun
 * on 2020-01-18.
 */

interface NewsItemDelegate : ReactionViewPods.Delegate {
    fun onTapNewsItem(newsId: Int)
}