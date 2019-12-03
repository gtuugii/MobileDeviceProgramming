package mn.tuugii.walmartstore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_list_products.*

class ListProductsActivity : AppCompatActivity() {

    var MY_TAG = "ProductList"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_products)

        var intt = intent
        var alist : ArrayList<Product> = intt.getSerializableExtra("productList") as ArrayList<Product>

        Log.i(MY_TAG, alist!!.size.toString());

//        var slist : Array<String?>? = null
//        var i = 0
//        for(p in alist){
//            slist!!.set(i, p.title.toString())
//            Log.i(MY_TAG, p.title.toString());
//            i ++
//        }

        //var planets = arrayOf<String>("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
        //val adapter = ArrayAdapter<Product>(this, android.R.layout.simple_spinner_dropdown_item, planets)

//        //val adapter = ArrayAdapter<Product>(this, android.R.layout.simple_spinner_dropdown_item, alist)
        val adapter = ArrayAdapter<Product>(this, android.R.layout.simple_spinner_dropdown_item, alist)
        lview.adapter = adapter
        lview.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val item = parent.getItemAtPosition(position).toString()
                //val intent = Intent(applicationContext, PlanetActivity::class.java)
                //intent.putExtra("image", imageges[position])
                //startActivity(intent)
                Toast.makeText(this, "Welcome this is toast message !!! position: $position, id=$id", Toast.LENGTH_LONG).show()
            }
    }
}
