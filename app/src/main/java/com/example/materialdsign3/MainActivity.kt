package com.example.materialdsign3

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.materialdsign3.R.id.fragment_container
import com.example.materialdsign3.R.id.homePage
import com.example.materialdsign3.R.id.musicPage
import com.example.materialdsign3.R.id.settingsPage
import com.example.materialdsign3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val musicFragment = MusicFragment()
    private val homeFragment = HomeFragment()
    private val settingsFragment = SettingsFragment()

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addFragment(homeFragment)

        moveToFragments()



    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_action_bar,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){

            R.id.refreshItem -> {
               Toast.makeText(this, "refresh", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.SettingsItem -> {
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.aboutItem -> {
                Toast.makeText(this, "refresh", Toast.LENGTH_SHORT).show()
                return true
            }


        }
        return super.onOptionsItemSelected(item)
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