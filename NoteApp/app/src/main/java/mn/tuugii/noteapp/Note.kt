package mn.tuugii.noteapp

import java.io.Serializable

data class Note(var noteId: Int?, var title: String?, var desc: String?): Serializable
