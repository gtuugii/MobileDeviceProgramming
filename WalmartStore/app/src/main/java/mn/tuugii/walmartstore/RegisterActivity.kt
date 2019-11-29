package mn.tuugii.walmartstore

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    var msg : String? = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val intt = intent
        msg = intt.getStringExtra("msg")
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

    fun onClickSaveAccount(view: View){
        var fname: String = editFname.text.toString()
        var lname: String = editLname.text.toString()
        var email: String = editEmail.text.toString()
        var pass : String = editPassword.text.toString()

        var user = User(fname, lname, email, pass)

        val data = Intent()
        //val text = input?.text.toString()
        //---set the data to pass back
        data.putExtra("user", user)

        //data.data = Uri.parse(text)
        setResult(Activity.RESULT_OK, data)
        //---close the activity---
        finish()
    }
}
