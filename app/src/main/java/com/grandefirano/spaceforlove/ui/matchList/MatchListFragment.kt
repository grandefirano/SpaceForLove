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
import kotlinx.android.synthetic.main.fragment_match_list.*

class MatchListFragment : Fragment() {

  private val matchListViewModel: MatchListViewModel by activityViewModels()

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val root = inflater.inflate(R.layout.fragment_match_list, container, false)


    return root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    pullToRefresh.setOnRefreshListener {
      matchListViewModel.reloadListOfMatches()
      pullToRefresh.isRefreshing=false
    }
  }
}