package com.idn.doadzikir.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.idn.doadzikir.Utills.OnItemCallback
import com.idn.doadzikir.databinding.ItemArtikelBinding
import com.idn.doadzikir.model.Artikel

class ArtikelAdapter : RecyclerView.Adapter<ArtikelAdapter.ArticleViewHolder> () {

    inner class ArticleViewHolder(val view : ItemArtikelBinding) : RecyclerView.ViewHolder(view.root)

    private var listArticle = ArrayList<Artikel>()
    private var onItemCallback : OnItemCallback? = null

    fun setData(list : List<Artikel>){
        listArticle.clear()
        listArticle.addAll(list)
    }

    fun setOnItemClickCallback(onItemCallback: OnItemCallback){
        this.onItemCallback = onItemCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ArticleViewHolder (
        ItemArtikelBinding.inflate(LayoutInflater.from(parent.context), parent,false)
    )

    override fun getItemCount() = listArticle.size

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val data = listArticle[position]
        holder.view.imgArtikel.setImageResource(data.imageArtikel)
        holder.itemView.setOnClickListener {
            onItemCallback?.onItemClicked(data)
        }
    }
}