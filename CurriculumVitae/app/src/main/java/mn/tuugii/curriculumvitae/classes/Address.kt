package mn.tuugii.curriculumvitae.classes

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Address(
    @SerializedName("addId")
    var addId: Int?,
    @SerializedName("city")
    var city: String?,
    @SerializedName("state")
    var state: String?,
    @SerializedName("country")
    var country: String?,
    @SerializedName("zipCode")
    var zipCode: Int?,
    @SerializedName("address1")
    var address1: String?,
    @SerializedName("address2")
    var address2: String?
):
    Serializable {}