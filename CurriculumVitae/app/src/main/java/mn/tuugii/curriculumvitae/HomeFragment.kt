package mn.tuugii.curriculumvitae

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_home.*
import mn.tuugii.curriculumvitae.classes.Person
import java.text.SimpleDateFormat


class HomeFragment : Fragment() {
    val formatter = SimpleDateFormat("MM/dd/yyyy")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? { // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val p = arguments!!.getSerializable("person") as Person
        imgPerson.setImageResource(p.image)
        tvFirstName.text = "FirstName: " + p!!.fName.toString()
        tvLastName.text = "LastName: " + p?.lName.toString()
        tvAge.text = "BirthDay: " + formatter.format(p?.bDate)
        tvPosition.text = "Position: " + p?.position.toString()
        tvAboutme.text = p?.aboutMe.toString()
        tvAchieve.text = p?.achievements.toString()
        tvBlog.text = p?.blog.toString()
    }
}