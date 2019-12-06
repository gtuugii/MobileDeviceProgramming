package mn.tuugii.curriculumvitae

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

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
        txn.replace(R.id.frMain, HomeFragment())
        txn.commit()
    }

    fun onBtnContact(view: View){
        txn = fmanager.beginTransaction()
        txn.replace(R.id.frMain, HomeFragment())
        txn.commit()
    }

}
