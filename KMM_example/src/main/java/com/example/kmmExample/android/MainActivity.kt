package com.example.kmmExample.android

import android.content.Intent
import android.os.Bundle
import com.example.kmmExample.Encryption
import com.example.kmmExample.Greeting
import com.example.kmmExample.android.databinding.ActivityMainBinding



class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {
            platformButton.setOnClickListener {
                val intent = Intent(this@MainActivity, PlatformActivity::class.java)
                startActivity(intent)
            }
            encryptButton.setOnClickListener {
                val intent = Intent(this@MainActivity, EncryptionActivity::class.java)
                startActivity(intent)
            }
            hanoiButton.setOnClickListener {
                val intent = Intent(this@MainActivity, HanoiActivity::class.java)
                startActivity(intent)
            }
        }

    }

    override fun getViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }
}
