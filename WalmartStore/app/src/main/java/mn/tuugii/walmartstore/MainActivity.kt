package mn.tuugii.walmartstore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var userList = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initApp()
        printUsers(1)
    }

    fun initApp(){
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
}