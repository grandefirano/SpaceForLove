package com.grandefirano.spaceforlove.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.grandefirano.spaceforlove.R
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.view.*

@AndroidEntryPoint
class HomeFragment : Fragment() {

  private val homeViewModel: HomeViewModel by activityViewModels()



  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {

    val root = inflater.inflate(R.layout.fragment_home, container, false)
//    val textView: TextView = root.findViewById(R.id.text_home)

    root.logoutButton.setOnClickListener {
      homeViewModel.logOut()
    }

    return root
  }

  private fun showWelcomeMessage() {
    TODO("Not yet implemented")
  }
}