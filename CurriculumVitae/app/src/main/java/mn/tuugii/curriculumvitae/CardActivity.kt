package mn.tuugii.curriculumvitae

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_card_view.*
import mn.tuugii.curriculumvitae.classes.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.content_main.*

class CardActivity : AppCompatActivity() {
    val dformat: SimpleDateFormat = SimpleDateFormat("MM/dd/yyyy", Locale.US)
    var personList = ArrayList<Person>()

    var listItems = ArrayList<String>()
    var adapter2: ArrayAdapter<String>? = null
    var undoOnClickListener: View.OnClickListener = View.OnClickListener { view ->
        listItems.removeAt(listItems.size - 1)
        adapter2?.notifyDataSetChanged()
        
        Snackbar.make(view, "Item removed", Snackbar.LENGTH_LONG)
            .setAction("Action", null).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_view)

        setSupportActionBar(toolbar)
        adapter2 = ArrayAdapter(this, android.R.layout.simple_list_item_1,
            listItems)
        listView.adapter = adapter2

        fab.setOnClickListener { view ->
            addListItem()
            Snackbar.make(view, "Item added to list", Snackbar.LENGTH_LONG)
                .setAction("Undo", undoOnClickListener).show()
        }

        init()

        rv?.layoutManager = LinearLayoutManager(this)
        var adapter = CardViewAdapter(this, personList)
        rv!!.adapter = adapter
    }
    private fun addListItem() {
        val dateformat: SimpleDateFormat = SimpleDateFormat("HH:mm:ss MM/dd/yyyy", Locale.US)
        listItems.add(dateformat.format(Date()))
        adapter2?.notifyDataSetChanged()
    }
    fun init(){

        //Puujee
        var a1 = Address(11,"FairField", "IOWA", "", 52556, "Trlr-4A", "")

        var addList1 = ArrayList<Address>()
        addList1.add(a1)

        var e1 = Education(21, dformat.parse("09/01/2000"), dformat.parse("06/01/2004"),
            "National Univercity of Mongolia", 3.4, "Bachelor", "")
        var eduList1 = ArrayList<Education>()
        eduList1.add(e1)

        var w11 = Work(31, "Zoosbank", dformat.parse("06/20/2005"), dformat.parse("11/29/2009"),
            "Software engineer", "in It deaprtment")

        var workList1 = ArrayList<Work>()
        workList1.add(w11)

        var pr11 = Project(41, "Internet banking", dformat.parse("06/20/2005"), dformat.parse("11/29/2009"),
            "php, javascript, html", "")

        var prList1 = ArrayList<Project>()
        prList1.add(pr11)

        var p1 = Person(1, "Purevdemberel", "Byambatogtokh", "", "Software Developer",
            dformat.parse("09/03/1989"),R.drawable.puje,
            "999-999-9999",
            "purevdemberel@gmail.com",
            "bpurevdemberel",
            "@bpurevdemberel",
            "I have 5 years experiences on the Java, J2EE and other software. In this term, developed and used applications are: Java, JSP, HTML5, CSS3, jQuery, JavaScript, JSON, MySQL Servlet, Hibernate. Object Oriented (OOPS) programming skill is usually used for development of Java and applications. Further, I will work on theproject development of software by a result from more study on configuration, integration and implementation. ",
            "•Developed new authorization mode for social and smart banking using biometric security. Created streamlined online customer registration system, measurably increasing customer sign-ups\n",
            addList1,
            eduList1,
            workList1,
            prList1
            )
        personList.add(p1)


        //Tuugii
        var a2 = Address(12, "FairField", "IOWA", "", 52556, "Trlr-4A", "")

        var addList2 = ArrayList<Address>()
        addList2.add(a2)

        var e2 = Education(22, dformat.parse("09/01/2000"), dformat.parse("06/01/2004"),
            "National Univercity of Mongolia", 3.4, "Bachelor", "")
        var eduList2 = ArrayList<Education>()
        eduList2.add(e2)

        var w1 = Work(31, "Zoosbank", dformat.parse("06/20/2005"), dformat.parse("11/29/2009"),
            "Software engineer", "in It deaprtment")
        var w2 = Work(32, "Statebank", dformat.parse("11/29/2009"), dformat.parse("06/20/2011"),
            "Senior developer", "in It deaprtment")
        var w3 = Work(32, "Infosoft", dformat.parse("06/20/2011"), dformat.parse("11/28/2018"),
            "Senior developer", "in It deaprtment")

        var workList2 = ArrayList<Work>()
        workList2.add(w1)
        workList2.add(w2)
        workList2.add(w3)

        var pr1 = Project(41, "Internet banking", dformat.parse("06/20/2005"), dformat.parse("11/29/2009"),
            "php, javascript, html", "")

        var prList2 = ArrayList<Project>()
        prList2.add(pr1)
        var p2 = Person(2, "Battuguldur", "Ganbold", "Tuugii", "Software Developer",
            dformat.parse("12/20/1983"), R.drawable.tuugii,
            "650-745-6863",
            "tuugii83@gmail.com",
            "gtuugii",
            "gtuugii",
            "I have 10 years experiences on the Java, J2EE and other software. In this term, developed and used applications are: Java, JSP, HTML5, CSS3, jQuery, JavaScript, JSON, MySQL Servlet, Hibernate. Object Oriented (OOPS) programming skill is usually used for development of Java and applications. Further, I will work on theproject development of software by a result from more study on configuration, integration and implementation. ",
            "•Developed new authorization mode for social and smart banking using biometric security. Created streamlined online customer registration system, measurably increasing customer sign-ups\n",
            addList2,
            eduList2,
            workList2,
            prList2)

        personList.add(p2)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
