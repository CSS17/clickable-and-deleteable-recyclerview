package com.example.clickableanddeletablerecylcerview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.clickableanddeletablerecylcerview.databinding.ItemListBinding

class RecyclerViewAdapter(private val data:MutableList<String>):RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding=ItemListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ViewHolder(private  val binding: ItemListBinding) :RecyclerView.ViewHolder(binding.root){

        fun bind(item:String){

            binding.item.text=item

            binding.btnShow.setOnClickListener {

                Toast.makeText(itemView.context,item,Toast.LENGTH_SHORT).show()

            }

            binding.btnDelete.setOnClickListener {

                deleteItem(adapterPosition)
            }

        }
        private fun deleteItem(adapterPosition: Int) {
            data.removeAt(adapterPosition)
            notifyItemRemoved(adapterPosition)
        }

    }




}