package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView

internal class RecyclerViewAdapter(private var itemsList: List<String>) : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    private lateinit var mListener: onItemClicked

    interface onItemClicked{
        fun onItemClicked(position: Int){

        }
    }

    fun setOnItemClickListener(listener: onItemClicked){
        mListener = listener

    }


    //Coloca os items no xml dinamicamente
    internal inner class MyViewHolder(view: View, listener: onItemClicked) : RecyclerView.ViewHolder(view) {
        var itemTextView: TextView = view.findViewById(R.id.itemTextView)

        init {
            view.setOnClickListener {
                listener.onItemClicked(adapterPosition)
            }
        }
    }
    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)
        return MyViewHolder(itemView, mListener)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = itemsList[position]
        holder.itemTextView.text = item
    }
    override fun getItemCount(): Int {
        return itemsList.size
    }




}