package br.com.jef.agendav3.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import br.com.jef.agendav3.R

class Adapter(private val listName: MutableList<String>, val nameSelected: (String) -> Unit) :
    RecyclerView.Adapter<ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.activity_adapter, parent, false)
        return ItemViewHolder(view)
    }


    override fun getItemCount() = listName.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val name = listName[position]
        holder.txtName.text = name
        holder.txtName.setOnClickListener {
            nameSelected(name)
        }
        holder.removeImg.setOnClickListener { remove(name) }

        holder.removeImg.setOnClickListener {
            remove(name)
            notifyDataSetChanged()
        }
    }

    private fun remove(name: String) {
        listName.remove(name)

    }

}

class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val txtName = view.findViewById<TextView>(R.id.txtName)
    val removeImg = view.findViewById<ImageView>(R.id.deleteImg)


}

