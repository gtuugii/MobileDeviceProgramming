package mn.tuugii.curriculumvitae.classes

import java.time.LocalDate

data class Person(var id: Int,
                  var fName: String,
                  var lName: String,
                  var mName: String,
                  var bDate: LocalDate,
                  var phone: String,
                  var email: String,
                  var facebook: String,
                  var twitter: String,
                  var note: String)

