package com.andreesperanca.estudia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.andreesperanca.estudia.navigation.SetupNavGraph
import com.andreesperanca.estudia.ui.theme.EstudiaTheme

class MainActivity : ComponentActivity() {

    private lateinit var navHostController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(modifier = Modifier.fillMaxSize()) {
                EstudiaTheme {
                    navHostController = rememberNavController()
                    SetupNavGraph(navController = navHostController)
                }
            }
        }
    }
}