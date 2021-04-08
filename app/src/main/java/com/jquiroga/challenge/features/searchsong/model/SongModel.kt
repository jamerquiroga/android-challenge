package com.jquiroga.challenge.features.searchsong.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SongModel(
    val code: Int,
    val name: String,
    val albumName: String,
    val bandName: String,
    val imageUrl: String
) : Parcelable