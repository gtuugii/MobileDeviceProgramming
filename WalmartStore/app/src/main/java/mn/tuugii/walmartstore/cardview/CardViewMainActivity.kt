package mn.tuugii.walmartstore.cardview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_card_view_main.*
import mn.tuugii.walmartstore.Product
import mn.tuugii.walmartstore.R

class CardViewMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_view_main)

        var intt = intent
        var pList : ArrayList<Product> = intt.getSerializableExtra("productList") as ArrayList<Product>

        rv?.layoutManager = LinearLayoutManager(this)
        var madr = CardViewAdapter(this, pList)
        rv?.adapter = madr

    }
}
