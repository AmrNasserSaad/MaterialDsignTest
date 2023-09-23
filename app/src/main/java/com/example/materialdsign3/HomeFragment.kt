package com.example.materialdsign3

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.fragment.app.Fragment
import com.example.materialdsign3.databinding.FragmentHomeBinding

class HomeFragment: Fragment() {
   private lateinit var binding : FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View {

        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.floatingActionButton.setOnClickListener { makeText(context, "message", Toast.LENGTH_SHORT).show() }

        binding.dialogButton.setOnClickListener { showDialog() }



        return binding.root
    }
    private fun  showDialog(){

        val builder = AlertDialog.Builder(context)
        builder.apply {
            setTitle("Title")
            setMessage("message")
            setPositiveButton("yes") { _, _ ->
                makeText(context, "yes clicked", Toast.LENGTH_SHORT).show()
            }
            setNegativeButton("no") { _, _ ->
                makeText(context, "no clicked", Toast.LENGTH_SHORT).show()
            }
        }

        val dialog = builder.create()
        dialog.show()
    }


}



