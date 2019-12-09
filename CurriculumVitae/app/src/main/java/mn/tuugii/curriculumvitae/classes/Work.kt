package mn.tuugii.curriculumvitae.classes

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.*

data class Work(
    @SerializedName("workId")
    var workId: Int?,
    @SerializedName("companyName")
    var companyName: String?,
    @SerializedName("startDate")
    var startDate: Date?,
    @SerializedName("endDate")
    var endDate: Date?,
    @SerializedName("position")
    var position: String?,
    @SerializedName("desc")
    var desc: String?
) :
    Serializable {}