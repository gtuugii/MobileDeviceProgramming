package mn.tuugii.curriculumvitae.classes

import java.time.LocalDate
import java.util.*

data class Work(var workId: Int,
                var person: Person,
                var companyName: String,
                var startDate: Date,
                var endDate: Date,
                var position: String,
                var desc: String)