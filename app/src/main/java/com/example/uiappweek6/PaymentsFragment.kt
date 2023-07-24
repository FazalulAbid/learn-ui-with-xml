package com.example.uiappweek6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uiappweek6.databinding.FragmentPaymentsBinding
import com.example.uiappweek6.helperclasses.adapters.PaymentsAdapter


class PaymentsFragment : Fragment(R.layout.fragment_payments) {
    // Action bar views.
    private lateinit var tvActionBarTitle: TextView
    private lateinit var ivActionBarEndButton: ImageView

    private lateinit var binding: FragmentPaymentsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPaymentsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeComponents()
    }

    private fun initializeComponents() {
        // Set recycler view adapter.
        val linearLayoutManager =
            object : LinearLayoutManager(activity) {
                override fun canScrollVertically() = true
            }

        binding.rvPayments.layoutManager = linearLayoutManager
        binding.rvPayments.setHasFixedSize(true)
        val dividerItemDecoration = DividerItemDecoration(
            binding.rvPayments.context,
            linearLayoutManager.orientation
        )
        binding.rvPayments.addItemDecoration(dividerItemDecoration)
        binding.rvPayments.isNestedScrollingEnabled = false
        binding.rvPayments.adapter =
            PaymentsAdapter(arrayListOf(799, 199, 299, 399, 499, 599, 699, 799, 899, 999, 1099))

        // Change the action bar to custom action bar.
        (activity as AppCompatActivity?)!!.supportActionBar!!.displayOptions =
            ActionBar.DISPLAY_SHOW_CUSTOM
        (activity as AppCompatActivity?)!!.supportActionBar!!.setDisplayShowCustomEnabled(true)
        (activity as AppCompatActivity?)!!.supportActionBar!!.setCustomView(R.layout.custom_action_bar_layout)
        val customActionBarView: View =
            (activity as AppCompatActivity?)!!.supportActionBar!!.customView
        tvActionBarTitle = customActionBarView.findViewById(R.id.tvActionBarTitle)
        ivActionBarEndButton = customActionBarView.findViewById(R.id.ivActionBarEndIcon)
        tvActionBarTitle.setText(R.string.payments)
        ivActionBarEndButton.setImageResource(R.drawable.ic_baseline_info_24)
    }
}