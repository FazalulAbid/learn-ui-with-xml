package com.example.uiappweek6

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uiappweek6.databinding.FragmentManageStoreBinding
import com.example.uiappweek6.helperclasses.adapters.MarketingStoreAdapter
import com.example.uiappweek6.helperclasses.general.PublicConstants

class ManageStoreFragment : Fragment(R.layout.fragment_manage_store),
    MarketingStoreAdapter.OnItemClickListener {
    // View Declarations.
    private lateinit var recyclerView: RecyclerView

    // Action bar views.
    private lateinit var tvActionBarTitle: TextView
    private lateinit var ivActionBarBackButton: ImageView
    private lateinit var ivActionBarEndButton: ImageView

    private lateinit var binding: FragmentManageStoreBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentManageStoreBinding.inflate(inflater, container, false)
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
        val customActionBarView: View =
            (activity as AppCompatActivity?)!!.supportActionBar!!.customView
        tvActionBarTitle = customActionBarView.findViewById(R.id.tvActionBarTitle)
        ivActionBarBackButton = customActionBarView.findViewById(R.id.ivActionBarBackButton)
        ivActionBarEndButton = customActionBarView.findViewById(R.id.ivActionBarEndIcon)
        tvActionBarTitle.setText(R.string.manage_store)
        ivActionBarBackButton.visibility = View.GONE
        ivActionBarEndButton.visibility = View.GONE

        // Set recycler view adapter.
        binding.rvManageStore.layoutManager = GridLayoutManager(activity, 2)
        binding.rvManageStore.adapter =
            MarketingStoreAdapter(
                activity?.applicationContext,
                PublicConstants.listMarketingStore,
                this
            )

        // Set on click listener for bottom navigation menu.
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.msMenuHome -> toastSomething("Home")
                R.id.msMenuOrders -> toastSomething("Orders")
                R.id.msMenuProducts -> toastSomething("Products")
                R.id.rvManageStore -> toastSomething("Manage")
                R.id.msMenuAccount -> toastSomething("Account")
            }
            true
        }

        // Show a badge above order manu.
        binding.bottomNavigationView.getOrCreateBadge(R.id.msMenuOrders).apply {
            number = 29
            isVisible = true
        }
    }

    private fun toastSomething(str: String) {
        Toast.makeText(activity?.applicationContext, str, Toast.LENGTH_SHORT).show()
    }

    private fun gotoFragment(fragment: Fragment) {
        activity?.supportFragmentManager?.beginTransaction()?.apply {
            replace(R.id.flFragment, fragment)
            addToBackStack(null)
            commit()
        }
    }

    private fun gotoCatalogue() {
        activity?.let {
            val intent = Intent(it, CatalogueActivity::class.java)
            it.startActivity(intent)
        }
    }

    override fun onItemClick(v: View, position: Int) {
        when (position + 1) {
            1 -> gotoFragment(PaymentsFragment())
            2 -> gotoCatalogue()
            3 -> gotoFragment(AdditionalInformationFragment())
            4 -> gotoFragment(OrderFragment())
            5 -> gotoFragment(DukaanPremiumFragment())
            else -> toastSomething("Enter Click another option $position")
        }
    }
}