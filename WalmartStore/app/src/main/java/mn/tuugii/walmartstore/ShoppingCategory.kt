package mn.tuugii.walmartstore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_shopping_category.*
import android.widget.Toast

class ShoppingCategory : AppCompatActivity() {
    var username : String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_category)

        val intt = intent
        username = intt.getStringExtra("msg")
        txtWelcome.text = "Welcome " + username
        //txtWelcome.gr

        Toast.makeText(this, "Welcome " + username, Toast.LENGTH_LONG).show()
    }

    fun onClickCategory(view: View) {
        Toast.makeText(this, "Hi $username. This is a Toast.", Toast.LENGTH_LONG).show()
    }
}
