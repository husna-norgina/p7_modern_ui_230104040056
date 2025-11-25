package id.antasari.p7_modern_ui_230104040056.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.antasari.p7_modern_ui_230104040056.ui.theme.PrimaryDark
import id.antasari.p7_modern_ui_230104040056.ui.theme.PrimaryLight

@Composable
fun ProfileScreen(
    isDarkMode: Boolean,
    onHomeClick: () -> Unit,
    onProfileClick: () -> Unit,
    onSettingsClick: () -> Unit,
    onAboutClick: () -> Unit,
    onBack: () -> Unit
) {
    val backgroundColor = if (isDarkMode) Color(0xFF2C3E50) else Color(0xFFD6E7F8)
    val cardColor = if (isDarkMode) Color(0xFF546E7A) else Color.White
    val textPrimary = if (isDarkMode) Color.White else Color.Black
    val textSecondary = if (isDarkMode) Color(0xFFB0BEC5) else Color.Gray
    val cardElevation = 8.dp

    BottomBarScaffold(
        title = "Profile",
        currentScreen = "Profile",
        isDarkMode = isDarkMode,
        onHomeClick = onHomeClick,
        onProfileClick = onProfileClick,
        onSettingsClick = onSettingsClick,
        onAboutClick = onAboutClick,
        onConfirmLogout = {}
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .background(backgroundColor)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text("Profile", style = MaterialTheme.typography.headlineMedium, color = textPrimary)

            // Profile info
            AppCardWithIcon(
                title = "Husna Norgina",
                subtitle = "Mobile Programming Student",
                icon = Icons.Default.Person,
                cardColor = cardColor,
                elevation = cardElevation,
                onClick = {},
                textColor = textPrimary
            )

            // About Me
            AppCardWithIcon(
                title = "About Me",
                subtitle = "Passionate about Mobile Programming and UI/UX Design. Always eager to learn new technologies.",
                icon = Icons.Default.Info,
                cardColor = cardColor,
                elevation = cardElevation,
                onClick = {},
                textColor = textPrimary
            )

            // Additional Info
            AppCardWithIcon(
                title = "Major",
                subtitle = "Information Technology",
                icon = Icons.Default.MenuBook,
                cardColor = cardColor,
                elevation = cardElevation,
                onClick = {},
                textColor = textPrimary
            )
            AppCardWithIcon(
                title = "Student ID",
                subtitle = "230104040056",
                icon = Icons.Default.CreditCard,
                cardColor = cardColor,
                elevation = cardElevation,
                onClick = {},
                textColor = textPrimary
            )
            AppCardWithIcon(
                title = "Status",
                subtitle = "Active Student",
                icon = Icons.Default.CheckCircle,
                cardColor = cardColor,
                elevation = cardElevation,
                onClick = {},
                textColor = textPrimary
            )

            Spacer(modifier = Modifier.height(24.dp))

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

@Composable
fun AppCardWithIcon(
    title: String,
    subtitle: String = "",
    icon: ImageVector,
    cardColor: Color,
    elevation: Dp,
    onClick: () -> Unit,
    textColor: Color
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .shadow(elevation, RoundedCornerShape(16.dp))
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(elevation),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = cardColor)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(icon, contentDescription = null, tint = textColor, modifier = Modifier.size(32.dp))
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(title, style = MaterialTheme.typography.bodyLarge, color = textColor)
                if (subtitle.isNotEmpty()) {
                    Text(subtitle, style = MaterialTheme.typography.bodyMedium, color = textColor.copy(alpha = 0.7f))
                }
            }
        }
    }
}
