package id.antasari.p7_modern_ui_230104040056.ui.components

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import id.antasari.p7_modern_ui_230104040056.ui.theme.PrimaryLight

@Composable
fun AppButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    enabled: Boolean = true
) {
    Button(
        onClick = onClick,
        enabled = enabled,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = PrimaryLight,
            disabledContainerColor = PrimaryLight.copy(alpha = 0.3f), // abu elegan
            disabledContentColor = androidx.compose.material3.MaterialTheme.colorScheme.onSurface.copy(alpha = 0.4f)
        ),
        elevation = ButtonDefaults.buttonElevation(4.dp)
    ) {
        Text(text)
    }
}
