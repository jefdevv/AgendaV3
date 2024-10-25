package br.com.jef.agendav3.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.jef.agendav3.R
import br.com.jef.agendav3.databinding.ActivityResumeBinding

class Resume : AppCompatActivity() {
    private lateinit var binding: ActivityResumeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResumeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getName()
        backList()

    }

    private fun getName() {
        val name = intent.getStringExtra("name")
        binding.txtNameResume.text = name
    }

    private fun backList() {
        binding.btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

}