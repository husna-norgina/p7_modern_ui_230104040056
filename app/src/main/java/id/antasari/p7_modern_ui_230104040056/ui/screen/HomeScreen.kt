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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.antasari.p7_modern_ui_230104040056.ui.components.AppCard
import id.antasari.p7_modern_ui_230104040056.ui.components.AppTopBar
import id.antasari.p7_modern_ui_230104040056.ui.theme.PrimaryDark

// -----------------------
// Bottom Navigation Items
// -----------------------
enum class BottomNavItem(val label: String, val icon: androidx.compose.ui.graphics.vector.ImageVector) {
    Home("Home", Icons.Default.Home),
    Profile("Profile", Icons.Default.Person),
    Settings("Settings", Icons.Default.Settings),
    About("About", Icons.Default.Info)
}

// ----------------------
// BOTTOM BAR SCAFFOLD
// ----------------------
@Composable
fun BottomBarScaffold(
    title: String,
    currentScreen: String,
    isDarkMode: Boolean,
    onHomeClick: () -> Unit,
    onProfileClick: () -> Unit,
    onSettingsClick: () -> Unit,
    onAboutClick: () -> Unit,
    onConfirmLogout: () -> Unit,
    content: @Composable (PaddingValues) -> Unit
) {
    val selectedLightColor = Color(0xFF1976D2) // light mode selected
    val selectedDarkColor = Color(0xFF81D4FA)  // dark mode selected

    Scaffold(
        topBar = { AppTopBar(title = title) },
        bottomBar = {
            NavigationBar(containerColor = if (isDarkMode) PrimaryDark else Color.White) {
                BottomNavItem.values().forEach { item ->
                    val isSelected = when (item) {
                        BottomNavItem.Home -> currentScreen == "Home"
                        BottomNavItem.Profile -> currentScreen == "Profile"
                        BottomNavItem.Settings -> currentScreen == "Settings"
                        BottomNavItem.About -> currentScreen == "About"
                    }
                    val iconColor = if (isSelected) {
                        if (isDarkMode) selectedDarkColor else selectedLightColor
                    } else {
                        Color.Gray
                    }

                    NavigationBarItem(
                        selected = isSelected,
                        onClick = {
                            when (item) {
                                BottomNavItem.Home -> onHomeClick()
                                BottomNavItem.Profile -> onProfileClick()
                                BottomNavItem.Settings -> onSettingsClick()
                                BottomNavItem.About -> onAboutClick()
                            }
                        },
                        icon = { Icon(item.icon, contentDescription = item.label, tint = iconColor) },
                        label = { Text(item.label, color = iconColor) }
                    )
                }
            }
        },
        content = content
    )
}

// ----------------------
// HOME SCREEN
// ----------------------
@Composable
fun HomeScreen(
    isDarkMode: Boolean,
    onHomeClick: () -> Unit,
    onProfileClick: () -> Unit,
    onSettingsClick: () -> Unit,
    onAboutClick: () -> Unit,
    onConfirmLogout: () -> Unit
) {
    var showLogoutDialog by remember { mutableStateOf(false) }
    val textColor = if (isDarkMode) Color.White else Color.Black
    val bgColor = if (isDarkMode) Color(0xFF2C3E50) else Color(0xFFD6E7F8)
    val logoutButtonColor = if (isDarkMode) Color(0xFFE57373) else Color(0xFFD9534F)

    BottomBarScaffold(
        title = "Home",
        currentScreen = "Home",
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
                .background(bgColor)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                "Dashboard",
                style = MaterialTheme.typography.headlineMedium,
                color = textColor,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start
            )

            // -------------------- App Cards --------------------
            AppCard(
                title = "Profile",
                subtitle = "Your personal details",
                icon = Icons.Filled.Person,
                onClick = onProfileClick,
                isDarkMode = isDarkMode
            )

            AppCard(
                title = "Settings",
                subtitle = "Customize the app",
                icon = Icons.Filled.Settings,
                onClick = onSettingsClick,
                isDarkMode = isDarkMode
            )

            AppCard(
                title = "About",
                subtitle = "Application information",
                icon = Icons.Filled.Info,
                onClick = onAboutClick,
                isDarkMode = isDarkMode
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Tombol Logout
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    onClick = { showLogoutDialog = true },
                    colors = ButtonDefaults.buttonColors(containerColor = logoutButtonColor),
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(Icons.Filled.ExitToApp, contentDescription = null, tint = Color.White)
                    Spacer(Modifier.width(8.dp))
                    Text("Logout", color = Color.White)
                }
            }
        }

        // -------------------- Dialog Logout --------------------
        if (showLogoutDialog) {
            androidx.compose.material3.AlertDialog(
                onDismissRequest = { showLogoutDialog = false },
                title = { Text("Logout", color = textColor) },
                text = { Text("Are you sure you want to logout?", color = textColor.copy(alpha = 0.7f)) },
                confirmButton = {
                    Button(
                        onClick = {
                            showLogoutDialog = false
                            onConfirmLogout()
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = logoutButtonColor)
                    ) { Text("Logout") }
                },
                dismissButton = {
                    OutlinedButton(onClick = { showLogoutDialog = false }) {
                        Text("Cancel")
                    }
                },
                containerColor = if (isDarkMode) Color(0xFF1F1F1F) else Color.White,
                shape = RoundedCornerShape(20.dp)
            )
        }
    }
}