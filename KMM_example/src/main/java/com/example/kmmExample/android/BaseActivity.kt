package com.example.kmmExample.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding


abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {
    private var _binding: VB? = null
    protected val binding get() = _binding!!



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = getViewBinding()
        _binding?.let {
            setContentView(it.root)
        }
    }



    protected abstract fun getViewBinding(): VB



    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}
