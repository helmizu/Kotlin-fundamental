package com.example.android.navigation


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
//import androidx.navigation.findNavController
import com.example.android.navigation.databinding.FragmentTitleBinding

/**
 * A simple [Fragment] subclass.
 */
class TitleFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding: FragmentTitleBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_title, container, false)
        // first way
//        binding.playButton.setOnClickListener {
//            it.findNavController().navigate(R.id.action_titleFragment_to_gameFragment)
//        }

        // second way
//        binding.playButton.setOnClickListener {
//            Navigation.findNavController(it).navigate(R.id.action_titleFragment_to_gameFragment)
//        }

        // third way
        binding.playButton.setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.action_titleFragment_to_gameFragment)
        )

        return binding.root
    }


}
