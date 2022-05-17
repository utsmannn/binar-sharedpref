package com.utsman.sharedprefbinar

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.utsman.sharedprefbinar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val sharedPreferences: SharedPreferences by lazy {
        getSharedPreferences("user", Context.MODE_PRIVATE)
    }

    // backing properties
    private var _binding: ActivityMainBinding? = null
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        binding = requireNotNull(_binding)
        setContentView(binding.root)

        setupView()
    }

    private fun setupView() {
        binding.btnSave.setOnClickListener {
            val userName = binding.etName.text.toString()
            val userAge = binding.etAge.text.toString().toIntOrNull() ?: 0

            saveData(userName, userAge)
        }

        binding.btnResult.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            startActivity(intent)
        }
    }

    private fun saveData(name: String, age: Int) {
        val editor = sharedPreferences.edit()
        editor.putString("key_name", name)
        editor.putInt("key_age", age)
        editor.apply()
        println("name -> $name | age -> $age")
        Toast.makeText(this, "sukses", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}