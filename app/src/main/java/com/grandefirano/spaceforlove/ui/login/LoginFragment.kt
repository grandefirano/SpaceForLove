package com.grandefirano.spaceforlove.ui.login

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.navGraphViewModels
import com.grandefirano.spaceforlove.R
import com.grandefirano.spaceforlove.databinding.LoginFragmentBinding

class LoginFragment : Fragment() {


    private val loginViewModel by navGraphViewModels<LoginViewModel>(R.id.mobile_navigation) {
        defaultViewModelProviderFactory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<LoginFragmentBinding>(
            inflater,
            R.layout.login_fragment,
            container, false
        )

        binding.viewmodel=loginViewModel

        return binding.root
    }

}