package com.example.dilaproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.dilaproject.navigation.PearlpalsNavigation
import com.example.dilaproject.ui.theme.DilaProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DilaProjectTheme {
                val navController = rememberNavController()
                PearlpalsNavigation(navController)
            }
        }
    }
}