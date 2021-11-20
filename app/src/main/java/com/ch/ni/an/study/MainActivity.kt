package com.ch.ni.an.study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import com.ch.ni.an.study.utill.TextCallBack

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel :ViewModel

    override fun onCreate(savedInstanceState :Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = (application as FoodApp).viewModel

        val button = findViewById<Button>(R.id.getFactButton)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val foodTextView = findViewById<TextView>(R.id.nameFoodTextView)
        val kcalTextView = findViewById<TextView>(R.id.kcalTextView)
        val proteinTextView = findViewById<TextView>(R.id.proteinTextView)

        button.setOnClickListener {
            progressBar.visibility = View.VISIBLE
            button.isEnabled = false
            viewModel.getFact()
        }

        viewModel.init(object : TextCallBack{

            override fun provideText(text :String) = runOnUiThread {
                button.isEnabled = true
                progressBar.visibility = View.GONE
                foodTextView.text = text
            }

        })
    }


    override fun onDestroy() {
        viewModel.clear()
        super.onDestroy()

    }
}