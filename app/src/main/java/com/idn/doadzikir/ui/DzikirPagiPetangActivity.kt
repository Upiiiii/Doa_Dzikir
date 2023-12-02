package com.idn.doadzikir.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import com.idn.doadzikir.Adapter.DoadanDzikirAdapter
import com.idn.doadzikir.R
import com.idn.doadzikir.databinding.ActivityDzikirPagiPetangBinding
import com.idn.doadzikir.databinding.ActivitySetiapSaatDzikirBinding
import com.idn.doadzikir.model.DataDoaDzikir
import com.idn.doadzikir.ui.detail.DzikirPagiActivity
import com.idn.doadzikir.ui.detail.DzikirPetangActivity

class DzikirPagiPetangActivity : AppCompatActivity(), View.OnClickListener{

    private var _binding : ActivityDzikirPagiPetangBinding? = null
    private val binding get() = _binding as ActivityDzikirPagiPetangBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        _binding = ActivityDzikirPagiPetangBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnPagi = findViewById<ImageButton>(R.id.img_btn_dzikir_pagi)
        val btnPetang = findViewById<ImageButton>(R.id.img_btn_dzikir_petang)

        btnPagi.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id){
            R.id.img_btn_dzikir_pagi -> startActivity(Intent(this,DzikirPagiActivity::class.java))
            R.id.img_btn_dzikir_pagi -> startActivity(Intent(this,DzikirPetangActivity::class.java))
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        finish()
        return super.onSupportNavigateUp()
    }
}