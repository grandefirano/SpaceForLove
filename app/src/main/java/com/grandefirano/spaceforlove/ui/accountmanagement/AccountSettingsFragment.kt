package com.grandefirano.spaceforlove.ui.accountmanagement

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.grandefirano.spaceforlove.R

class AccountSettingsFragment : Fragment() {

    private val settingsViewModel: AccountSettingsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.account_settings_fragment, container, false)
    }


}