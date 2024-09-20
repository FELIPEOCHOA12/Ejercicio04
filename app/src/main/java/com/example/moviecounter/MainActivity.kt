package com.example.moviecounter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.moviecounter.ui.theme.MovieCounterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MovieCounterTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FruitCounter(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun FruitCounter(modifier: Modifier = Modifier) {
    var fruitName by remember { mutableStateOf("") }
    var uniqueFruits by remember { mutableStateOf(mutableSetOf<String>()) }

    Column(
        modifier = modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = fruitName,
            onValueChange = { fruitName = it },
            label = { Text("Inserte el nombre de la fruta") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            if (fruitName.isNotBlank()) {
                uniqueFruits.add(fruitName)
                fruitName = ""
            }
        }) {
            Text("Añadir fruta")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Hay ${uniqueFruits.size} unidades de fruta.")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFruitCounter() {
    FruitCounter()
}

