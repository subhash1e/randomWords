package com.example.randomwords.networks


import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
//https://random-words-api.vercel.app/word

interface RWAPIInterface {
    @GET("word")
   fun getRW():Call<List<RWData>>
}
