package com.iremnurpirincci.odev3.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.bumptech.glide.Glide
import com.iremnurpirincci.odev3.R
import com.iremnurpirincci.odev3.databinding.ItemUrunBinding
import com.iremnurpirincci.odev3.model.urun
import com.iremnurpirincci.odev3.util.downloadURL

class UrunAdapter(var urunList: ArrayList<urun>): RecyclerView.Adapter<UrunAdapter.UrunViewHolder>() {

    class UrunViewHolder(var view: ItemUrunBinding): RecyclerView.ViewHolder(view.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UrunViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ItemUrunBinding>(inflater, R.layout.item_urun,parent,false)
        return UrunViewHolder(view)
    }

    override fun getItemCount(): Int {
        return urunList.size
    }

    @SuppressLint("DefaultLocale")
    override fun onBindViewHolder(holder: UrunViewHolder, position: Int) {
        holder.view.titleTV.text = urunList[position].title
        holder.view.priceTv.text = String.format("$%.2f", urunList[position].price)
        holder.view.urunIV.downloadURL(urunList[position].flagUrl)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newList:List<urun>){
        urunList = newList as ArrayList<urun>
        notifyDataSetChanged()
    }
}