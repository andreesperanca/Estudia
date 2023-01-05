package com.andreesperanca.estudia.ui.theme

import android.graphics.Color
import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.andreesperanca.estudia.R


private val EczarFontFamily = FontFamily(
    Font(R.font.eczar_regular),
    Font(R.font.eczar_semibold, FontWeight.SemiBold)
)

private val RobotoCondensed = FontFamily(
    Font(R.font.robotocondensed_regular),
    Font(R.font.robotocondensed_light, FontWeight.Light),
    Font(R.font.robotocondensed_bold, FontWeight.Bold)
)

val Typography = Typography(
    defaultFontFamily = RobotoCondensed,
    h5 = TextStyle(
        fontWeight = FontWeight.W700,
        fontSize = 24.sp
    ),
    h6 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 30.sp,
        lineHeight = 20.sp,
        fontFamily = EczarFontFamily,
        letterSpacing = 3.sp
    ),
    body1 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        letterSpacing = 0.1.em
    ),
    body2 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.em
    ),
    button = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.2.em
    )
)
