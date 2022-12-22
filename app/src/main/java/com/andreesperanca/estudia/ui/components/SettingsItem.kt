package com.andreesperanca.estudia.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.andreesperanca.estudia.R
import com.andreesperanca.estudia.ui.theme.EstudiaTheme


@Composable
fun SettingsItem(
    modifier: Modifier = Modifier, settingTitle: String, settingDescription: String = "",
    onClick: (value: Boolean) -> Unit,
    checked: Boolean
) {
    Row(
        modifier = modifier
            .padding(top = 16.dp)
            .fillMaxWidth()
            .background(color = MaterialTheme.colors.background),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        var option by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .weight(1f)
        ) {
            Text(
                modifier = Modifier.padding(start = 8.dp, end = 8.dp),
                color = MaterialTheme.colors.onBackground,
                text = settingTitle
            )

            Text(
                modifier = Modifier.padding(start = 8.dp, end = 8.dp),
                color = MaterialTheme.colors.onBackground.copy(alpha = 0.4f),
                text = settingDescription,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
        }
        Switch(modifier = Modifier
            .width(52.dp)
            .height(100.dp)
            .background(MaterialTheme.colors.primary),
            checked = checked,
            onCheckedChange = { newValue ->
                option = newValue
                onClick(newValue)
            })
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewSettingsConfiguration() {
    EstudiaTheme {
        SettingsItem(
            settingTitle = stringResource(id = R.string.notifications),
            settingDescription = stringResource(id = R.string.notificationSettingDescription),
            onClick = {},
            checked = false
        )
    }
}
