package mn.tuugii.curriculumvitae.classes

import com.google.gson.annotations.SerializedName
class Persons {
    @SerializedName("persons")
    lateinit var personList: ArrayList<Person>
}