package com.example.buttonnavigate

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var myMenu: BottomNavigationView
    @SuppressLint("MissingInflatedId", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        this.myMenu =findViewById(R.id.myMenu)

            myMenu.setOnItemSelectedListener{menuitem ->
                when(menuitem.itemId){
                    R.id.myAmerican -> {
                        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, mFirstFragment()).commit()
                        true
                    }
                    R.id.myBurger -> {
                        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, mSecondFragment()).commit()
                        true
                    }
                    R.id.myPizza -> {
                        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, mThirdFragment()).commit()
                        true
                    }
                    R.id.myDrink -> {
                        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, mFourFragment()).commit()
                        true
                    }
                    else -> {
                        //supportFragmentManager.beginTransaction().replace(R.id.main, mThirdFragment()).commit()
                        true
                    }

                }
            }

    }

}