package mn.tuugii.curriculumvitae


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_about.*
import mn.tuugii.curriculumvitae.classes.Person

class AboutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val p = arguments!!.getSerializable("person") as Person
        tvAboutme.text = p?.aboutMe.toString()
        tvEBackground.text = p?.eduBackground.toString()
        tvPersonalInfo.text = p?.personalInfo.toString()
        tvStrengths.text = p?.strengths.toString()
        tvWeakness.text = p?.weakness.toString()

    }
}
