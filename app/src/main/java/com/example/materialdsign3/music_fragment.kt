package com.example.materialdsign3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.materialdsign3.databinding.FragmentMusicBinding

class music_fragment: Fragment() {
    private lateinit var binding: FragmentMusicBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMusicBinding.inflate(inflater,container , false)
        return binding.root


    }
}