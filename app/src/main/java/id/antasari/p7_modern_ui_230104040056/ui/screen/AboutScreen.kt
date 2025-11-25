package id.antasari.p7_modern_ui_230104040056.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.antasari.p7_modern_ui_230104040056.ui.screens.BottomBarScaffold
import id.antasari.p7_modern_ui_230104040056.ui.theme.*

@Composable
fun AboutScreen(
    isDarkMode: Boolean,
    onHomeClick: () -> Unit,
    onProfileClick: () -> Unit,
    onSettingsClick: () -> Unit,
    onAboutClick: () -> Unit,
    onConfirmLogout: () -> Unit,
    onBack: () -> Unit
) {
    val cardColor = if (isDarkMode) CardDark else CardLight
    val bgColor = if (isDarkMode) BgDark else BgLight
    val textColor = if (isDarkMode) TextDark else TextLight
    val iconColor = if (isDarkMode) IconDark else IconLight

    BottomBarScaffold(
        title = "About",
        currentScreen = "About",
        onHomeClick = onHomeClick,
        onProfileClick = onProfileClick,
        onSettingsClick = onSettingsClick,
        onAboutClick = onAboutClick,
        isDarkMode = isDarkMode,
        onConfirmLogout = onConfirmLogout
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .background(bgColor)
                .padding(horizontal = 16.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Card utama About
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = cardColor),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Icon(
                        Icons.Filled.Info,
                        contentDescription = null,
                        tint = iconColor,
                        modifier = Modifier.size(48.dp)
                    )
                    Text(
                        "App Version: 1.0",
                        style = MaterialTheme.typography.headlineSmall,
                        color = textColor
                    )
                    Text(
                        "Enjoy a modern UI experience with Jetpack Compose. Navigate easily and explore interactive features without extra screens. Fast, smooth, fun, sleek, intuitive!",
                        style = MaterialTheme.typography.bodyMedium,
                        color = textColor,
                        lineHeight = 20.sp
                    )
                }
            }

            // Card kontak & info tambahan
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = cardColor),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    ContactRow(Icons.Filled.Email, "hsn.nrgina@gmail.com", isDarkMode)
                    ContactRow(Icons.Filled.Web, "https://github.com/husna-norgina", isDarkMode)
                    ContactRow(Icons.Filled.Phone, "+62 853 4875 7731", isDarkMode)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Tombol Back
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
                    Icon(Icons.Filled.ArrowBack, contentDescription = null, tint = Color.White)
                    Spacer(Modifier.width(8.dp))
                    Text("Back", color = Color.White, fontSize = 16.sp)
                }
            }

            // Footer copyright di bawah
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                "© 2025 Husna Norgina. All rights reserved.",
                style = MaterialTheme.typography.bodySmall,
                color = textColor,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Composable
fun ContactRow(icon: ImageVector, info: String, isDarkMode: Boolean) {
    val textColor = if (isDarkMode) TextDark else TextLight
    val iconColor = if (isDarkMode) IconDark else IconLight
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(icon, contentDescription = null, tint = iconColor)
        Spacer(Modifier.width(8.dp))
        Text(info, color = textColor)
    }
}