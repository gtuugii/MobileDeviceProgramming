package mn.tuugii.curriculumvitae.classes

import java.time.LocalDate
import java.util.*

data class Education(var eduId: Int,
                     var person: Person,
                     var startDate: Date,
                     var endDate: Date,
                     var where: String,
                     var gpa: Double,
                     var degree: String,
                     var note: String)