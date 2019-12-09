package mn.tuugii.curriculumvitae

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var mumLogo : ImageView = itemView.findViewById<ImageView>(R.id.imgLogo)


        var parentlayout : RelativeLayout = itemView.findViewById(R.id.playout) as RelativeLayout
    }

    fun btnEnter(view: View){
        var intt = Intent(this, CardActivity::class.java)
        //intt.putExtra()
        startActivity(intt)
    }
}
