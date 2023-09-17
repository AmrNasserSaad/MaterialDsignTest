package com.example.materialdsign3

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.materialdsign3.R.id.fragment_container
import com.example.materialdsign3.R.id.homePage
import com.example.materialdsign3.R.id.musicPage
import com.example.materialdsign3.R.id.settingsPage
import com.example.materialdsign3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val musicFragment = music_fragment()
    private val homeFragment = home_fragment()
    private val settingsFragment = settings_fragment()

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addFragment(homeFragment)

        moveToFragments()

        binding.dialogButton.setOnClickListener { showDialog() }

    }



    private fun moveToFragments() {
        binding.navButton.setOnItemSelectedListener { item ->
            when(item.itemId){


                musicPage -> { replaceFragment(musicFragment)
                true
                }

                homePage -> { replaceFragment(homeFragment)
                true
                }

                settingsPage -> { replaceFragment(settingsFragment)
                true
                }
                else -> false

            }
        }
    }

    private fun  addFragment(fragment : Fragment){
        val transaction =  supportFragmentManager.beginTransaction()
        transaction.add(fragment_container,fragment)
        transaction.commit()
    }

    private fun  replaceFragment(fragment : Fragment){
        val transaction =  supportFragmentManager.beginTransaction()
        transaction.replace(fragment_container,fragment)
        transaction.commit()
    }
    private fun  showDialog(){

       val builder = AlertDialog.Builder(this)
       builder.apply {
           setTitle("Title")
           setMessage("message")
           setPositiveButton("yes",DialogInterface.OnClickListener { _, _ ->
               Toast.makeText(this@MainActivity,"yes clicked",Toast.LENGTH_SHORT).show()
           })
           setNegativeButton("no",DialogInterface.OnClickListener { _, _ ->
               Toast.makeText(this@MainActivity,"no clicked",Toast.LENGTH_SHORT).show()
           })
       }

       val dialog = builder.create()
       dialog.show()
   }


}