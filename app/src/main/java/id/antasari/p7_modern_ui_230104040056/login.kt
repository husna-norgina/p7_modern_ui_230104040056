package id.antasari.p7_modern_ui_230104040056.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import id.antasari.p7_modern_ui_230104040056.R
import id.antasari.p7_modern_ui_230104040056.ui.components.AppTopBar
import id.antasari.p7_modern_ui_230104040056.ui.theme.PrimaryContainer
import id.antasari.p7_modern_ui_230104040056.ui.theme.PrimaryLight
import id.antasari.p7_modern_ui_230104040056.ui.theme.PrimaryDark

@Composable
fun LoginScreen(onLogin: () -> Unit) {

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    val isValid = username.isNotEmpty() && password.isNotEmpty()
    val color = MaterialTheme.colorScheme
    val isDark = color.background.luminance() < 0.5f

    // -------- USER-FRIENDLY GRADIENT BACKGROUND ----------
    val backgroundModifier = Modifier.background(
        Brush.verticalGradient(
            colors = if (!isDark) {
                listOf(
                    Color.White,
                    PrimaryContainer.copy(alpha = 0.92f),
                    PrimaryLight.copy(alpha = 0.95f)
                )
            } else {
                listOf(
                    PrimaryDark.copy(alpha = 0.92f),
                    color.surfaceVariant.copy(alpha = 0.85f),
                    color.background
                )
            }
        )
    )

    // -------- CARD STYLE ----------
    val cardColor = if (isDark)
        color.surface.copy(alpha = 0.95f)
    else
        Color.White.copy(alpha = 0.92f)

    val cardShadow = if (isDark) 10.dp else 16.dp

    val cardBorder = if (isDark)
        color.outline.copy(alpha = 0.25f)
    else
        PrimaryLight.copy(alpha = 0.18f)

    Scaffold(
        topBar = { AppTopBar(title = "Login") },
        containerColor = Color.Transparent
    ) { padding ->
        Box(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .then(backgroundModifier),
            contentAlignment = Alignment.TopCenter
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
                    .padding(top = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    painter = painterResource(id = R.drawable.luminex_logo),
                    contentDescription = null,
                    modifier = Modifier
                        .size(220.dp)
                        .padding(bottom = 8.dp)
                )

                Text(
                    text = "Hello! 👋",
                    style = MaterialTheme.typography.headlineSmall,
                    color = color.onBackground
                )

                Spacer(Modifier.height(4.dp))

                Text(
                    text = "Welcome to Luminex",
                    style = MaterialTheme.typography.headlineSmall,
                    color = color.onBackground
                )

                Text(
                    text = "Shine through your app",
                    style = MaterialTheme.typography.bodyMedium,
                    color = color.onBackground.copy(alpha = 0.7f)
                )

                Spacer(Modifier.height(32.dp))

                // ---------- LOGIN CARD ----------
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .shadow(
                            elevation = cardShadow,
                            shape = RoundedCornerShape(26.dp)
                        )
                        .background(cardColor, RoundedCornerShape(26.dp))
                        .border(
                            width = 1.dp,
                            color = cardBorder,
                            shape = RoundedCornerShape(26.dp)
                        )
                        .padding(30.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        "Sign In",
                        style = MaterialTheme.typography.headlineMedium,
                        color = color.onSurface
                    )

                    Spacer(Modifier.height(8.dp))

                    Text(
                        "Please login to continue",
                        style = MaterialTheme.typography.bodyMedium,
                        color = color.onSurfaceVariant
                    )

                    Spacer(Modifier.height(28.dp))

                    OutlinedTextField(
                        value = username,
                        onValueChange = { username = it },
                        label = { Text("Username") },
                        leadingIcon = { Icon(Icons.Default.Person, null) },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp)
                    )

                    Spacer(Modifier.height(16.dp))

                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("Password") },
                        leadingIcon = { Icon(Icons.Default.Lock, null) },
                        trailingIcon = {
                            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                                Icon(
                                    imageVector = if (passwordVisible)
                                        Icons.Default.VisibilityOff
                                    else Icons.Default.Visibility,
                                    contentDescription = null
                                )
                            }
                        },
                        visualTransformation =
                            if (passwordVisible) VisualTransformation.None
                            else PasswordVisualTransformation(),
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp)
                    )

                    Spacer(Modifier.height(26.dp))

                    Button(
                        onClick = onLogin,
                        enabled = isValid,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(54.dp),
                        shape = RoundedCornerShape(18.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = PrimaryLight,
                            contentColor = Color.White,
                            disabledContainerColor = PrimaryLight.copy(alpha = 0.4f),
                            disabledContentColor = Color.White.copy(alpha = 0.6f)
                        )
                    ) {
                        Text(
                            "Login",
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                }
            }
        }
    }
}
