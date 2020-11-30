package com.example.lab6retrofit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.detailoftask.*
import kotlinx.android.synthetic.main.listoftasks.*

class DetailOfTask: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.detailoftask, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Log.e("ThirdFragmentArgs", arguments?.getString("amount"))
        backtolist.setOnClickListener {
            it.findNavController().navigate(R.id.action_detailOfTask_to_listOfTasks)
        }
    }
}