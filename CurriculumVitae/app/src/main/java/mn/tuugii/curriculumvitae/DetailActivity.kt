package mn.tuugii.curriculumvitae

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import mn.tuugii.curriculumvitae.classes.Person

class DetailActivity : AppCompatActivity() {

    lateinit var fmanager : FragmentManager
    lateinit var txn: FragmentTransaction
    var p: Person? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_main)

        val intt = intent

        if(intt.hasExtra("person")){
            p = intt.getSerializableExtra("person") as Person
            Toast.makeText(this, "this is : " + p?.fName.toString(), Toast.LENGTH_SHORT).show()
        }

        fmanager = supportFragmentManager
        txn = fmanager.beginTransaction()
        val bundle = Bundle()
        bundle.putSerializable("person", p)
        val fragobj = HomeFragment()
        fragobj.arguments = bundle

        txn.add(R.id.frMain, fragobj)
        txn.commit()

    }

    fun onBtnHome(view: View){
        txn = fmanager.beginTransaction()

        val bundle = Bundle()
        bundle.putSerializable("person", p)
        val fragobj = HomeFragment()
        fragobj.arguments = bundle

        txn.replace(R.id.frMain, fragobj)
        txn.commit()
    }
    fun onBtnAbout(view: View){
        txn = fmanager.beginTransaction()
        val bundle = Bundle()
        bundle.putSerializable("person", p)
        val fragobj = AboutFragment()
        fragobj.arguments = bundle

        txn.replace(R.id.frMain, fragobj)
        txn.commit()
    }

    fun onBtnWork(view: View){
        txn = fmanager.beginTransaction()
        val bundle = Bundle()
        bundle.putSerializable("person", p)
        val fragobj = WorkFragment()
        fragobj.arguments = bundle

        txn.replace(R.id.frMain, fragobj)
        txn.commit()
    }

    fun onBtnContact(view: View){
        txn = fmanager.beginTransaction()
        val bundle = Bundle()
        bundle.putSerializable("person", p)
        val fragobj = ContactFragment()
        fragobj.arguments = bundle

        txn.replace(R.id.frMain, fragobj)
        txn.commit()
    }

}
