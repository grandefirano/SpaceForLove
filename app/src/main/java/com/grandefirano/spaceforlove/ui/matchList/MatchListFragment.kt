package com.grandefirano.spaceforlove.ui.matchList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.grandefirano.spaceforlove.R

class MatchListFragment : Fragment() {

  private lateinit var matchListViewModel: MatchListViewModel

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    matchListViewModel =
    ViewModelProviders.of(this).get(MatchListViewModel::class.java)
    val root = inflater.inflate(R.layout.fragment_match_list, container, false)
    val textView: TextView = root.findViewById(R.id.text_notifications)
    matchListViewModel.text.observe(viewLifecycleOwner, Observer {
      textView.text = it
    })
    return root
  }
}