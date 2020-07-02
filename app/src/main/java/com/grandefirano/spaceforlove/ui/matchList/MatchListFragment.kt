package com.grandefirano.spaceforlove.ui.matchList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.grandefirano.spaceforlove.R

class MatchListFragment : Fragment() {

  private val matchListViewModel: MatchListViewModel by activityViewModels()

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val root = inflater.inflate(R.layout.fragment_match_list, container, false)
    //val textView: TextView = root.findViewById(R.id.text_notifications)
    matchListViewModel.text.observe(viewLifecycleOwner, Observer {
    //  textView.text = it
    })
    return root
  }
}