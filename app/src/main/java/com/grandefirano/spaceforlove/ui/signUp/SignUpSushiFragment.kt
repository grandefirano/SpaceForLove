package com.grandefirano.spaceforlove.ui.signUp

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.grandefirano.spaceforlove.R

class SignUpSushiFragment : Fragment() {

    companion object {
        fun newInstance() = SignUpSushiFragment()
    }

    private lateinit var viewModel: SignUpSushiViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.sign_up_sushi_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SignUpSushiViewModel::class.java)
        // TODO: Use the ViewModel
    }

}