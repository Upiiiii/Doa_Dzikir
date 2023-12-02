package com.idn.doadzikir.Utills

import com.idn.doadzikir.model.Artikel

interface OnItemCallback {
    fun onItemClicked(item: Artikel)
}