package com.example.uiappweek6

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class AdditionalInformationFragment:Fragment(R.layout.fragment_additional_information) {
    // Action bar views.
    private lateinit var tvActionBarTitle: TextView
    private lateinit var ivActionBarEndButton: ImageView
    private lateinit var ivActionBarBackButton: ImageView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeComponents()
    }

    private fun initializeComponents() {
        // Change the action bar to custom action bar.
        (activity as AppCompatActivity?)!!.supportActionBar!!.displayOptions =
            ActionBar.DISPLAY_SHOW_CUSTOM
        (activity as AppCompatActivity?)!!.supportActionBar!!.setDisplayShowCustomEnabled(true)
        (activity as AppCompatActivity?)!!.supportActionBar!!.setCustomView(R.layout.custom_action_bar_layout)
        val customActionBarView: View =
            (activity as AppCompatActivity?)!!.supportActionBar!!.customView
        tvActionBarTitle = customActionBarView.findViewById(R.id.tvActionBarTitle)
        ivActionBarEndButton = customActionBarView.findViewById(R.id.ivActionBarEndIcon)
        ivActionBarBackButton = customActionBarView.findViewById(R.id.ivActionBarBackButton)
        tvActionBarTitle.setText(R.string.additional_information)
        ivActionBarEndButton.visibility = View.GONE

        ivActionBarBackButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }
}