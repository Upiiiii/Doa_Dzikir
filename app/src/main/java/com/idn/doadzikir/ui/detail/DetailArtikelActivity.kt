package com.idn.doadzikir.ui.detail

import android.os.Build.VERSION.SDK_INT
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.idn.doadzikir.R
import com.idn.doadzikir.databinding.ActivityDetailArtikelBinding
import com.idn.doadzikir.model.Artikel

class DetailArtikelActivity : AppCompatActivity() {
    private var _binding: ActivityDetailArtikelBinding? = null
    private val binding get() = _binding as ActivityDetailArtikelBinding

//    companion object {
//        const val DATA_TITLE = "title"
//        const val DATA_DESC = "data"
//        const val DATA_IMAGE = "image"
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = "Artikel Islam"
        _binding = ActivityDetailArtikelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = when {
            SDK_INT >= 33 -> intent.getParcelableExtra("data", Artikel::class.java)
            else -> @Suppress("DEPRECATION") intent.getParcelableExtra("key") as? Artikel
        }

        binding.apply {
            tvDetailTitle.text = data?.titleArtikel
            tvDetailDesc.text = data?.descArtikel
            data?.imageArtikel?.let {imgDetail.setImageResource(it)}
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        finish()
        return super.onSupportNavigateUp()
    }
}