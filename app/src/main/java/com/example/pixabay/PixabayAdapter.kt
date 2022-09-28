package com.example.pixabay

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.pixabay.databinding.ItemWordBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PixabayAdapter(private val list: ArrayList<ImageModel>) :
    RecyclerView.Adapter<PixabayAdapter.PixabayViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PixabayViewHolder {
        return PixabayViewHolder(
            ItemWordBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PixabayViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class PixabayViewHolder(private val binding: ItemWordBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(model: ImageModel) {
            binding.ivWord.load(model.largeImageURL)
        }
    }

    fun addImage(imageModel: ImageModel) {
        list.add(imageModel)
        notifyDataSetChanged()
    }
}