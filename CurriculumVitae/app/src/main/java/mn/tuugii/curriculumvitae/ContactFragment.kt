package mn.tuugii.curriculumvitae

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_contact.*
import mn.tuugii.curriculumvitae.classes.Person

/**
 * A simple [Fragment] subclass.
 */
class ContactFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val p = arguments!!.getSerializable("person") as Person
        tvAddress.text = p?.addresses.toString()
        tvPhone.text = p?.phone.toString()
        tvEmail.text = p?.email.toString()
        tvFacebook.text = p?.facebook.toString()
        tvTwitter.text = p?.twitter.toString()
    }


}
