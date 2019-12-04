package mn.tuugii.walmartstore.CardView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mn.tuugii.walmartstore.Product
import mn.tuugii.walmartstore.R

class CardViewMainActivity : AppCompatActivity() {

    var r1: RecyclerView? = null
    var layoutManager: RecyclerView.LayoutManager? = null
    var s1 : Array<String>?=null
    var s2 : Array<String>?=null
    var s3 : Array<String>?=null
    var color : Array<String>?=null
    var s4 : ArrayList<String>?=null
    var madr : CardViewAdapter?=null

    //var imageges : IntArray? = null
    var imageges = intArrayOf(
        R.drawable.phone,
        R.drawable.notebook,
        R.drawable.tablet,
        R.drawable.phones,
        R.drawable.servers,
        R.drawable.headphones
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_view_main)

        var intt = intent
        var pList : ArrayList<Product> = intt.getSerializableExtra("productList") as ArrayList<Product>

//        var i = 0
//        for(p in pList){
//            s1!!.set(i, p.title.toString())
//            s2!!.set(i, p.price.toString())
//            s3!!.set(i, p.desc.toString())
//            color!!.set(i, p.color.toString())
//            imageges!!.set(i, p.image)
//            i++
//        }

        r1 = findViewById<RecyclerView>(R.id.rv)
        s1 = resources.getStringArray(R.array.fruits);
        s2 = resources.getStringArray(R.array.desc);
        s3 = resources.getStringArray(R.array.detail);
        color = resources.getStringArray(R.array.fruits);

        madr = CardViewAdapter(this, s1 as Array<String>, s2 as Array<String>,
            color as Array<String>, imageges as IntArray, s3 as Array<String>)

        layoutManager = LinearLayoutManager(this)
        r1?.layoutManager = layoutManager
        r1?.adapter = madr
    }
}
