package mn.tuugii.walmartstore

import java.io.Serializable

data class User(var firstName: String?, var lastName: String?, var email: String?, var password: String?) :
    Serializable {
    override fun toString(): String {
        return "User(firstName=$firstName, lastName=$lastName, emailId=$email)"
    }
}
