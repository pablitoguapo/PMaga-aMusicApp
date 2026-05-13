package com.example.pmagaamusicapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.pmagaamusicapp.ui.theme.PMagañaMusicAppTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pmagaamusicapp.Screen.AlbumScreen
import com.example.pmagaamusicapp.Screen.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            Scaffold(
                modifier = Modifier.fillMaxSize()
            ) { innerPadding ->

                NavHost(
                    navController = navController,
                    startDestination = "home"
                ) {

                    composable("home") {
                        HomeScreen(
                            innerPadding = innerPadding,
                            navController = navController
                        )
                    }

                    composable("detail/{id}") { backStack ->
                        val id = backStack.arguments?.getString("id") ?: ""
                        AlbumScreen(id)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PMagañaMusicAppTheme {
    }
}
