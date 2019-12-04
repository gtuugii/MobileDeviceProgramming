package mn.tuugii.walmartstore.cardview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.detail_layout.*
import mn.tuugii.walmartstore.Product
import mn.tuugii.walmartstore.R

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_layout)
        // To avoid application crash check intent has data or not
        if(intent.hasExtra("product")){

            var p:Product = intent.getSerializableExtra("product") as Product
            detailTitle.text = p?.title.toString()
            detailColor.text = "Color: " + p?.color.toString()
            detailItemId.text = "ItemId: " + p?.itemid.toString()
            detailPrice.text = "Price: $" + p?.price.toString()
            detailDesc.text = p?.desc.toString()
            imageView.setImageResource(p?.image)
        }
    }
}
