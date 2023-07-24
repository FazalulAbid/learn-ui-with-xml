package com.example.uiappweek6.helperclasses.adapters

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.uiappweek6.R
import com.example.uiappweek6.helperclasses.data.MarketingStore

class MarketingStoreAdapter(
    private val context: Context?,
    private val listMarketingStore: ArrayList<MarketingStore>,
    private val itemClickListener: OnItemClickListener
) : RecyclerView.Adapter<MarketingStoreAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_marketing_designs, parent, false)
        return MyViewHolder(itemView)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // Set title text.
        holder.run {
            tvMarkStoreCardText.setText(listMarketingStore[position].title)
            // Set card image view icon.
            ivMarkStoreCardIcon.setImageResource(listMarketingStore[position].image)
            // Set icon card background color.
            cvMarkStoreCardIcon.setCardBackgroundColor(context!!.getColor(listMarketingStore[position].color));
            // Set id to card tag.
            cvMarketingStoreCard.tag = listMarketingStore[position].id
            // Hide new tag.
            if (listMarketingStore[position].id==7)
                ivMarkStoreCardNewTag.visibility = View.VISIBLE
        }
    }

    override fun getItemCount(): Int {
        return listMarketingStore.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val cvMarketingStoreCard: CardView = itemView.findViewById(R.id.cvMarketingStoreCard)
        val cvMarkStoreCardIcon: CardView = itemView.findViewById(R.id.cvMarkStoreCardIcon)
        val ivMarkStoreCardIcon: ImageView = itemView.findViewById(R.id.ivMarkStoreCardIcon)
        val ivMarkStoreCardNewTag: ImageView = itemView.findViewById(R.id.ivMarkStoreCardNewTag)
        val tvMarkStoreCardText: TextView = itemView.findViewById(R.id.tvMarkStoreCardText)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            if (adapterPosition != RecyclerView.NO_POSITION)
                itemClickListener.onItemClick(v, adapterPosition)
        }
    }

    interface OnItemClickListener {
        fun onItemClick(v: View, position: Int)
    }
}