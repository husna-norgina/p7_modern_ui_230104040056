package id.antasari.p7_modern_ui_230104040056.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun AppCard(
    title: String,
    subtitle: String = "",
    icon: androidx.compose.ui.graphics.vector.ImageVector? = null,
    onClick: () -> Unit,
    isDarkMode: Boolean = false
) {
    val cardColor = if (isDarkMode) Color(0xFF546E7A) else Color.White
    val contentColor = if (isDarkMode) Color.White else Color.Black

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = cardColor),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (icon != null) {
                Icon(icon, contentDescription = null, tint = contentColor)
                Spacer(modifier = Modifier.width(12.dp))
            }
            Column {
                Text(title, style = MaterialTheme.typography.bodyLarge, color = contentColor)
                if (subtitle.isNotEmpty())
                    Text(subtitle, style = MaterialTheme.typography.bodyMedium, color = contentColor)
            }
        }
    }
}
