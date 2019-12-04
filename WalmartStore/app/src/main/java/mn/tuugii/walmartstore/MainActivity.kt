package mn.tuugii.walmartstore

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView

import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var userList = ArrayList<User>()
    var t: TextView? = null

    val PICK_NEW_USER_REQUEST = 1
    val PICK_RECOVERY_EMAIL_REQUEST = 2
    val MY_TAG = "Walmart"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initApp()
        printUsers(1)
    }

    fun initApp(){
        userList.add(User("Battuguldur", "Ganbold", "1", "1"))
        userList.add(User("Battuguldur", "Ganbold", "tuugii83@gmail.com", "123"))
        userList.add(User("Tuugii", "Ganbold", "tuugii@gmail.com", "123"))
        userList.add(User("Puujee", "P", "puujee@gmail.com", "123"))
        userList.add(User("Sodoo", "S", "sodoo@gmail.com", "123"))
        userList.add(User("Kanji", "K", "kanji@gmail.com", "123"))
        userList.add(User("Odko", "O", "odko@gmail.com", "123"))

    }

    fun printUsers(id: Int) {
        var fname = userList.get(id).firstName
        var lname = userList.get(id).lastName
        var email = userList.get(id).email
        var pass = userList.get(id).password

        println("$fname, $lname, $email, $pass")
    }

    fun onSignIn(view: View) {
        var username: String?
        var password: String?
        var msg: String? = ""

        username = editEmail.text.toString()
        password = editPassword.text.toString()

        if(checkValidatation(username, password)){

            for(user in userList){
                if(user.email.equals(username) && user.password.equals(password)){
                    //msg = user.toString()
                    msg = user.email
                    break
                }
            }

            if(msg != ""){
                Toast.makeText(this, "You are welcome to Walmart Application", Toast.LENGTH_LONG).show()

                val intt = Intent(this, ShoppingCategory::class.java)
                intt.putExtra("msg", msg)
                startActivity(intt)
            }
        }
    }

    fun checkValidatation(username: String, password: String): Boolean{

        if(username.isEmpty()) {
            Toast.makeText(this, "Enter UserName", Toast.LENGTH_LONG).show()
            return false;
        }

        if(password.isEmpty()) {
            Toast.makeText(this, "Enter Password", Toast.LENGTH_LONG).show()
            return false;
        }

        return true
    }

    fun onClickNewAccount(view: View) {
        //val intent = Intent(this@MainActivity, SecondActivity::class.java)
        //startActivityForResult(intent, 1) // Here 1 is the request code

        val intt = Intent(this, RegisterActivity::class.java)
        //intt.putExtra("msg", "Enter the required fields")
        startActivityForResult(intt, 1)
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent);

        try {
            if (requestCode == PICK_NEW_USER_REQUEST) {
                if (resultCode == Activity.RESULT_OK) {
                    val returnedResult = data!!.getSerializableExtra("user")
                    var user = returnedResult as User
                    userList.add(user)
                    Toast.makeText(this, "Account created successfully", Toast.LENGTH_LONG).show()
                }
                else
                    Toast.makeText(this, "Account is not created", Toast.LENGTH_LONG).show()
            }

            if (requestCode == PICK_RECOVERY_EMAIL_REQUEST) {
                if (resultCode == Activity.RESULT_OK) {
                    val email = data!!.getStringExtra("email").toString()
                    var pass: String? = ""

                    //Log.i(MY_TAG, email);

                    for(user in userList){
                        if(user.email.equals(email)){
                            pass = user.password
                            break
                        }
                    }

                    Toast.makeText(this, "your email: $email and password: $pass", Toast.LENGTH_LONG).show()

                    if(!pass.equals("")) {
                        val intt = Intent(Intent.ACTION_SENDTO)
                        intt.data = Uri.parse("mailto:$email")
                        intt.putExtra(Intent.EXTRA_SUBJECT, "Recovery your password")
                        intt.putExtra(Intent.EXTRA_TEXT, "Your password is $pass")
                        if (intt.resolveActivity(packageManager) != null) {
                            startActivity(intt)
                            Toast.makeText(this, "Sent the password to your email", Toast.LENGTH_LONG).show()
                        }
                    }
                    else
                        Toast.makeText(this, "Not found your email", Toast.LENGTH_LONG).show()
                }
                else
                    Toast.makeText(this, "Don't sent an email", Toast.LENGTH_LONG).show()
            }
        }
        catch (ex: Exception) {
            Log.i(MY_TAG,ex.toString());
            Toast.makeText(this, ex.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    fun onClickForgetPassword(view: View) {
        val intt = Intent(this, ForgetPassword::class.java)
        //intt.putExtra("users", userList)
        startActivityForResult(intt, 2)
        //Toast.makeText(this, "Isdddd", Toast.LENGTH_LONG).show()
    }


}