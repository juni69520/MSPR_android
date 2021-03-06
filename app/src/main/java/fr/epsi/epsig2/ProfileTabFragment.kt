package fr.epsi.epsig2

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileTabFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileTabFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile_tab, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val editTextNom = view.findViewById<EditText>(R.id.editTextNom)
        val editTextPrenom = view.findViewById<EditText>(R.id.editTextPrenom)
        val editTextAffectation = view.findViewById<EditText>(R.id.editTextAffectation)


        //val editTextMat1 = view.findViewById<EditText>(R.id.editTextMat1)
        //val editTextMat2 = view.findViewById<EditText>(R.id.editTextMat2)

        //val login = sharedPreferences.getString("login","Not found")
        // val password = sharedPreferences.getString("password","Not found")

        editTextNom.setText(readSharedPreferences("nom"))
        editTextPrenom.setText(readSharedPreferences("prenom"))
        editTextAffectation.setText(readSharedPreferences("affectation"))
    }

    fun writeSharedPreferences(key : String , value : String){
        activity?.let{
            val sharedPreferences= it.getSharedPreferences("epsi", Context.MODE_PRIVATE)
            val edit=sharedPreferences.edit()
            edit.putString(key,value)
            edit.apply()
        }
    }

    fun readSharedPreferences(key : String) : String{
        activity?.let {
            val sharedPreferences = it.getSharedPreferences("epsi", Context.MODE_PRIVATE)
            val txt = sharedPreferences.getString(key, "Not found")
            return txt.toString()
        }
        return "Not found"
    }
}