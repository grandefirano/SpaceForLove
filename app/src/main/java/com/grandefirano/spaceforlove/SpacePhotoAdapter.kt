package com.grandefirano.spaceforlove

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.grandefirano.spaceforlove.data.entity.NasaPhotoOfTheDay
import com.grandefirano.spaceforlove.databinding.CardViewSpacePhotoBinding

class SpacePhotoAdapter() :
    ListAdapter<NasaPhotoOfTheDay, SpacePhotoAdapter.SpacePhotoViewHolder>(DIFF_CALLBACK) {

    companion object {
        val DIFF_CALLBACK = object : ItemCallback<NasaPhotoOfTheDay>() {
            override fun areItemsTheSame(
                oldItem: NasaPhotoOfTheDay,
                newItem: NasaPhotoOfTheDay
            ): Boolean {
                return oldItem.date == newItem.date
            }

            override fun areContentsTheSame(
                oldItem: NasaPhotoOfTheDay,
                newItem: NasaPhotoOfTheDay
            ): Boolean {
                return oldItem.url == newItem.url &&
                        oldItem.explanation == newItem.url &&
                        oldItem.mediaType == newItem.url &&
                        oldItem.title == newItem.url
            }

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= SpacePhotoViewHolder (
        DataBindingUtil.inflate<CardViewSpacePhotoBinding>(
            LayoutInflater.from(parent.context),
            R.layout.card_view_space_photo,
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: SpacePhotoViewHolder, position: Int) {
        getItem(position)?.let {
            holder.binding.photoOfTheDay=it
            holder.binding.executePendingBindings()
        }
    }

    inner class SpacePhotoViewHolder(val binding: CardViewSpacePhotoBinding) :
        RecyclerView.ViewHolder(binding.root){

    }

}