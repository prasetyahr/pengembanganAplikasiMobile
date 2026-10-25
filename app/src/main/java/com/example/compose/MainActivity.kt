package com.example.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.compose.ui.theme.ComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeTheme {
                CounterScreen()
            }
        }
    }
}

@Composable
fun CounterScreen(
    counterViewModel: CounterViewModel = viewModel()
) {

    val counter by counterViewModel.counter.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // Identitas mahasiswa
        Text(
            text = "Nama: Prasetya Hafidz Ramadhan",
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "NIM: 245150407111053"
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Judul aplikasi
        Text(
            text = "Counter",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Angka counter
        Text(
            text = counter.toString(),
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Tombol Up dan Down
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Button(
                onClick = {
                    counterViewModel.up()
                }
            ) {
                Text(text = "Up")
            }

            Spacer(modifier = Modifier.width(16.dp))

            Button(
                onClick = {
                    counterViewModel.down()
                }
            ) {
                Text(text = "Down")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Tombol Reset
        Button(
            onClick = {
                counterViewModel.reset()
            }
        ) {
            Text(text = "Reset")
        }
    }
}