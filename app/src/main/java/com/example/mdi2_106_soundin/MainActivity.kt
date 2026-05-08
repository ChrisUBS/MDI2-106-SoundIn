package com.example.mdi2_106_soundin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.mdi2_106_soundin.ui.navigation.SoundInNavGraph
import com.example.mdi2_106_soundin.ui.screens.LoginScreen
import com.example.mdi2_106_soundin.ui.theme.MDI2105SoundInTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MDI2105SoundInTheme {
                Surface( // Our personalized theme
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    SoundInNavGraph(navController = navController)
                } // end of surface
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SoundInPreview() {
    MDI2105SoundInTheme() {
        LoginScreen(
            onNavigateToRegister = {},
            onLoginSuccess = {}
        )
    }
}