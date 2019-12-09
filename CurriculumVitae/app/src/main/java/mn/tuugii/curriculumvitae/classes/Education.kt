package mn.tuugii.curriculumvitae.classes

import java.io.Serializable
import java.time.LocalDate
import java.util.*

data class Education(var eduId: Int?,
                     var startDate: Date?,
                     var endDate: Date?,
                     var where: String?,
                     var gpa: Double?,
                     var degree: String?,
                     var note: String?):
    Serializable {}