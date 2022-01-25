/*
 * SPDX-License-Identifier: MPL-2.0
 * Copyright © 2022 Skyline Team and Contributors (https://github.com/skyline-emu/)
 */

package emu.skyline.views

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import androidx.transition.TransitionManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import emu.skyline.R

class DragIndicatorView : androidx.appcompat.widget.AppCompatImageView {
    val callback = DragIndicatorCallback()

    init {
        setImageResource(R.drawable.drag_indicator)
    }

    constructor(context : Context) : super(context)
    constructor(context : Context, attrs : AttributeSet?) : super(context, attrs)
    constructor(context : Context, attrs : AttributeSet?, defStyleAttr : Int) : super(context, attrs, defStyleAttr)

    inner class DragIndicatorCallback : BottomSheetBehavior.BottomSheetCallback() {
        override fun onStateChanged(bottomSheet : View, newState : Int) {
            // Enables animation between visibility states
            TransitionManager.beginDelayedTransition(parent as ViewGroup)

            visibility = if (newState == BottomSheetBehavior.STATE_EXPANDED && bottomSheet.top == 0)
                View.INVISIBLE
            else
                View.VISIBLE
        }

        override fun onSlide(bottomSheet : View, slideOffset : Float) {}
    }
}
