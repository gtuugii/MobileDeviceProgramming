package mn.tuugii.noteapp

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteQueryBuilder
import android.widget.Toast

class DBHelper (context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, 1){

    //Note(var noteId: Int?, var title: String?, var desc: String?)
    companion object{
        val DATABASE_NAME = "note.db"
        val TABLE_NAME = "notes"
        val NOTEID = "NOTEID"
        val TITLE = "TITLE"
        val DESC = "DESC"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table $TABLE_NAME(noteid integer primary key " +
            " autoincrement, title, desc)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        if(oldVersion < newVersion){
            db?.execSQL("drop table if exists " + TABLE_NAME)
            onCreate(db)
        }
    }

    fun select(projection:Array<String>, selection:String, selectionArgs:Array<String>, sorOrder:String):Cursor{
        val db = this.readableDatabase
        val qb = SQLiteQueryBuilder()
        qb.tables = TABLE_NAME
        val cursor = qb.query(db, projection, selection, selectionArgs,null,null, sorOrder)
        return cursor
    }

    fun insertData(title: String, desc: String): Long{
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(TITLE, title)
        contentValues.put(DESC, desc)
        return db.insert(TABLE_NAME, null, contentValues)
    }

    fun insertData(values: ContentValues): Long{
        val db = this.writableDatabase
        return db.insert(TABLE_NAME, null, values)
    }

    fun updateData(id: Int, title: String, desc: String) : Int{
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(NOTEID, id)
        contentValues.put(TITLE, title)
        contentValues.put(DESC, desc)
        var count = db.update(TABLE_NAME, contentValues, "noteid=?", arrayOf(id.toString()))
        return count
    }

    fun readData(id: Int) : Cursor{
        val sql = "select * from $TABLE_NAME where noteid = $id"
        val db = this.readableDatabase
        //val k = db.rawQuery(sql, arrayOf("noteid", "title", "desc"))
        val k = db.rawQuery(sql, null)
        k.moveToNext()
        return k
    }

    fun deleteData(id: Int): Int{
        val db = this.writableDatabase
        return db.delete(TABLE_NAME, "noteid=?", arrayOf(id.toString()))
    }

    fun deleteData(selection: String, selectionArgs: Array<String>): Int{
        val db = this.writableDatabase
        return db.delete(TABLE_NAME, selection, selectionArgs)
    }

    val allData: Cursor
        get(){
            val db = this.writableDatabase
            val res = db.rawQuery("select * from $TABLE_NAME", null )
            return res
        }


}