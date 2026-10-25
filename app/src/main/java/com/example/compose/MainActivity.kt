package com.example.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.compose.ui.theme.ComposeTheme

data class ItemList(
    val nama: String,
    val deskripsi: String,
    val gambar: Int
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeTheme {
                HalamanLazyList()
            }
        }
    }
}

@Composable
fun HalamanLazyList() {

    val daftarItem = listOf(
        ItemList(
            nama = "Minuman",
            deskripsi = "Menu Minuman Menyegarkan",
            gambar = R.drawable.gambar_1
        ),
        ItemList(
            nama = "Paket",
            deskripsi = "Menu Paket Murah",
            gambar = R.drawable.gambar_2
        ),
        ItemList(
            nama = "Burger",
            deskripsi = "Burger Bangor",
            gambar = R.drawable.gambar_3
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        // Identitas mahasiswa di atas LazyList
        Text(
            text = "Nama: Prasetya Hafidz Ramadhan",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "NIM: 245150407111053",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        // LazyList
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(daftarItem) { item ->

                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        // Gambar lokal dari drawable
                        Image(
                            painter = painterResource(
                                id = item.gambar
                            ),
                            contentDescription = item.nama,
                            modifier = Modifier.size(100.dp)
                        )

                        Column(
                            modifier = Modifier.padding(start = 16.dp)
                        ) {
                            Text(
                                text = item.nama,
                                fontWeight = FontWeight.Bold
                            )

                            Spacer(
                                modifier = Modifier.height(4.dp)
                            )

                            Text(
                                text = item.deskripsi
                            )
                        }
                    }
                }
            }
        }
    }
}