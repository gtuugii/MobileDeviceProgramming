package mn.tuugii.noteapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add_note.*
import java.lang.Exception

class AddNoteActivity : AppCompatActivity() {
    var db: DBHelper? = null
    var id = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        db = DBHelper(this)

        var bundle: Bundle? = intent.extras

        var note = bundle?.getSerializable("note") as Note

        if(!bundle.isEmpty()) {
            id = note.noteId as Int
            etTitle.setText(note.title)
            etDesc.setText(note.desc)
        }

        btnSave.setOnClickListener {

            var title = etTitle.text.toString()
            var desc = etDesc.text.toString()

            if (id == 0) {
                if (db?.insertData(title, desc) != -1L) {
                    MyLibrary.toast(this, "inserted.")
                } else {
                    MyLibrary.toast(this, "cannot insert data.")
                }
            }else{
                if(db?.updateData(id, title, desc) != 0){
                    MyLibrary.toast(this, "updated.")
                }else {
                    MyLibrary.toast(this, "cannot updated data.")
                }
            }

            finish()

        }


    }


}
