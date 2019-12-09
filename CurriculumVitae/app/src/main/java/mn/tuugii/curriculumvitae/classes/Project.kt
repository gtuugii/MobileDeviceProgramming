package mn.tuugii.curriculumvitae.classes

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.*

data class Project(
    @SerializedName("pId")
    var pId: Int?,
    @SerializedName("projectName")
    var projectName: String?,
    @SerializedName("startDate")
    var startDate: Date?,
    @SerializedName("endDate")
    var endDate: Date?,
    @SerializedName("used")
    var used: String?,
    @SerializedName("desc")
    var desc: String?
) :
    Serializable {}
