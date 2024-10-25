package br.com.jef.agendav3.ui

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.jef.agendav3.R
import br.com.jef.agendav3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addName()
    }

    private fun initRecycler(list: MutableList<String>) {
        binding.recycler.layoutManager = LinearLayoutManager(this)
        binding.recycler.setHasFixedSize(true)
        binding.recycler.adapter = Adapter(list) { name ->
            val intent = Intent(this, Resume::class.java)
            intent.putExtra("name", name)
            startActivity(intent)
        }
    }

    private fun addName() {
        val list = mutableListOf<String>()
        val name = binding.edtName.text

        binding.btnSave.setOnClickListener {
            if (binding.edtName.text.isEmpty()) {
                binding.edtName.error = getString(R.string.empty_field)
            } else {
                list.add(name.toString())
                initRecycler(list)
                binding.edtName.text.clear()

            }

        }

    }


}