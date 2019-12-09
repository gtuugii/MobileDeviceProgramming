package mn.tuugii.curriculumvitae.classes

import java.io.Serializable
import java.time.LocalDate
import java.util.*

data class Person(
    var id: Int,
    var fName: String?,
    var lName: String?,
    var mName: String?,
    var position: String?,
    var bDate: Date?,
    var image: Int,
    var phone: String?,
    var email: String?,
    var facebook: String?,
    var twitter: String?,
    var aboutMe: String?,
    var achievements: String?,
    var blog: String?,

    var eduBackground: String?,
    var personalInfo: String?,
    var strengths: String?,
    var weakness: String?,

    var workBackground: String?,
    var workExperience: String?,
    var projectInfo: String?,




    var addresses: ArrayList<Address>?,
    var educations: ArrayList<Education>?,
    var works: ArrayList<Work>?,
    var projects: ArrayList<Project>?
):
    Serializable {
    override fun toString(): String {
        return "Person:( FirstName=$fName, LastName=$lName )"
    }
    fun getFullName():String {
        return this.fName + " " + this.lName;
    }
}

