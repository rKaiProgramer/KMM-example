package com.example.kmmExample.android

import android.os.Bundle
import com.example.kmmExample.Encryption
import com.example.kmmExample.Greeting
import com.example.kmmExample.android.databinding.ActivityMainBinding
import com.example.kmmExample.android.databinding.ActivityPlatformBinding


class PlatformActivity : BaseActivity<ActivityPlatformBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {
            greetingText.text = Greeting().greeting()
        }

    }

    override fun getViewBinding(): ActivityPlatformBinding {
        return ActivityPlatformBinding.inflate(layoutInflater)
    }
}
