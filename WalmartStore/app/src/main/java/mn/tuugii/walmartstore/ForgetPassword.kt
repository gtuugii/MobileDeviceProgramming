package mn.tuugii.walmartstore

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast

class ForgetPassword : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_password)
    }

    fun onClickRecoveryPassword(view: View) {
        var email = editEmail.text.toString()

        val data = Intent()
        data.putExtra("email", email)

        //data.data = Uri.parse(text)
        setResult(Activity.RESULT_OK, data)
        //---close the activity---
        finish()
    }
}
