package com.example.randomwords

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.text.style.BackgroundColorSpan
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.text.isDigitsOnly
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
//import com.example.randomwords.networks.BASE_URL
//import com.example.randomwords.networks.Xapi
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btmNavView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val rvRW = findViewById<RecyclerView>(R.id.rvRandWords)
        val btnGen = findViewById<ImageButton>(R.id.buttonGenerate)
        val etNo = findViewById<EditText>(R.id.etMany)
        val btnTheme = findViewById<ImageButton>(R.id.buttonTheme)


        rvRW.adapter = RWAdapter(MutableList<String>(16,{i: Int ->" "}))

        rvRW.layoutManager = StaggeredGridLayoutManager(2, 1)
        var hmany = 16

        btnGen.setOnClickListener {
            if (etNo.text.toString().isEmpty() || (!etNo.text.toString().isDigitsOnly())||etNo.text.toString().toLong()>99999) {
                Toast.makeText(this, "Please Enter Valid No.", Toast.LENGTH_LONG).show()
                hmany=16

            }else {
                try {
                    hmany = etNo.text.toString().toInt()
                }catch (e:Exception){
                   e.stackTrace
                }

            };
            //legends




                rvRW.adapter = RWAdapter(MutableList<String>(hmany,{i: Int ->" "}))

                rvRW.layoutManager = StaggeredGridLayoutManager(2, 1)

        }
        /*var ii=0
        btnTheme.setOnLongClickListener {
             when(ii%4){
                 0 ->xz. = Color.CYAN
                 1 ->xz.typeface = Typeface.MONOSPACE
                 2 ->tv.typeface = Typeface.SANS_SERIF
                 3 ->tv.typeface = Typeface.DEFAULT
             }
             ii++
             if(ii==1000)ii=4
             return@setOnLongClickListener true
         }*/
    }
}