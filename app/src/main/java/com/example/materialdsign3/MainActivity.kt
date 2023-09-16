package com.example.materialdsign3

import android.os.Bundle
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
}
