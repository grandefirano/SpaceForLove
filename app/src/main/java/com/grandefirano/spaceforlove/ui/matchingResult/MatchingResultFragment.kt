package com.grandefirano.spaceforlove.ui.matchingResult

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.grandefirano.spaceforlove.R

class MatchingResultFragment : Fragment() {

    companion object {
        fun newInstance() =
            MatchingResultFragment()
    }

    private lateinit var viewModel: MatchingResultViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_matching_result, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MatchingResultViewModel::class.java)
        // TODO: Use the ViewModel
    }

}