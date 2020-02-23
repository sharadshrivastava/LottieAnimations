package com.volt.app.util

import android.content.Context

object Utils {

    fun pxFromDp(context: Context?, dp: Float): Float {
        return dp * context?.resources?.displayMetrics?.density!!
    }

    fun DpFromPx(context: Context?, px: Float): Float {
        return px / context?.resources?.displayMetrics?.density!!;
    }
}