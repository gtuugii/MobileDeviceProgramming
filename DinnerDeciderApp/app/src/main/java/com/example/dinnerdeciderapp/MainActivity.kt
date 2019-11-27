package com.example.dinnerdeciderapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

import java.util.Random
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var tv : TextView?=null
    var foodList = ArrayList<String>(arrayListOf("Hamburger", "Pizza", "Mexican", "American", "Chinese" ))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
            foodlist.add("Kotlin")
            foodlist.add("Scala")
            foodlist.add("Ruby")
            println(foodlist)
        */
    }

    fun imgClick(view: View) {
        val rg : Random = Random()

    }
    fun onAddFood(view: View) {
        //2 ways - it is old ways
        //tv = findViewById(R.id.textView1) as TextView
        //tv = findViewById<TextView>(R.id.textView1)

        var add : String?
        add = editFood.text.toString()

        if(add.isEmpty())
            Toast.makeText(this, "Enter new Food", Toast.LENGTH_LONG).show()
        else {
            foodList.add(add)
            Toast.makeText(this, "Added new Food", Toast.LENGTH_LONG).show()
        }

        editFood.text.clear()
    }
    fun onDecide(view: View) {
        var random = Random()
        var len = foodList.size
        var randomId = random.nextInt(len)
        txtFoodName.text = foodList[randomId]
    }
}
