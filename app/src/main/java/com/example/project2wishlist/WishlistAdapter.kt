package com.example.project2wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WishlistAdapter(private val wishlists: List<Wishlist>): RecyclerView.Adapter<WishlistAdapter.ViewHolder>(){

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        var displayItem: TextView
        var displayPrice: TextView
        var displayURL: TextView

        init {
            displayItem = itemView.findViewById(R.id.showItem)
            displayPrice = itemView.findViewById(R.id.showPrice)
            displayURL = itemView.findViewById(R.id.showURL)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.display_user, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listWish = wishlists[position]

        holder.displayItem.text = listWish.itemName
        holder.displayPrice.text = listWish.price.toString()
        holder.displayURL.text = listWish.url

    }

    override fun getItemCount(): Int {
       return wishlists.size
    }
}