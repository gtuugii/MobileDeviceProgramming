package mn.tuugii.noteapp

import android.content.Context
import android.widget.Toast

class MyLibrary {

    companion object{
        fun toast(content: Context, text: String){
            Toast.makeText(content, text, Toast.LENGTH_LONG).show()
        }
    }
}