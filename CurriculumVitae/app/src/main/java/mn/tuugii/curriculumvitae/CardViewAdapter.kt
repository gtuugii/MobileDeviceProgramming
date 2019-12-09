package mn.tuugii.curriculumvitae

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import mn.tuugii.curriculumvitae.classes.Person
import java.text.SimpleDateFormat

class CardViewAdapter(var context : Context,
                      val pList: ArrayList<Person>) : RecyclerView.Adapter<CardViewAdapter.MyViewHolder>(){

    override fun onBindViewHolder(holder: MyViewHolder, pos: Int) {

        val formatter = SimpleDateFormat("dd/MM/yyyy")

        holder.img.setImageResource(pList[pos]?.image)
        holder.fullName.text = pList[pos]?.getFullName()
        holder.position.text = "Position: " + pList[pos]?.position.toString()
        holder.age.text = "BirthDay: " + formatter.format(pList[pos]?.bDate)

        holder.parentlayout.setOnClickListener {
            val intt = Intent(context, DetailActivity::class.java)
            var res = pList[pos].getFullName()

            Toast.makeText(context," $res clicked", Toast.LENGTH_LONG).show()

            intt.putExtra("person", pList[pos])
            context.startActivity(intt)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.activity_card, parent, false)
        return MyViewHolder(v)
    }
    override fun getItemCount(): Int {
        return pList?.size
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var img : ImageView = itemView.findViewById<ImageView>(R.id.imageView)
        var fullName: TextView = itemView.findViewById<TextView>(R.id.tvFullName)
        var position: TextView = itemView.findViewById<TextView>(R.id.tvPosition)
        var age: TextView = itemView.findViewById<TextView>(R.id.tvAge)

        var parentlayout : RelativeLayout = itemView.findViewById(R.id.playout) as RelativeLayout
    }

}