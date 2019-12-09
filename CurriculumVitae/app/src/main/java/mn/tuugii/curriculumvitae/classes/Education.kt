package mn.tuugii.curriculumvitae.classes

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.*

data class Education(
    @SerializedName("eduId")
    var eduId: Int?,
    @SerializedName("startDate")
    var startDate: Date?,
    @SerializedName("endDate")
    var endDate: Date?,
    @SerializedName("where")
    var where: String?,
    @SerializedName("gpa")
    var gpa: Double?,
    @SerializedName("degree")
    var degree: String?,
    @SerializedName("note")
    var note: String?
) :
    Serializable {}