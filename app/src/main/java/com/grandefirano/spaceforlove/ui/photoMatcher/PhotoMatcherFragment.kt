package com.grandefirano.spaceforlove.ui.photoMatcher

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import com.grandefirano.spaceforlove.R
import com.grandefirano.spaceforlove.util.GlideApp
import com.grandefirano.spaceforlove.util.RotateTransformation
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_photo_matcher.*

class PhotoMatcherFragment : Fragment() {

  private lateinit var photoMatcherViewModel: PhotoMatcherViewModel




  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    photoMatcherViewModel =
    ViewModelProviders.of(this).get(PhotoMatcherViewModel::class.java)
    val root = inflater.inflate(R.layout.fragment_photo_matcher, container, false)

    photoMatcherViewModel.text.observe(viewLifecycleOwner, Observer {
      //textView.text = it
      GlideApp.with(this)
        .load(it)
        .transform(RotateTransformation(90f))
        .into(nasaPhoto)

    })
    return root
  }
}