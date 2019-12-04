package mn.tuugii.walmartstore.cardview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.content.Intent
import android.widget.Toast
import mn.tuugii.walmartstore.Product
import mn.tuugii.walmartstore.R

class CardViewAdapter(var context : Context,
                      val pList: ArrayList<Product>) : RecyclerView.Adapter<CardViewAdapter.MyViewHolder>(){

    override fun onBindViewHolder(holder: MyViewHolder, pos: Int) {

        holder.img.setImageResource(pList[pos]?.image)
        holder.title.text = pList[pos]?.title.toString()
        holder.price.text = "Price: $" + pList[pos]?.price.toString()
        holder.color.text = "Color: " + pList[pos]?.color.toString()

        holder.parentlayout.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            var res = pList[pos].title.toString()

            Toast.makeText(context," $res clicked", Toast.LENGTH_LONG).show()

            intent.putExtra("product", pList[pos])
            context.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.card_layout, parent, false)
        return MyViewHolder(v)
    }
    override fun getItemCount(): Int {
        return pList?.size
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.findViewById<TextView>(R.id.tvTitle)
        var price: TextView = itemView.findViewById<TextView>(R.id.tvPrice)
        var color: TextView = itemView.findViewById<TextView>(R.id.tvColor)
        var img : ImageView = itemView.findViewById<ImageView>(R.id.imageView)
        var parentlayout : RelativeLayout = itemView.findViewById(R.id.playout) as RelativeLayout
    }

}