package com.grandefirano.spaceforlove.ui.matchingResult

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.grandefirano.spaceforlove.R
import com.grandefirano.spaceforlove.databinding.FragmentMatchingResultBinding

class MatchingResultFragment : Fragment() {

    private val TAG = "MatchingResultFragment"
    private val viewModel: MatchingResultViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val binding=DataBindingUtil.inflate<FragmentMatchingResultBinding>(
            inflater,
            R.layout.fragment_matching_result,
            container,
            false
        )
        binding.viewmodel=viewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        val args: MatchingResultFragmentArgs by navArgs()
        viewModel.likes=args.likes
        viewModel.dislikes=args.dislikes
        viewModel.reviewOfPhotos=args.reviewOfPhotos
        
        val b=viewModel.saveSwipedPhotosToFirebase()

        Log.d(TAG, "onViewCreated:saved successfully? $b")

    }



}