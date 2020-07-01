package com.grandefirano.spaceforlove.ui.photoMatcher

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import androidx.navigation.navGraphViewModels
import com.grandefirano.spaceforlove.R
import com.grandefirano.spaceforlove.databinding.FragmentPhotoMatcherBinding
import com.grandefirano.spaceforlove.util.GlideApp
import com.grandefirano.spaceforlove.util.RotateTransformation
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_photo_matcher.*

@AndroidEntryPoint
class PhotoMatcherFragment : Fragment() {

    // private lateinit var photoMatcherViewModel: PhotoMatcherViewModel
    private val photoMatcherViewModel by navGraphViewModels<PhotoMatcherViewModel>(R.id.mobile_navigation) {
        defaultViewModelProviderFactory
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentPhotoMatcherBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_photo_matcher, container, false)
        binding.viewmodel=photoMatcherViewModel
        binding.lifecycleOwner=this
        return binding.root
    }
}