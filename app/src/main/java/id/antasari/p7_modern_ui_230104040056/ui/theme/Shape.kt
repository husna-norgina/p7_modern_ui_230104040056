package id.antasari.p7_modern_ui_230104040056.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

val Shapes = Shapes(

    // Untuk Card besar, bottom sheet, container besar
    large = RoundedCornerShape(24.dp),

    // Untuk card biasa, tombol sedang, surface
    medium = RoundedCornerShape(16.dp),

    // Untuk TextField, tombol kecil, item kecil
    small = RoundedCornerShape(12.dp),

    // Tambahan opsional (kalau perlu)
    extraSmall = RoundedCornerShape(8.dp)
)
