package com.idn.doadzikir.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.idn.doadzikir.Adapter.DoadanDzikirAdapter
import com.idn.doadzikir.R
import com.idn.doadzikir.databinding.ActivityDetailArtikelBinding
import com.idn.doadzikir.databinding.ActivityQauliyahSholatBinding
import com.idn.doadzikir.model.DataDoaDzikir

class QauliyahSholatActivity : AppCompatActivity() {

    private var _binding : ActivityQauliyahSholatBinding? = null
    private val binding get() = _binding as ActivityQauliyahSholatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        _binding = ActivityQauliyahSholatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mAdapter = DoadanDzikirAdapter()
        mAdapter.setData(DataDoaDzikir.listDataQauliyah)
        binding.rvQauliyahSholat.adapter = mAdapter
        binding.rvQauliyahSholat.layoutManager = LinearLayoutManager(this)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        finish()
        return super.onSupportNavigateUp()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}