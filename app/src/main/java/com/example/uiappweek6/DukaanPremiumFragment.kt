package com.example.uiappweek6

import android.animation.LayoutTransition
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.example.uiappweek6.databinding.FragmentDukaanPremiumBinding
import com.example.uiappweek6.databinding.FragmentManageStoreBinding
import com.example.uiappweek6.helperclasses.adapters.FaqExpandableAdapter
import com.example.uiappweek6.helperclasses.general.PublicConstants

class DukaanPremiumFragment : Fragment(R.layout.fragment_dukaan_premium) {
    // Action bar views.
    private lateinit var tvActionBarTitle: TextView
    private lateinit var ivActionBarEndButton: ImageView
    private lateinit var ivActionBarBackButton: ImageView

    private lateinit var binding:FragmentDukaanPremiumBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDukaanPremiumBinding.inflate(inflater, container, false)
        return binding.root
    }

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
        (activity as AppCompatActivity?)!!.supportActionBar!!.elevation = 0F
        val customActionBarView: View =
            (activity as AppCompatActivity?)!!.supportActionBar!!.customView
        tvActionBarTitle = customActionBarView.findViewById(R.id.tvActionBarTitle)
        ivActionBarEndButton = customActionBarView.findViewById(R.id.ivActionBarEndIcon)
        ivActionBarBackButton = customActionBarView.findViewById(R.id.ivActionBarBackButton)
        tvActionBarTitle.text = "Dukaan Premium"
        ivActionBarEndButton.visibility = View.GONE
        ivActionBarBackButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        // Set up expandable list view.
        binding.expandableListViewFAQ.setAdapter(FaqExpandableAdapter(activity?.applicationContext,binding.expandableListViewFAQ, PublicConstants.faqHeader, PublicConstants.faqBody))
    }
}