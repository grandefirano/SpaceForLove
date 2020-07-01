package com.grandefirano.spaceforlove.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.grandefirano.spaceforlove.R
import kotlinx.android.synthetic.main.fragment_photo_matcher.*



    @BindingAdapter("imageUrl")
    fun loadImage(view:ImageView,url:String?){

        GlideApp.with(view.context)
                .load(url)
                .centerCrop()
                .error(R.drawable.ic_launcher_background)
                .transform(RotateTransformation(90f))
                .into(view)

    }
