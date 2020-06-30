package com.grandefirano.spaceforlove.ui.photoMatcher

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.grandefirano.spaceforlove.R

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
    val textView: TextView = root.findViewById(R.id.text_dashboard)
    photoMatcherViewModel.text.observe(viewLifecycleOwner, Observer {
      textView.text = it
    })
    return root
  }
}