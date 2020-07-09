package com.grandefirano.spaceforlove.ui.signUp

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.grandefirano.spaceforlove.R

class SignUpAdressFragment : Fragment() {

    companion object {
        fun newInstance() = SignUpAdressFragment()
    }

    private lateinit var viewModel: SignUpAdressViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.sign_up_adress_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SignUpAdressViewModel::class.java)
        // TODO: Use the ViewModel
    }

}