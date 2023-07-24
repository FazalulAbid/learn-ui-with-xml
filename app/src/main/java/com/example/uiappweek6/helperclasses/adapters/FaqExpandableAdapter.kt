package com.example.uiappweek6.helperclasses.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.ExpandableListView
import android.widget.TextView
import com.example.uiappweek6.R

class FaqExpandableAdapter(
    context: Context?,
    private val expandableListView: ExpandableListView,
    private val headers: MutableList<String>,
    private val strBody: String
) :
    BaseExpandableListAdapter() {
    override fun getGroupCount(): Int {
        return headers.size
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return 1
    }

    override fun getGroup(groupPosition: Int): String {
        return headers[groupPosition]
    }

    override fun getChild(groupPosition: Int, childPosition: Int): String {
        return strBody
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        var convertView = convertView
        val inflater =
            parent?.context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        convertView = inflater.inflate(R.layout.faq_group_layout, null)
        val titleView = convertView?.findViewById<TextView>(R.id.tvExpandableFaqTitle)
        titleView?.text = getGroup(groupPosition)
        titleView?.setOnClickListener {
            if (expandableListView.isGroupExpanded(groupPosition))
                expandableListView.collapseGroup(groupPosition)
            else
                expandableListView.expandGroup(groupPosition)
        }
        return convertView
    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View? {
        var convertView = convertView
        val inflater =
            parent?.context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        convertView = inflater.inflate(R.layout.faq_child_layout, null)
        val titleView = convertView?.findViewById<TextView>(R.id.tvExpandableFaqContent)
        titleView?.text = getChild(groupPosition, childPosition)
        return convertView
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }
}