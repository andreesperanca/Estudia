package com.andreesperanca.estudia.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.andreesperanca.estudia.R
import com.andreesperanca.estudia.ui.theme.EstudiaTheme

@Composable
fun SettingsTimerItem(
    modifier: Modifier = Modifier,
    duration: Long,
    addClick: (value: Long) -> Unit,
    removeClick: (value: Long) -> Unit,
    titleDuration: String
) {
    Column(
        modifier = modifier
            .padding(
                start = 24.dp,
                end = 24.dp,
                top = 16.dp,
                bottom = 16.dp
            )
            .background(color = MaterialTheme.colors.primary)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {

            var durationCycle by remember { mutableStateOf(duration) }

            IconButton(
                onClick = {
                    if(duration > 1) {
                        durationCycle = duration
                        durationCycle--
                        removeClick(durationCycle)
                    }
                },
                modifier = Modifier.padding(end = 32.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_minus),
                    contentDescription = "adicionar 1 minuto",
                    tint = Color.White
                )
            }

            Text(
                style = MaterialTheme.typography.h6,
                color = MaterialTheme.colors.onBackground,
                text = "$duration"
            )

            IconButton(
                onClick = {
                    durationCycle = duration
                    durationCycle++
                    addClick(durationCycle)
                },
                modifier = Modifier.padding(start = 32.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "adicionar 1 minuto",
                    tint = Color.White
                )
            }
        }

        Text(
            style = MaterialTheme.typography.body2,
            color = MaterialTheme.colors.onBackground,
            text = titleDuration
        )
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewSettingsTimeConfiguration() {
    EstudiaTheme {
        SettingsTimerItem(
            duration = 20,
            titleDuration = "Pausa curta",
            addClick = {},
            removeClick = {}
        )
    }
}