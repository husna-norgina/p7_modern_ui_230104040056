package id.antasari.p7_modern_ui_230104040056

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.*
import id.antasari.p7_modern_ui_230104040056.ui.screens.*
import id.antasari.p7_modern_ui_230104040056.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            var currentScreen by remember { mutableStateOf("Login") }
            var isDarkMode by remember { mutableStateOf(false) }

            AppTheme(useDarkTheme = isDarkMode) {
                when (currentScreen) {
                    "Login" -> LoginScreen(onLogin = { currentScreen = "Home" })

                    "Home" -> HomeScreen(
                        isDarkMode = isDarkMode,
                        onHomeClick = { currentScreen = "Home" },
                        onProfileClick = { currentScreen = "Profile" },
                        onSettingsClick = { currentScreen = "Settings" },
                        onAboutClick = { currentScreen = "About" },
                        onConfirmLogout = { currentScreen = "Login" }
                    )

                    "Profile" -> ProfileScreen(
                        isDarkMode = isDarkMode,
                        onHomeClick = { currentScreen = "Home" },
                        onProfileClick = { currentScreen = "Profile" },
                        onSettingsClick = { currentScreen = "Settings" },
                        onAboutClick = { currentScreen = "About" },
                        onBack = { currentScreen = "Home" }
                    )

                    "Settings" -> SettingsScreen(
                        isDarkMode = isDarkMode,
                        onToggleTheme = { isDarkMode = !isDarkMode },
                        onHomeClick = { currentScreen = "Home" },
                        onProfileClick = { currentScreen = "Profile" },
                        onSettingsClick = { currentScreen = "Settings" },
                        onAboutClick = { currentScreen = "About" },
                        onConfirmLogout = { currentScreen = "Login" },
                        onBack = { currentScreen = "Home" }
                    )

                    "About" -> AboutScreen(
                        isDarkMode = isDarkMode,
                        onHomeClick = { currentScreen = "Home" },
                        onProfileClick = { currentScreen = "Profile" },
                        onSettingsClick = { currentScreen = "Settings" },
                        onAboutClick = { currentScreen = "About" },
                        onConfirmLogout = { currentScreen = "Login" },
                        onBack = { currentScreen = "Home" }
                    )
                }
            }
        }
    }
}