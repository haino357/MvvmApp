package com.example.android.mvvmapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.android.mvvmapp.R

class MainFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        val buttonMoveToList = view.findViewById<Button>(R.id.button_move_to_list)
        buttonMoveToList.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_listFragment)
        }

        return view
    }
}