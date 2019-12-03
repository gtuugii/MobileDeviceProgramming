package mn.tuugii.walmartstore
import java.io.Serializable
data class Product(var itemid: Int?, var catid: Category?, var title: String?,
                   var price: Double?, var color: String?, var image: String?,
                   var desc: String?):
    Serializable {
        override fun toString(): String {
            return "Product(itemid=$itemid, title=$title, price=$price)"
        }

    fun getProductList(){

    }
}