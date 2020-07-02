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
import com.grandefirano.spaceforlove.ui.home.HomeViewModel.AuthenticationState.AUTHENTICATED
import com.grandefirano.spaceforlove.ui.home.HomeViewModel.AuthenticationState.UNAUTHENTICATED

class HomeFragment : Fragment() {

  private val homeViewModel: HomeViewModel by activityViewModels()

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {

    val root = inflater.inflate(R.layout.fragment_home, container, false)
//    val textView: TextView = root.findViewById(R.id.text_home)
    homeViewModel.text.observe(viewLifecycleOwner, Observer {


      val navController = findNavController()
      homeViewModel.authenticationState.observe(viewLifecycleOwner, Observer { authenticationState ->
        when (authenticationState) {
          AUTHENTICATED -> showWelcomeMessage()
          UNAUTHENTICATED -> navController.navigate(R.id.login_fragment)
        }
      })

//      textView.text = it
    })
    return root
  }

  private fun showWelcomeMessage() {
    TODO("Not yet implemented")
  }
}