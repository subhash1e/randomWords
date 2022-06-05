package com.example.randomwords

import android.util.Log
import java.net.URL

class Request (private var url :String){
    fun run():String{
        val wordsJson = URL(url).readText( )
        Log.d(javaClass.simpleName,wordsJson )
        return wordsJson
    }
}