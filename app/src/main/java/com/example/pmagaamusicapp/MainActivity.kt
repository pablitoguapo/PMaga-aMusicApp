package com.example.pmagaamusicapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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

            NavHost(
                navController = navController,
                startDestination = "home"
            ) {

                composable("home") {
                    HomeScreen(navController)

                }

                composable("detail/{id}") { backStack ->

                    val id = backStack.arguments
                        ?.getString("id")
                        ?.toInt() ?: 0

                    AlbumScreen(id)
                }
            }

        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PMagañaMusicAppTheme {
        Greeting("Android")
    }
}