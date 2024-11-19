package com.dicoding.myapp_videogame

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class VideoGames(
    val name: String,
    val description: String,
    val photo: Int
) : Parcelable