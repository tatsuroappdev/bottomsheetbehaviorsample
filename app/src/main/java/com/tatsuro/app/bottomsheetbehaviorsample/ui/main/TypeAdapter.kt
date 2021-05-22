package com.tatsuro.app.bottomsheetbehaviorsample.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.tatsuro.app.bottomsheetbehaviorsample.IncomeOrExpenseType
import com.tatsuro.app.bottomsheetbehaviorsample.R

class TypeAdapter(
    private val types: Array<IncomeOrExpenseType>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<TypeAdapter.ViewHolder>() {

    fun interface OnItemClickListener {
        fun onItemClick(item: IncomeOrExpenseType)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val textButton: Button = view.findViewById(R.id.textButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.type_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textButton.apply {
            text = types[position].toString()
            setOnClickListener {
                listener.onItemClick(types[position])
            }
        }
    }

    override fun getItemCount() = types.size
}