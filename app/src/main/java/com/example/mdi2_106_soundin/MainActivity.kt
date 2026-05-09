package com.example.mdi2_106_soundin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.mdi2_106_soundin.ui.UserSessionViewModel
import com.example.mdi2_106_soundin.ui.navigation.SoundInNavGraph
import com.example.mdi2_106_soundin.ui.theme.MDI2105SoundInTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val sessionViewModel: UserSessionViewModel = viewModel()
            MDI2105SoundInTheme {
                Surface( // Our personalized theme
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SoundInNavGraph(
                        navController = navController,
                        sessionViewModel = sessionViewModel
                    )
                } // end of surface
            }
        }
    }
}
