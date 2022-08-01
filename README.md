# randomWords
an android app for generating multiple random words with single tap and their meaning at double tap,
API-Used - https://random-words-api.vercel.app/
# adapter file
package com.example.randomwords

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.icu.text.TimeZoneFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.MultiAutoCompleteTextView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.example.randomwords.networks.RWAPIInterface
import com.example.randomwords.networks.RWData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.concurrent.timer
import kotlin.math.absoluteValue
import kotlin.random.Random


class RWAdapter(list: MutableList<String>): RecyclerView.Adapter<RWAdapter.XVH>() {
    class XVH(itemView: View) :RecyclerView.ViewHolder(itemView){}

    val list:MutableList<String> = list

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): XVH {
        val view:View = LayoutInflater.from(parent.context).
                inflate(R.layout.word_row,parent,false)

        return XVH(view)
    }

    override fun onBindViewHolder(holder: XVH, position: Int) {
       holder.apply{
            val tv = this.itemView.findViewById<TextView>(R.id.textView)
           val retrofit = Retrofit.Builder()
               .baseUrl("https://random-words-api.vercel.app/")
               .addConverterFactory(GsonConverterFactory.create())
               .build()
           val myApiCall = retrofit.create(RWAPIInterface::class.java)
           val call = myApiCall.getRW()
           var ls:RWData = RWData("..","...","....")
           call.enqueue(object : Callback<List<RWData>> {
               override fun onResponse(
                   call: Call<List<RWData>>,
                   response: Response<List<RWData>>
               ) {
                   if(response.code()==200){
                       ls =  response.body()!![0]


                   }
               }

               override fun onFailure(call: Call<List<RWData>>, t: Throwable) {
                   t.stackTrace
               }
           })
           var i=0
           tv.text = ls.word
           tv.setOnClickListener  {
               var pos2 = Random.nextInt().absoluteValue
                when(i%2){
                    0 ->{tv.text = ls.word;tv.typeface = Typeface.DEFAULT_BOLD}
                    2 ->{tv.text = "Pronunciation:\n "+ ls.pronunciation;tv.minWidth = 20;}
                    1 ->{tv.text = " \n "+ ls.definition;tv.typeface = Typeface.DEFAULT_BOLD}
                }
               i++
               if(i==999)i=3
           }
           var ii=0

       }
    }

    override fun getItemCount(): Int {
       return list.size
    }

}

https://github.com/subhash1e/randomWords/releases/download/app/app-debug.apk
see screenshots
![Screenshot_20220610-211540](https://user-images.githubusercontent.com/85139394/173104543-3db1849f-1f69-454e-a475-afe7868b8635.png)
![Screenshot_20220610-211551](https://user-images.githubusercontent.com/85139394/173104559-d98745df-ddba-46cb-a284-a05dc61234f4.png)
![Screenshot_20220610-211625](https://user-images.githubusercontent.com/85139394/173104564-2e44a4ff-d40e-4d7c-a71e-6cc0e2c6ef5e.png)
![Screenshot_20220610-211637](https://user-images.githubusercontent.com/85139394/173104577-dea25724-c2d4-4763-9051-7f6845b1c0b6.png)
