package id.antasari.p7_modern_ui_230104040056.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.antasari.p7_modern_ui_230104040056.ui.components.AppCard
import id.antasari.p7_modern_ui_230104040056.ui.theme.PrimaryDark

@Composable
fun SettingsScreen(
    isDarkMode: Boolean,
    onToggleTheme: () -> Unit,
    onHomeClick: () -> Unit,
    onProfileClick: () -> Unit,
    onSettingsClick: () -> Unit,
    onAboutClick: () -> Unit,
    onConfirmLogout: () -> Unit,
    onBack: () -> Unit
) {
    val bgColor = if (isDarkMode) Color(0xFF2C3E50) else Color(0xFFD6E7F8)
    val textColor = if (isDarkMode) Color.White else Color.Black
    val buttonColor = if (isDarkMode) Color(0xFF546E7A) else PrimaryDark
    val toggleButtonColor = Color(0xFFD9534F)

    // Internal state
    var pushNotifications by remember { mutableStateOf(true) }
    var locationTracking by remember { mutableStateOf(false) }
    var selectedLanguage by remember { mutableStateOf("English") }

    BottomBarScaffold(
        title = "Settings",
        currentScreen = "Settings",
        isDarkMode = isDarkMode,
        onHomeClick = onHomeClick,
        onProfileClick = onProfileClick,
        onSettingsClick = onSettingsClick,
        onAboutClick = onAboutClick,
        onConfirmLogout = onConfirmLogout
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .background(bgColor) // warna sama persis Home & Profile
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text("App Settings", style = MaterialTheme.typography.headlineMedium, color = textColor)

            // -------------------- App Cards --------------------
            AppCard(
                title = if (isDarkMode) "Dark Mode" else "Light Mode",
                subtitle = "Current theme mode",
                icon = if (isDarkMode) Icons.Filled.DarkMode else Icons.Filled.LightMode,
                onClick = {},
                isDarkMode = isDarkMode
            )

            AppCard(
                title = "Notifications",
                subtitle = if (pushNotifications) "Enabled" else "Disabled",
                icon = Icons.Filled.Notifications,
                onClick = { pushNotifications = !pushNotifications },
                isDarkMode = isDarkMode
            )

            AppCard(
                title = "Location Tracking",
                subtitle = if (locationTracking) "Enabled" else "Disabled",
                icon = Icons.Filled.LocationOn,
                onClick = { locationTracking = !locationTracking },
                isDarkMode = isDarkMode
            )

            AppCard(
                title = "Language",
                subtitle = selectedLanguage,
                icon = Icons.Filled.Language,
                onClick = {
                    selectedLanguage =
                        if (selectedLanguage == "English") "Bahasa Indonesia" else "English"
                },
                isDarkMode = isDarkMode
            )

            AppCard(
                title = "App Version",
                subtitle = "v1.0.0",
                icon = Icons.Filled.Info,
                onClick = {},
                isDarkMode = isDarkMode
            )

            Spacer(modifier = Modifier.height(24.dp))

            // -------------------- Toggle Theme Button --------------------
            Button(
                onClick = onToggleTheme,
                colors = ButtonDefaults.buttonColors(containerColor = toggleButtonColor),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    imageVector = if (isDarkMode) Icons.Filled.LightMode else Icons.Filled.DarkMode,
                    contentDescription = null,
                    tint = Color.White
                )
                Spacer(Modifier.width(8.dp))
                Text(
                    if (isDarkMode) "Switch to Light Mode" else "Switch to Dark Mode",
                    color = Color.White,
                    fontSize = 16.sp
                )
            }


            // Back button
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    onClick = onBack,
                    colors = ButtonDefaults.buttonColors(containerColor = PrimaryDark),
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(Icons.Default.ArrowBack, contentDescription = null, tint = Color.White)
                    Spacer(Modifier.width(8.dp))
                    Text("Back", color = Color.White)
                }
            }
        }
    }
}
