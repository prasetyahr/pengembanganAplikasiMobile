package com.example.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {

    var screen by remember {
        mutableStateOf(1)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // Nama dan NIM ditampilkan di semua screen
        Text(text = "Nama : Prasetya Hafidz Ramadhan")
        Text(text = "NIM : 245150407111053")

        // Isi screen
        if (screen == 1) {

            Text(
                text = "Screen 1",
                modifier = Modifier.padding(top = 24.dp)
            )

            Button(
                onClick = {
                    screen = 2
                },
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text(text = "Ke Halaman 2")
            }

        } else {

            Text(
                text = "Screen 2",
                modifier = Modifier.padding(top = 24.dp)
            )
        }
    }
}