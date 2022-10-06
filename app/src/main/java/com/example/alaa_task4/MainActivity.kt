package com.example.alaa_task4

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val Chocolat="Chocolate icecream"
    private val Vanilla="Vanilla icecream"
    private val Mango="Mango icecream"
    private val Kewi="Kewi icecream"

    val prices= mapOf (Chocolat to 90, Vanilla to 75 , Mango to 50 , Kewi to 55   )

    lateinit var FavorMenu : AutoCompleteTextView
    lateinit var priceIce : TextView
    lateinit var submit  : Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FavorMenu = findViewById(R.id.auto_menu)
        priceIce  = findViewById(R.id.price_text)
        submit =  findViewById(R.id.submit_button)

        funny()

        FavorMenu.setOnItemClickListener { adapterView, view, i, l ->
           val choi = FavorMenu.text.toString()
           val prices_Selected =  prices[choi]
            priceIce.setText(prices_Selected.toString())

        }


        submit.setOnClickListener{
         val sms = "I want to order ${FavorMenu.text.toString()}"
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:")
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("CityIceCream@gmail.com"))
            intent.putExtra(Intent.EXTRA_SUBJECT," Order ")
            intent.putExtra(Intent.EXTRA_TEXT,sms)
            startActivity(intent)

        }


    }

    private fun funny() {
        val list_icecream =  listOf(Chocolat, Vanilla, Mango, Kewi)
        val adapter = ArrayAdapter(this, R.layout.list_item, list_icecream)
        FavorMenu.setAdapter(adapter)
    }


}