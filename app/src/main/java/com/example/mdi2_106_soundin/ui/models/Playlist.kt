package com.example.mdi2_106_soundin.ui.models

data class Playlist(
    val id: Int,
    val name: String,
    val genre: String,
    val songsCount: Int,
    val colorHex: String,
    val isFavorite: Boolean
)
