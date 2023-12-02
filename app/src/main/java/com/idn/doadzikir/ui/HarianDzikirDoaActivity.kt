package com.idn.doadzikir.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.idn.doadzikir.Adapter.DoadanDzikirAdapter
import com.idn.doadzikir.R
import com.idn.doadzikir.databinding.ActivityHarianDzikirDoaBinding
import com.idn.doadzikir.databinding.ActivityQauliyahSholatBinding
import com.idn.doadzikir.databinding.ActivitySetiapSaatDzikirBinding
import com.idn.doadzikir.model.DataDoaDzikir
import com.idn.doadzikir.model.DoadanDzikirItem

class HarianDzikirDoaActivity : AppCompatActivity() {

    private var _binding : ActivityHarianDzikirDoaBinding? = null
    private val binding get() = _binding as ActivityHarianDzikirDoaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        _binding = ActivityHarianDzikirDoaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        providingDzikirData()
        initView()

    }

    private fun initView() {
        val mAdapter = DoadanDzikirAdapter()
        mAdapter.setData(providingDzikirData())
        binding.rvHarianDzikir.adapter = mAdapter
        binding.rvHarianDzikir.layoutManager = LinearLayoutManager(this)
    }

    private fun providingDzikirData() : List<DoadanDzikirItem> {
        val TitleDoa = resources.getStringArray(R.array.arr_dzikir_doa_harian)
        val FillDoa = resources.getStringArray(R.array.arr_lafaz_dzikir_doa_harian)
        val SubtitleDoa = resources.getStringArray(R.array.arr_terjemah_dzikir_doa_harian)

        val listData = arrayListOf<DoadanDzikirItem>()
        for (i in TitleDoa.indices) {
            val data = DoadanDzikirItem(
                TitleDoa[i],
                FillDoa[i],
                SubtitleDoa[i]
            )
            listData.add(data)
        }
        return listData
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        finish()
        return super.onSupportNavigateUp()
    }
}