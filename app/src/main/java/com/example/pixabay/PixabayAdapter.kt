package com.example.pixabay

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.pixabay.databinding.ItemWordBinding

class PixabayAdapter(val list: List<ImageModel>) : RecyclerView.Adapter<PixabayAdapter.PixabayViewHolder>() {

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

    class PixabayViewHolder(private val binding: ItemWordBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(model: ImageModel) {
            binding.ivWord.load(model.largeImageURL)
        }

    }
}