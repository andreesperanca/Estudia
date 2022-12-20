package com.andreesperanca.estudia.ui.components

import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.andreesperanca.estudia.R
import com.andreesperanca.estudia.ui.theme.EstudiaTheme


@Composable
fun PlayButton(
    modifier: Modifier = Modifier,
    playButtonClick: () -> Unit = {},
    playButtonIcon: Painter = painterResource(id = R.drawable.ic_play)
) {
    Button(
        onClick = { playButtonClick() },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.primary,
            contentColor = MaterialTheme.colors.onSurface
        ),
        shape = AbsoluteRoundedCornerShape(16.dp),
        modifier = modifier
            .width(97.dp)
            .height(76.dp)
            .padding(4.dp)
    ) {
        Icon(
            painter = playButtonIcon,
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .width(24.dp)
                .height(24.dp)
                .padding(4.dp)
        )
    }
}


@Composable
fun ConfigButton(
    modifier: Modifier = Modifier,
    configButtonClick: () -> Unit = {},
    configButtonIcon: ImageVector = Icons.Filled.Settings
) {
    Button(
        onClick = { configButtonClick() },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.primary,
            contentColor = Color.White
        ),
        shape = AbsoluteRoundedCornerShape(16.dp),
        modifier = modifier
            .width(76.dp)
            .height(56.dp)
            .padding(4.dp)
    ) {
        Icon(
            imageVector = configButtonIcon,
            contentDescription = null,
            modifier = Modifier
                .align(CenterVertically)
                .fillMaxSize()
                .width(24.dp)
                .height(24.dp)
                .padding(4.dp)
        )
    }

}

@Composable
fun ChangeStateButton(
    modifier: Modifier = Modifier,
    changeStateClick: () -> Unit = {},
    changeStateButtonIcon: ImageVector = Icons.Filled.KeyboardArrowRight
) {
    Button(
        onClick = { changeStateClick() },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.primary,
            contentColor = Color.White
        ),
        shape = AbsoluteRoundedCornerShape(16.dp),
        modifier = Modifier
            .width(76.dp)
            .height(56.dp)
            .padding(4.dp)
    ) {
        Icon(
            imageVector = changeStateButtonIcon,
            contentDescription = null,
            modifier = Modifier
                .align(CenterVertically)
                .fillMaxSize()
                .width(24.dp)
                .height(24.dp)
                .padding(4.dp)
        )
    }
}


@Composable
@Preview(showBackground = true)
fun PreviewPlayButton() {
    EstudiaTheme {
        PlayButton()
    }
}

@Composable
@Preview(showBackground = true)
fun ChangeButtonPreview() {
    EstudiaTheme {
        ChangeStateButton()
    }
}

@Composable
@Preview(showBackground = true)
fun ConfigButtonPreview() {
    EstudiaTheme {
        ConfigButton()
    }
}