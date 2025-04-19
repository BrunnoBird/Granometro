package com.example.granometro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.granometro.core_navigation.graph.AppNavGraph
import com.example.granometro.core_ui.GranometroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GranometroTheme {
                val navController = rememberNavController()

                AppNavGraph(
                    navController = navController,
                    homeScreen = {
                        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                            Box(modifier = Modifier.padding(innerPadding)) {}
                        }
                    },
                    signInScreen = {
                        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                            Box(modifier = Modifier.padding(innerPadding)) {}
                        }
                    },
                    signUpScreen = {
                        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                            Box(modifier = Modifier.padding(innerPadding)) {}
                        }
                    }
                )
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    GranometroTheme {
//        Greeting("Android")
//    }
//}