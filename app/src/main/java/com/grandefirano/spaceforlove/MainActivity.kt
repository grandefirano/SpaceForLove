package com.grandefirano.spaceforlove

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel:MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bottomNavView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.navigation_home, R.id.navigation_photo_matcher, R.id.navigation_match_list))
        setupActionBarWithNavController(navController, appBarConfiguration)
        bottomNavView.setupWithNavController(navController)



        navController.addOnDestinationChangedListener { _, destination, _ ->

            when (destination.id) {

                R.id.login_fragment , R.id.signUpFirebaseAuthFragment -> {
                    bottomNavView.visibility=View.GONE
                }

                else -> {
                    bottomNavView.visibility=View.VISIBLE
                }

            }

        }

        viewModel.state.observe(this){state->
            when(state){
                AuthRepository.AuthenticationState.AUTHENTICATED->{
                    navController.navigate(R.id.navigation_home)
                }
                AuthRepository.AuthenticationState.UNAUTHENTICATED->{
                    navController.navigate(R.id.login_fragment)
                }
            }
        }


    }
}