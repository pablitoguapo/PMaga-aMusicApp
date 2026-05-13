package com.example.pmagaamusicapp.models
import com.google.gson.annotations.SerializedName

data class Album(
    @SerializedName("id", alternate = ["_id"]) val id: String,
    @SerializedName("title") val title: String,
    @SerializedName("artist") val artist: String,
    @SerializedName("image") val image: String,
    @SerializedName("description") val description: String
)
