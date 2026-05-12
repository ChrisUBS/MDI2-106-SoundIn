package com.example.mdi2_106_soundin.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mdi2_106_soundin.ui.UserSessionViewModel
import com.example.mdi2_106_soundin.ui.screens.LoginScreen
import com.example.mdi2_106_soundin.ui.screens.MainScreen
import com.example.mdi2_106_soundin.ui.screens.RegisterScreen

@Composable
fun SoundInNavGraph(
    navController: NavHostController,
    sessionViewModel: UserSessionViewModel
) {
    NavHost(
        navController = navController,
        startDestination = SoundInRoutes.LOGIN
    ) {
        composable(SoundInRoutes.LOGIN) {
            LoginScreen(
                sessionViewModel = sessionViewModel,
                onNavigateToRegister = {
                    navController.navigate(SoundInRoutes.REGISTER)
                },
                onLoginSuccess = {
                    navController.navigate(SoundInRoutes.MAIN) {
                        popUpTo(SoundInRoutes.LOGIN) { inclusive = true }
                    }
                }
            )
        } // end login composable
        composable(SoundInRoutes.REGISTER) {
            RegisterScreen(
                sessionViewModel = sessionViewModel,
                onNavigateToLogin = {
                    navController.navigate(SoundInRoutes.LOGIN) {
                        popUpTo(SoundInRoutes.LOGIN) { inclusive = true }
                    }
                },
                onLoginSuccess = {
                    navController.navigate(SoundInRoutes.MAIN) {
                        popUpTo(SoundInRoutes.LOGIN) { inclusive = true }
                    }
                }
            )
        } // end register composable
        composable(SoundInRoutes.MAIN) {
            MainScreen(
                sessionViewModel = sessionViewModel,
                onLogout = {
                    navController.navigate(SoundInRoutes.LOGIN) {
                        popUpTo(navController.graph.id) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }
            )
        } // end main composable
    }
}