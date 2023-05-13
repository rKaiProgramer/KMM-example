package com.example.kmmExample.android

import android.os.Bundle
import com.example.kmmExample.Encryption
import com.example.kmmExample.Greeting
import com.example.kmmExample.android.databinding.ActivityEncryptionBinding
import com.example.kmmExample.android.databinding.ActivityMainBinding



class EncryptionActivity : BaseActivity<ActivityEncryptionBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {
            aesEncryptButton.setOnClickListener {
                aesEncryptionText.text = Encryption().encryptAes(aesInputEdittext.text.toString())
            }
        }

    }

    override fun getViewBinding(): ActivityEncryptionBinding {
        return ActivityEncryptionBinding.inflate(layoutInflater)
    }
}
