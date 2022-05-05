package com.example.handleronline

import android.annotation.SuppressLint
import android.os.*
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.handleronline.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding
    private lateinit var handler: Handler
    private lateinit var handler1: Handler
    private var isBack = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        handler = Handler(Looper.getMainLooper())
        initViews()
    }

    private fun initViews() {
        handler.postDelayed(runnable, 100)
    }

    private var runnable = object : Runnable{
        @SuppressLint("SetTextI18n")
        override fun run() {
            binding.progressBar.progress = binding.progressBar.progress + 2
            binding.tvPercentage.text = (binding.progressBar.progress).toString() + "%"
            Thread.sleep(1000)
            handler.postDelayed(this, 100)
        }
    }

    //exiting the app by click back button two times in two seconds
    override fun onBackPressed() {
        if(isBack){
            super.onBackPressed()
            return
        }
        isBack = true
        handler1 = Handler(Looper.getMainLooper())
        Toast.makeText(this, "Please click again", Toast.LENGTH_SHORT).show()
        handler1.postDelayed({
             isBack = false
        }, 2000)
    }

}