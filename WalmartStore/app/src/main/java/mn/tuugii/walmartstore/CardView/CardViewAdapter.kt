package mn.tuugii.walmartstore.CardView

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
import mn.tuugii.walmartstore.R

class CardViewAdapter(var context : Context,
                      var text1 : Array<String>,
                      var text2 : Array<String>,
                      var txtColor : Array<String>,
                      var img : IntArray,
                      var text3 : Array<String>) : RecyclerView.Adapter<CardViewAdapter.MyViewHolder>(){

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.im.setImageResource(img[position])
        holder.t1.text = text1[position]
        holder.t2.text = text2[position]
        holder.color.text = txtColor[position]

        holder.parentlayout.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            var res = text1[position]
            Toast.makeText(context," $res clicked",Toast.LENGTH_LONG).show()
            intent.putExtra("image", img[position])
            intent.putExtra("name", text1[position])
            intent.putExtra("detail",text3[position])
            intent.putExtra("color",txtColor[position])
            context.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.card_layout, parent, false)
        return MyViewHolder(v);
    }
    override fun getItemCount(): Int {
        return text1.size
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var t1: TextView = itemView.findViewById<TextView>(R.id.tvTitle)
        var t2: TextView = itemView.findViewById<TextView>(R.id.tvPrice)
        var color: TextView = itemView.findViewById<TextView>(R.id.tvColor)
        var im : ImageView = itemView.findViewById<ImageView>(R.id.imageView)
        var parentlayout : RelativeLayout = itemView.findViewById(R.id.playout) as RelativeLayout
    }

}