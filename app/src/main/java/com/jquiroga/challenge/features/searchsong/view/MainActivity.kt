package com.jquiroga.challenge.features.searchsong.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jquiroga.challenge.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)
    }

}