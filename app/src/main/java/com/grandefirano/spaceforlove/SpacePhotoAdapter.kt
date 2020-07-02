package com.grandefirano.spaceforlove

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.grandefirano.spaceforlove.data.NasaPhotoOfTheDayResponse
import com.grandefirano.spaceforlove.databinding.CardViewSpacePhotoBinding

class SpacePhotoAdapter() :
    ListAdapter<NasaPhotoOfTheDayResponse, SpacePhotoAdapter.SpacePhotoViewHolder>(DIFF_CALLBACK) {

    companion object {
        val DIFF_CALLBACK = object : ItemCallback<NasaPhotoOfTheDayResponse>() {
            override fun areItemsTheSame(
                oldItem: NasaPhotoOfTheDayResponse,
                newItem: NasaPhotoOfTheDayResponse
            ): Boolean {
                return oldItem.date == newItem.date
            }

            override fun areContentsTheSame(
                oldItem: NasaPhotoOfTheDayResponse,
                newItem: NasaPhotoOfTheDayResponse
            ): Boolean {
                return oldItem.url == newItem.url &&
                        oldItem.explanation == newItem.url &&
                        oldItem.hdurl == newItem.url &&
                        oldItem.mediaType == newItem.url &&
                        oldItem.serviceVersion == newItem.url &&
                        oldItem.title == newItem.url &&
                        oldItem.serviceVersion == newItem.url
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