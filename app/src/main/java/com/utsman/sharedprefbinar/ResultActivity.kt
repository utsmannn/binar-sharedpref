package com.utsman.sharedprefbinar

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.utsman.sharedprefbinar.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private val sharedPreferences: SharedPreferences by lazy {
        getSharedPreferences("user", Context.MODE_PRIVATE)
    }


    private var _binding: ActivityResultBinding? = null
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityResultBinding.inflate(layoutInflater)
        binding = requireNotNull(_binding)

        setContentView(binding.root)

        val name = sharedPreferences.getString("key_name", "default")
        val age = sharedPreferences.getInt("key_age", -1)

        binding.tvName.text = name
        binding.tvAge.text = age.toString()
    }
}