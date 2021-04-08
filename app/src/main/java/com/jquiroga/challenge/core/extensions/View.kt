package com.jquiroga.challenge.core.extensions

import android.view.View

fun View?.visible(value: Boolean = true) = apply {
    this?.visibility = if (value) View.VISIBLE else View.GONE
}

fun View?.gone() = apply {
    this?.visibility = View.GONE
}
