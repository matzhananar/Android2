package com.example.lab6retrofit

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.listoftasks.*

class ListOfTasks: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.listoftasks, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Log.e("ThirdFragmentArgs", arguments?.getString("amount"))
        tonewtask.setOnClickListener {
            val action = ListOfTasksDirections.actionListOfTasksToNewTask()
            it.findNavController().navigate(action)
        }


    }
}