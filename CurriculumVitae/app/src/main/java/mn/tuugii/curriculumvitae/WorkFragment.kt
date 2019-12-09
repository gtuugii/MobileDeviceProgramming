package mn.tuugii.curriculumvitae



import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_work.*
import mn.tuugii.curriculumvitae.classes.Person

/**
 * A simple [Fragment] subclass.
 */
class WorkFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_work, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val p = arguments!!.getSerializable("person") as Person
        tvWorkBackground.text = p?.workBackground.toString()
        tvExperience.text = p?.workExperience.toString()
        tvProjectInfo.text = p?.projectInfo.toString()
    }

}
