package com.example.uiappweek6

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.example.uiappweek6.databinding.ActivityCatelogueBinding
import com.example.uiappweek6.helperclasses.adapters.CatalogueViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class CatalogueActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCatelogueBinding

    // Action bar views.
    private lateinit var tvActionBarTitle: TextView
    private lateinit var ivActionBarEndButton: ImageView
    private lateinit var ivActionBarBackButton: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCatelogueBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initializeComponents()
    }

    private fun initializeComponents() {
        // Set up view pager and tab layout.
        val listTabs: List<Int> = listOf(R.string.products, R.string.categories)
        binding.viewPagerCatalogue.adapter = CatalogueViewPagerAdapter(listTabs)
        TabLayoutMediator(binding.tabLayoutCatalogue, binding.viewPagerCatalogue) { tab, position ->
            tab.text = resources.getString(listTabs[position])
        }.attach()

        // Change the action bar to custom action bar.
        supportActionBar!!.displayOptions =
            ActionBar.DISPLAY_SHOW_CUSTOM
        supportActionBar!!.setDisplayShowCustomEnabled(true)
        supportActionBar!!.setCustomView(R.layout.custom_action_bar_layout)
        supportActionBar!!.elevation = 0F
        val customActionBarView: View = supportActionBar!!.customView
        tvActionBarTitle = customActionBarView.findViewById(R.id.tvActionBarTitle)
        ivActionBarEndButton = customActionBarView.findViewById(R.id.ivActionBarEndIcon)
        ivActionBarBackButton = customActionBarView.findViewById(R.id.ivActionBarBackButton)
        tvActionBarTitle.setText(R.string.catalogue)
        ivActionBarEndButton.setImageResource(R.drawable.ic_baseline_search_24)
        ivActionBarBackButton.visibility = View.GONE
    }
}