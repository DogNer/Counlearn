package com.example.counlearn.Menu

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.cardview.widget.CardView
import androidx.navigation.fragment.findNavController
import com.example.counlearn.Continents.WholeWorldActivity
import com.example.counlearn.MainActivity
import com.example.counlearn.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.util.*
import kotlin.collections.HashMap

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var cardWholeWorld: CardView
    private lateinit var cardEurope: CardView
    private lateinit var cardAsia: CardView
    private lateinit var cardAfrica: CardView
    private lateinit var cardAustralia: CardView
    private lateinit var cardNAmerica: CardView
    private lateinit var cardSAmerica: CardView

    private lateinit var mAuth: FirebaseAuth
    private lateinit var mDbRef: DatabaseReference

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
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        cardWholeWorld = view.findViewById(R.id.card_whole_world)
        cardWholeWorld.setOnClickListener{
            setEmotion("Whole World")
            val intent = Intent(getActivity(), WholeWorldActivity::class.java)
            startActivity(intent)
        }

        cardEurope = view.findViewById(R.id.cardEurope)
        cardEurope.setOnClickListener{
            setEmotion("Europe")
            val intent = Intent(getActivity(), WholeWorldActivity::class.java)
            startActivity(intent)
        }

        cardAsia = view.findViewById(R.id.cardAsia)
        cardAsia.setOnClickListener{
            setEmotion("Asia")
            val intent = Intent(getActivity(), WholeWorldActivity::class.java)
            startActivity(intent)
        }

        cardAfrica = view.findViewById(R.id.cardAfrica)
        cardAfrica.setOnClickListener{
            setEmotion("Africa")
            val intent = Intent(getActivity(), WholeWorldActivity::class.java)
            startActivity(intent)
        }

        cardAustralia = view.findViewById(R.id.cardAustralia)
        cardAustralia.setOnClickListener{
            setEmotion("Australia")
            val intent = Intent(getActivity(), WholeWorldActivity::class.java)
            startActivity(intent)
        }

        cardNAmerica = view.findViewById(R.id.cardNorthAmerica)
        cardNAmerica.setOnClickListener{
            setEmotion("North America")
            val intent = Intent(getActivity(), WholeWorldActivity::class.java)
            startActivity(intent)
        }

        cardSAmerica = view.findViewById(R.id.cardSouthAmerica)
        cardSAmerica.setOnClickListener{
            setEmotion("South America")
            val intent = Intent(getActivity(), WholeWorldActivity::class.java)
            startActivity(intent)
        }



        return view
    }

    fun setEmotion(text: String){
        val user = FirebaseAuth.getInstance().currentUser
        if (user != null) {
            mDbRef = FirebaseDatabase.getInstance().getReference("Users").child(user.uid)
            mDbRef.child("continent").setValue(text)
        }
    }

    companion object {
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}