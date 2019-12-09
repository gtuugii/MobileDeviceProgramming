package mn.tuugii.curriculumvitae

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_card_view.*
import mn.tuugii.curriculumvitae.classes.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class CardActivity : AppCompatActivity() {
    val dformat: SimpleDateFormat = SimpleDateFormat("MM/dd/yyyy", Locale.US)
    var personList = ArrayList<Person>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_view)

        init()

        rv?.layoutManager = LinearLayoutManager(this)
        var adapter = CardViewAdapter(this, personList)
        rv!!.adapter = adapter
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

        var p1 = Person(1, "Purevdemberel", " ", "", "Software Developer",
            dformat.parse("12/20/1983"),R.drawable.puje,
            "999-999-9999", "puujee@gmail.com", "puujee", "puujee",
            "Puujee - ", "achievements...",
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
            "650-745-6863", "tuugii83@gmail.com", "gtuugii", "gtuugii",
            "Tuugii - ", "achievements...",
            addList2,
            eduList2,
            workList2,
            prList2)

        personList.add(p2)

    }

}
