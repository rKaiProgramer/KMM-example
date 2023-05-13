package com.example.kmmExample

class Greeting {
    fun greeting(): String {
        return "Hello, \n${Platform().platform}!"
    }
}