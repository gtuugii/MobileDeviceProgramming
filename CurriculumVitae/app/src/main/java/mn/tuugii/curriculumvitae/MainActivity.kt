package mn.tuugii.curriculumvitae

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnEnter(view: View){
        var intt = Intent(this, CardActivity::class.java)
        //intt.putExtra()
        startActivity(intt)
    }
}
