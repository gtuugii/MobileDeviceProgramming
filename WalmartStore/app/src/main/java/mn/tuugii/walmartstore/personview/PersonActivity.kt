package mn.tuugii.walmartstore.personview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mn.tuugii.walmartstore.R

class PersonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person)

        //initialize the recyclerView from the XML
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        //Initializing the type of layout, here I have used LinearLayoutManager you can try GridLayoutManager
        //Based on your requirement to allow vertical or horizontal scroll , you can change it in  LinearLayout.VERTICAL
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        val dataList = ArrayList<Person>()
        dataList.add(Person("Battuguldur", 11))
        dataList.add(Person("Purevdemberel", 22))
        dataList.add(Person("Tuugii", 33))
        dataList.add(Person("Puujee", 44))

        val rvAdapter = RvAdapter(dataList)

        recyclerView.adapter = rvAdapter
    }
}
