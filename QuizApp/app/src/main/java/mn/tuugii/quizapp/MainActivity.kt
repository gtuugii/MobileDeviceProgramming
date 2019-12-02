package mn.tuugii.quizapp

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {

    var quizs = ArrayList<Quiz>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

    }

    fun init(){

        var quiz1 : Quiz = Quiz(1, "Which is the top layer in the Android Architecture?", 0, 1, 50)
        var qitem11: QuizItem = QuizItem(1, "Linux Kernel", false, quiz1)
        var qitem12: QuizItem = QuizItem(2, "Libraries", false, quiz1)
        var qitem13: QuizItem = QuizItem(3, "Applications", true, quiz1)

        quizs.add(quiz1)

        var quiz2 : Quiz = Quiz(2, "Each activity you create must have an entry in AndroidManifest.xml.", 0, 2, 50)
        var qitem21: QuizItem = QuizItem(1, "true", true, quiz2)
        var qitem22: QuizItem = QuizItem(2, "false", false, quiz2)
        var qitem23: QuizItem = QuizItem(3, "I don't know", false, quiz2)

        quizs.add(quiz2)


//        for(qs in quizs){
//            //
//        }
    }

    fun onClickBtnReset(view: View) {
        rGroup.clearCheck()
        yes.setChecked(false);
        no.setChecked(false);
        none.setChecked(false);
    }
    fun onClickBtnSubmit(view: View) {
        var score = 0
        if(a13.isChecked)
            score += 50

        if(yes.isChecked) {
            score += 50

            if(no.isChecked || none.isChecked)
                score -= 50
        }

        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")
        val formatted = current.format(formatter)

        if(score >= 50) {
            Toast.makeText(
                this,
                "Congratulations! You submitted on current date and time, Your achieved 50%",
                Toast.LENGTH_LONG
            ).show()

            val builder = AlertDialog.Builder(this@MainActivity)
            // 2. Set the basic information for the builder object
            builder.setTitle("Congratulations!")
            builder.setMessage("You submitted on $formatted, Your achieved 50%")
            builder.setIcon(R.drawable.alerticon)

            builder.setPositiveButton("Exit"){dialogInterface, which ->
                Toast.makeText(applicationContext,"Exit, it is the positive action id : $which",Toast.LENGTH_SHORT).show()
                dialogInterface.dismiss() // dismiss the dialog
                finish() // to destroy the activity
            }
            // 4. Performing Cancel action on clicking Cancel button
            builder.setNegativeButton("Cancel"){dialogInterface, which ->
                Toast.makeText(applicationContext,"Cancel, it is the negative action id : $which",Toast.LENGTH_SHORT).show()
                dialogInterface.dismiss() // dismiss the dialog, but activity is still alive
            }

            // 5. Finally, make the alert dialog using builder
            val dialog: AlertDialog = builder.create()
            // 6. Display the alert dialog on app interface
            dialog.show()
        }
        else
            Toast.makeText(
                this,
                "Do you want to check the answer again!, Your score is 0",
                Toast.LENGTH_LONG
            ).show()
    }
}
