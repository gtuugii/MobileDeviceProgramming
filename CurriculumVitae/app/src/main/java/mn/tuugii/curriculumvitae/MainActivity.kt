package mn.tuugii.curriculumvitae

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.fragment_home.*
import mn.tuugii.curriculumvitae.classes.Person
import sun.jvm.hotspot.utilities.IntArray
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {

    lateinit var fmanager : FragmentManager
    lateinit var txn: FragmentTransaction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fmanager = supportFragmentManager
        txn = fmanager.beginTransaction()
        txn.add(R.id.frMain, HomeFragment())
        txn.commit()

        init()

        // homeIntent
        if(intent.hasExtra("personList")){
            var person =intent.getSerializableExtra("person") as Person

            //imgPuje.setImageResource(person.image)


        }
    }

    fun init(){
        val dateformat: SimpleDateFormat = SimpleDateFormat("MM/dd/yyyy", Locale.US)

        var date ="05/05/2017"
        //SimpleDateFormat output = new SimpleDateFormat("MMMM dd,yyyy @hh:mm:ss aa");
        var oneWayTripDate = dateformat.parse(date);  // parse input

        //listItems.add(dateformat.format(Date()))
        var p1: Person(1, "Battuguldur", "Ganbold", "", dateformat.parse(date),
                        "650-745-6863", "tuugii83@gmail.com", "gtuugii", "gtuugii", "Tuugii - ")

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
