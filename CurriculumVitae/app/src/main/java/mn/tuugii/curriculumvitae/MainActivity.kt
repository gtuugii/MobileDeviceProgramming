package mn.tuugii.curriculumvitae

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import mn.tuugii.curriculumvitae.classes.*
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {

    lateinit var fmanager : FragmentManager
    lateinit var txn: FragmentTransaction
    val dformat: SimpleDateFormat = SimpleDateFormat("MM/dd/yyyy", Locale.US)
    var personList = ArrayList<Person>()
    var addList = ArrayList<Address>()
    var eduList = ArrayList<Education>()
    var workList = ArrayList<Work>()
    var projList = ArrayList<Project>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fmanager = supportFragmentManager
        txn = fmanager.beginTransaction()
        txn.add(R.id.frMain, HomeFragment())
        txn.commit()

        init()
    }

    fun init(){

        var p1 = Person(1, "Purevdemberel", " ", "", dformat.parse("12/20/1983"),
            "999-999-9999", "puujee@gmail.com", "puujee", "puujee", "Puujee - ")

        var p2 = Person(2, "Battuguldur", "Ganbold", "Tuugii", dformat.parse("12/20/1983"),
            "650-745-6863", "tuugii83@gmail.com", "gtuugii", "gtuugii", "Tuugii - ")

        personList.add(p1)
        personList.add(p2)

        var a1 = Address(11, p1, "FairField", "IOWA", "", 52556, "Trlr-4A", "")
        var a2 = Address(12, p2, "FairField", "IOWA", "", 52556, "Trlr-4A", "")

        addList.add(a1)
        addList.add(a2)

        var e1 = Education(21, p1, dformat.parse("09/01/2000"), dformat.parse("06/01/2004"),
            "National Univercity of Mongolia", 3.4, "Bachelor", "")

        var e2 = Education(22, p1, dformat.parse("09/01/2000"), dformat.parse("06/01/2004"),
            "National Univercity of Mongolia", 3.4, "Bachelor", "")

        eduList.add(e1)
        eduList.add(e2)


        var w1 = Work(31, p2, "Zoosbank", dformat.parse("06/20/2005"), dformat.parse("11/29/2009"),
            "Software engineer", "in It deaprtment")

        var w2 = Work(32, p2, "Statebank", dformat.parse("11/29/2009"), dformat.parse("06/20/2011"),
            "Senior developer", "in It deaprtment")

        var w3 = Work(32, p2, "Infosoft", dformat.parse("06/20/2011"), dformat.parse("11/28/2018"),
            "Senior developer", "in It deaprtment")

        workList.add(w1)
        workList.add(w2)
        workList.add(w3)

        var pr1 = Project(41, p2, "Internet banking", dformat.parse("06/20/2005"), dformat.parse("11/29/2009"),
                    "php, javascript, html", "")

        projList.add(pr1)
    }

    fun onBtnHome(view: View){
        txn = fmanager.beginTransaction()
        txn.replace(R.id.frMain, HomeFragment())
        txn.commit()
    }
    fun onBtnAbout(view: View){
        txn = fmanager.beginTransaction()
        txn.replace(R.id.frMain, AboutFragment())
        txn.commit()
    }

    fun onBtnWork(view: View){
        txn = fmanager.beginTransaction()
        txn.replace(R.id.frMain, WorkFragment())
        txn.commit()
    }

    fun onBtnContact(view: View){
        txn = fmanager.beginTransaction()
        txn.replace(R.id.frMain, ContactFragment())
        txn.commit()
    }

}
