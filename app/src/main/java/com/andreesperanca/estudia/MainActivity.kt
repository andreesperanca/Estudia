package com.andreesperanca.estudia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.andreesperanca.estudia.ui.control.ControlPanelScreen
import com.andreesperanca.estudia.ui.theme.EstudiaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Surface(modifier = Modifier.fillMaxSize()) {
                EstudiaTheme {
                    ControlPanelScreen()
                }
            }
        }
    }
}
