package mn.tuugii.curriculumvitae.classes

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.*

data class Person(
    @SerializedName("id")
    var id: Int,
    @SerializedName("fName")
    var fName: String?,
    @SerializedName("lName")
    var lName: String?,
    @SerializedName("mName")
    var mName: String?,
    @SerializedName("position")
    var position: String?,
    @SerializedName("bDate")
    var bDate: Date?,
    @SerializedName("image")
    var image: Int,
    @SerializedName("phone")
    var phone: String?,
    @SerializedName("email")
    var email: String?,
    @SerializedName("facebook")
    var facebook: String?,
    @SerializedName("twitter")
    var twitter: String?,
    @SerializedName("aboutMe")
    var aboutMe: String?,
    @SerializedName("achievements")
    var achievements: String?,
    @SerializedName("blog")
    var blog: String?,

    var eduBackground: String?,
    var personalInfo: String?,
    var strengths: String?,
    var weakness: String?,

    var workBackground: String?,
    var workExperience: String?,
    var projectInfo: String?,
//test



    @SerializedName("addresses")
    var addresses: ArrayList<Address>?,
    @SerializedName("educations")
    var educations: ArrayList<Education>?,
    @SerializedName("works")
    var works: ArrayList<Work>?,
    @SerializedName("projects")
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

