package mn.tuugii.walmartstore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_shopping_category.*
import android.widget.Toast
import mn.tuugii.walmartstore.cardview.CardViewMainActivity
import mn.tuugii.walmartstore.personview.PersonActivity

class ShoppingCategory : AppCompatActivity() {
    var username : String? = ""
    var categoryList = ArrayList<Category>()
    var productList = ArrayList<Product>()

    var images = intArrayOf(R.drawable.electronic, R.drawable.beauty, R.drawable.phone, R.drawable.medicine)
    //var planets = arrayOf<String>("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_category)

        val intt = intent
        username = intt.getStringExtra("msg")
        txtWelcome.text = "Welcome " + username
        //txtWelcome.gr
        init()
        Toast.makeText(this, "Welcome " + username, Toast.LENGTH_LONG).show()
    }

    fun init(){
        var cat1: Category = Category(1, "Electronics", 1)
        categoryList.add(cat1)

        productList.add(Product(1, cat1, "TV-1", 1000.00, "White", R.drawable.headphones, "This is a new TV"))
        productList.add(Product(2, cat1, "TV-2", 1001.00, "Blue",  R.drawable.servers, "This is a new TV"))
        productList.add(Product(3, cat1, "TV-3", 1002.00, "Black", R.drawable.phones, "This is a new TV"))

        var cat2: Category = Category(2, "Beauty", 2)
        categoryList.add(cat2)
        productList.add(Product(11, cat2, "TV-1", 10.00, "White", R.drawable.tablet, "This is a new beauty"))
        productList.add(Product(12, cat2, "TV-2", 11.00, "Blue", R.drawable.notebook, "This is a new beauty"))
        productList.add(Product(13, cat2, "TV-3", 12.00, "Black", R.drawable.phone, "This is a new beauty"))

        var cat3: Category = Category(3, "Phone", 3)
        categoryList.add(cat3)
        var cat4: Category = Category(4, "Medicine", 4)
        categoryList.add(cat4)
    }

    fun onClickCategory(view: View) {

        when(view){
            imgElectronis -> {
                Toast.makeText(this, "This is an electronic category.", Toast.LENGTH_LONG).show()
                var intt = Intent(this, CardViewMainActivity::class.java)
                //var s = productList.stream().filter { t: Product -> t.catid.toString() == "1" }.toArray()
                intt.putExtra("productList", productList )
                startActivity(intt)
            }
            imgBeauty -> {
                Toast.makeText(this, "This is a beauty category.", Toast.LENGTH_LONG).show()
                var intt = Intent(this, ListProductsActivity::class.java)
                intt.putExtra("productList", productList)
                startActivity(intt)
            }
            imgPhone -> {
                Toast.makeText(this, "This is a phone category.", Toast.LENGTH_LONG).show()
                var intt = Intent(this, RecyclerListViewActivity::class.java)
                intt.putExtra("productList", productList)
                startActivity(intt)
            }
            imgMedicine -> {
                Toast.makeText(this, "This is a medicine category.", Toast.LENGTH_LONG).show()
                var intt = Intent(this, PersonActivity::class.java)
                intt.putExtra("productList", productList)
                startActivity(intt)
            }
        }
    }
}
