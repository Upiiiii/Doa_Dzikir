package com.idn.doadzikir.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.idn.doadzikir.Adapter.DoadanDzikirAdapter
import com.idn.doadzikir.R
import com.idn.doadzikir.databinding.ActivityDzikirPagiBinding
import com.idn.doadzikir.databinding.ActivityDzikirPetangBinding
import com.idn.doadzikir.model.DataDoaDzikir

class DzikirPetangActivity : AppCompatActivity() {

    private var _binding : ActivityDzikirPetangBinding? = null
    private val binding get() = _binding as ActivityDzikirPetangBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Dzikir Petang"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        _binding = ActivityDzikirPetangBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvDzikirPetang.apply {
            val mAdapter = DoadanDzikirAdapter()
            mAdapter.setData(DataDoaDzikir.listDzikirPagi)
            adapter = mAdapter
            layoutManager = LinearLayoutManager(applicationContext)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        finish()
        return super.onSupportNavigateUp()
    }
}