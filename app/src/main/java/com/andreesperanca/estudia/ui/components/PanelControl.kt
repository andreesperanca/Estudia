package com.andreesperanca.estudia.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.andreesperanca.estudia.R
import com.andreesperanca.estudia.ui.theme.EstudiaTheme


@Composable
fun ControlPanel(
    playButtonClick: () -> Unit,
    playButtonPainter: Painter,

    changeStateButtonClick: () -> Unit,
    configButtonClick: () -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End
    ) {
        EstudiaTheme {
            ConfigButton(
                configButtonClick = { configButtonClick() }
            )
            PlayButton(
                playButtonClick = { playButtonClick() },
                playButtonIcon = playButtonPainter
            )
            ChangeStateButton(changeStateClick = {
                changeStateButtonClick()
            })
        }
    }
}


@Composable
@Preview(showBackground = true)
fun PreviewPanelControl() {
    EstudiaTheme {
        Column() {
            ControlPanel(
                playButtonPainter = painterResource(id = R.drawable.ic_play),
                playButtonClick = {},
                changeStateButtonClick = {},
                configButtonClick = {})
        }
    }
}