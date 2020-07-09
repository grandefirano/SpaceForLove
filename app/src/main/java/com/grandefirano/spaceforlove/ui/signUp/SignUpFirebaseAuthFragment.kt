package com.grandefirano.spaceforlove.ui.signUp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.grandefirano.spaceforlove.R
import com.grandefirano.spaceforlove.databinding.FragmentSignUpFirebaseAuthBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpFirebaseAuthFragment : Fragment() {

    private val signUpFirebaseAuthViewModel: SignUpFirebaseAuthViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentSignUpFirebaseAuthBinding>(
            inflater,
            R.layout.fragment_sign_up_firebase_auth,
            container, false
        )

        binding.viewmodel=signUpFirebaseAuthViewModel

        return binding.root

    }

}