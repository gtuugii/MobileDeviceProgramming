package mn.tuugii.curriculumvitae.classes

import java.io.Serializable
import java.time.LocalDate
import java.util.*

data class Project(var pId: Int?,
                   var projectName: String?,
                   var startDate: Date?,
                   var endDate: Date?,
                   var used: String?,
                   var desc: String?):
    Serializable {}
