package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SaleAdapter(private val sales: List<Sale>) : RecyclerView.Adapter<SaleAdapter.SaleViewHolder>() {

    class SaleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val sellerTextView: TextView = itemView.findViewById(R.id.sellerTextView)
        val itemNameTextView: TextView = itemView.findViewById(R.id.itemNameTextView)
        val quantityTextView: TextView = itemView.findViewById(R.id.quantityTextView)
        val priceTextView: TextView = itemView.findViewById(R.id.priceTextView)
        val saleDateTextView: TextView = itemView.findViewById(R.id.saleDateTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SaleViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_sale, parent, false)
        return SaleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SaleViewHolder, position: Int) {
        val currentItem = sales[position]
        holder.sellerTextView.text = "Продавец: ${currentItem.seller}"
        holder.itemNameTextView.text = "Наименование: ${currentItem.itemName}"
        holder.quantityTextView.text = "Количество: ${currentItem.quantity}"
        holder.priceTextView.text = "Цена: ${currentItem.price}"
        holder.saleDateTextView.text = "Дата продажи: ${currentItem.saleDate}"
    }

    override fun getItemCount() = sales.size
}