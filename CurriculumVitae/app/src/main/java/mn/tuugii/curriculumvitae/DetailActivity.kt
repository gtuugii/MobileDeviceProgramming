package mn.tuugii.curriculumvitae

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import mn.tuugii.curriculumvitae.classes.*
import java.text.SimpleDateFormat
import java.util.*


class DetailActivity : AppCompatActivity() {

    lateinit var fmanager : FragmentManager
    lateinit var txn: FragmentTransaction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_main)

        fmanager = supportFragmentManager
        txn = fmanager.beginTransaction()
        txn.add(R.id.frMain, HomeFragment())
        txn.commit()
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
