package com.andreesperanca.estudia.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.magnifier
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.andreesperanca.estudia.R
import com.andreesperanca.estudia.ui.theme.EstudiaTheme


@Composable
fun HorizontalControlPanel(
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
fun VerticalControlPanel(
    playButtonClick: () -> Unit,
    playButtonPainter: Painter,

    changeStateButtonClick: () -> Unit,
    configButtonClick: () -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
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
fun PreviewVerticalPanelControl() {
    EstudiaTheme {
        Column() {
            HorizontalControlPanel(
                playButtonPainter = painterResource(id = R.drawable.ic_play),
                playButtonClick = {},
                changeStateButtonClick = {},
                configButtonClick = {}
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewHorizontalPanelControl() {
    EstudiaTheme {
        Column() {
            VerticalControlPanel(
                playButtonPainter = painterResource(id = R.drawable.ic_play),
                playButtonClick = {},
                changeStateButtonClick = {},
                configButtonClick = {}
            )
        }
    }
}