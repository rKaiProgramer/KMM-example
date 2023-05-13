package com.example.kmmExample

import com.soywiz.krypto.AES
import com.soywiz.krypto.Padding
import com.soywiz.krypto.encoding.toBase64


class Encryption {


    fun encryptAes(data: String): String {
        val encodeByteArray = AES.encryptAesCbc(
            data = data.encodeToByteArray(),
            key = "1234567890abcdefghijklmnopqrstuv".encodeToByteArray(),
            iv = "0123456789123456".encodeToByteArray(),
            padding = Padding.PKCS7Padding
        )
        return encodeByteArray.toBase64()
    }
}