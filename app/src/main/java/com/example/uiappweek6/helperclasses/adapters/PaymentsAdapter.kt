package com.example.uiappweek6.helperclasses.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.uiappweek6.R

class PaymentsAdapter(private val paymentList: ArrayList<Int>) :
    RecyclerView.Adapter<PaymentsAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.card_payments, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvPrice.text = "₹ ${paymentList[position]}"
    }

    override fun getItemCount(): Int {
        return paymentList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvPrice = itemView.findViewById<TextView>(R.id.tvPaymentCardPrice)!!
    }
}