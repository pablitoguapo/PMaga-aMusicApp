package com.example.pmagaamusicapp.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://musicapi.pjasoft.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api: MusicApi = retrofit.create(MusicApi::class.java)
}