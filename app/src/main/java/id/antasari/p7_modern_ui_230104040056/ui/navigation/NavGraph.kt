package id.antasari.p7_modern_ui_230104040056.ui.navigation

import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import id.antasari.p7_modern_ui_230104040056.ui.screens.*

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()
    var isDarkMode by remember { mutableStateOf(false) }

    NavHost(navController = navController, startDestination = "Login") {

        composable("Login") {
            LoginScreen(onLogin = {
                navController.navigate("Home") {
                    popUpTo("Login") { inclusive = true }
                }
            })
        }

        composable("Home") {
            HomeScreen(
                onHomeClick = { /* tetap di Home */ },
                onProfileClick = { navController.navigate("Profile") },
                onSettingsClick = { navController.navigate("Settings") },
                onAboutClick = { navController.navigate("About") },
                isDarkMode = isDarkMode,
                onConfirmLogout = {
                    navController.navigate("Login") {
                        popUpTo("Home") { inclusive = true }
                    }
                }
            )
        }

        composable("Profile") {
            ProfileScreen(
                isDarkMode = isDarkMode,
                onHomeClick = { navController.navigate("Home") },
                onProfileClick = { /* tetap di Profile */ },
                onSettingsClick = { navController.navigate("Settings") },
                onAboutClick = { navController.navigate("About") },
                onBack = { navController.popBackStack() }
            )
        }

        composable("Settings") {
            SettingsScreen(
                isDarkMode = isDarkMode,
                onToggleTheme = { isDarkMode = !isDarkMode },
                onHomeClick = { navController.navigate("Home") },
                onProfileClick = { navController.navigate("Profile") },
                onSettingsClick = { /* tetap di Settings */ },
                onAboutClick = { navController.navigate("About") },
                onConfirmLogout = {
                    navController.navigate("Login") {
                        popUpTo("Settings") { inclusive = true }
                    }
                },
                onBack = { navController.popBackStack() }
            )
        }

        composable("About") {
            AboutScreen(
                isDarkMode = isDarkMode,
                onHomeClick = { navController.navigate("Home") },
                onProfileClick = { navController.navigate("Profile") },
                onSettingsClick = { navController.navigate("Settings") },
                onAboutClick = { /* tetap di About */ },
                onConfirmLogout = {
                    navController.navigate("Login") {
                        popUpTo("About") { inclusive = true }
                    }
                },
                onBack = { navController.popBackStack() }
            )
        }
    }
}
