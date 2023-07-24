package com.example.uiappweek6.helperclasses.general

import com.example.uiappweek6.R
import com.example.uiappweek6.helperclasses.data.MarketingStore

class PublicConstants {
    companion object {
        val listMarketingStore: ArrayList<MarketingStore> = arrayListOf(
            MarketingStore(
                1,
                R.drawable.ic_volume_high_solid,
                R.string.marketing_designs,
                R.color.manage_store_color_1
            ),
            MarketingStore(
                2,
                R.drawable.ic_indian_rupee_sign_solid,
                R.string.online_payments,
                R.color.manage_store_color_2
            ),
            MarketingStore(
                3,
                R.drawable.ic_discount,
                R.string.discount_coupons,
                R.color.manage_store_color_3
            ),
            MarketingStore(
                4,
                R.drawable.ic_customers,
                R.string.my_customers,
                R.color.manage_store_color_4
            ),
            MarketingStore(
                5,
                R.drawable.ic_qrcode_solid,
                R.string.store_qr_code,
                R.color.manage_store_color_5
            ),
            MarketingStore(
                6,
                R.drawable.ic_money_bills_solid,
                R.string.extra_charges,
                R.color.manage_store_color_6
            ),
            MarketingStore(
                7,
                R.drawable.ic_order_form,
                R.string.order_form,
                R.color.manage_store_color_7
            ),
        )

        // Frequently asked questions.
        val faqHeader: MutableList<String> =
            arrayListOf(
                "What type of business can use Dukaan Premium?",
                "What is your refund policy?",
                "What payment methods do you offer?",
                "What happens when my fees trial ends?",
                "What are the terms for the custom domain?"
            )
        val faqBody: String =
            "Dukaan caters to a wide variety of sellers. Be it a small grocery store or a big legacy brand - anyone who wants to sell their products/services online - Dukaan is the perfect platform for you."
    }
}