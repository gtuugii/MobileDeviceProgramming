package mn.tuugii.curriculumvitae.classes

import java.io.Serializable

data class Address(var addId: Int?,
                   var city: String?,
                   var state: String?,
                   var country: String?,
                   var zipCode: Int?,
                   var address1: String?,
                   var address2: String?):
    Serializable {}