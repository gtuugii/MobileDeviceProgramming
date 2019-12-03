package mn.tuugii.walmartstore

import java.io.Serializable

data class Category(var catid: Int?, var name: String?, var picture: Int?) :
    Serializable {
    override fun toString(): String {
        return "Category(catid=$catid, name=$name, picture=$picture)"
    }
}

