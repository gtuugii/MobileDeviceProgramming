package mn.tuugii.noteapp

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.SearchView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.ticket.view.*

class MainActivity : AppCompatActivity() {

    var noteList = ArrayList<Note>()
    var db = DBHelper(this)
    var myNotesAdapter : MyNotesAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //noteList.add(Note(1, "qqqsddd", "ashd hakdlj akljs aklsjf kasjfl asdfdff  fff"))
        //noteList.add(Note(2, "this is title2", "ashd hakdlj akljs aklsjf kasjfl asdfsf "))

        myNotesAdapter = MyNotesAdapter(this, noteList)
        lvNotes.adapter = myNotesAdapter
        loadList()
    }

    override fun onResume() {
        super.onResume()
        loadList()
    }

    fun loadList(){
        val cursor = db.allData
        noteList.clear()
        if(cursor.moveToFirst()){
            do{
                val gId = cursor.getInt(cursor.getColumnIndex("noteid"))
                val gTitle = cursor.getString(cursor.getColumnIndex("title"))
                val gDesc = cursor.getString(cursor.getColumnIndex("desc"))

                noteList.add(Note(gId, gTitle, gDesc))
            }while(cursor.moveToNext())
        }

        myNotesAdapter?.notifyDataSetChanged()
    }

    fun loadQuery(title: String){
        val projections = arrayOf("noteid", "title", "desc")
        val selectionArgs = arrayOf(title)
        val cursor = db.select(projections, "title like ?", selectionArgs, "title")
        noteList.clear()
        if(cursor.moveToFirst()){
            do{
                val gId = cursor.getInt(cursor.getColumnIndex("noteid"))
                val gTitle = cursor.getString(cursor.getColumnIndex("title"))
                val gDesc = cursor.getString(cursor.getColumnIndex("desc"))

                noteList.add(Note(gId, gTitle, gDesc))
            }while(cursor.moveToNext())
        }

        //var myNoteAdapter = MyNotesAdapter(noteList)
        //lvNotes.adapter = myNoteAdapter
        myNotesAdapter?.notifyDataSetChanged()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)

        val sv: SearchView = menu.findItem(R.id.app_bar_search).actionView as SearchView
        val sm = getSystemService(Context.SEARCH_SERVICE) as SearchManager

        sv.setSearchableInfo(sm.getSearchableInfo(componentName))
        sv.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                Toast.makeText(applicationContext, query, Toast.LENGTH_LONG).show()
                loadQuery("%$query%")
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item != null){
            when (item.itemId){
                R.id.addNote -> {
                    var intt = Intent(this, AddNoteActivity::class.java)
                    startActivity(intt)
                }
            }
        }

        return super.onOptionsItemSelected(item)
    }

    inner class MyNotesAdapter: BaseAdapter{
        var noteListAdapter = ArrayList<Note>()
        var context: Context? = null
        constructor(context: Context, noteList: ArrayList<Note>) : super(){
            this.noteListAdapter = noteList
            this.context = context
        }

        override fun getView(p: Int, convertView: View?, parent: ViewGroup?): View {
            var myView = layoutInflater.inflate(R.layout.ticket, null)
            var myNote = noteListAdapter[p]
            myView.tvTitle.text = myNote.title
            myView.tvContent.text = myNote.desc

            myView.ivDelete.setOnClickListener(View.OnClickListener {
                if(db.deleteData(myNote.noteId as Int) != 0) {
                    loadList()
                    MyLibrary.toast(this.context!!, "It is deleted. id:" + myNote.noteId)
                }
                else
                    MyLibrary.toast(this.context!!, "This note is not deleted. id:" + myNote.noteId)

            })

            myView.ivUpdate.setOnClickListener(View.OnClickListener {
                goUpdate(myNote)
            })

            return myView
        }

        override fun getItem(p: Int): Any {
            return this.noteListAdapter[p]
        }

        override fun getItemId(p: Int): Long {
            return p.toLong()
        }

        override fun getCount(): Int {
            return noteList.size
        }
    }

    fun goUpdate(note: Note){
        var intt = Intent(this, AddNoteActivity::class.java)
        intt.putExtra("note", note)
        startActivity(intt)
    }
}
