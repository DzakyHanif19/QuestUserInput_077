package com.example.project4

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun MainScreen(
    modifier: Modifier = Modifier
){
    var nama by rememberSaveable { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var noHP by remember { mutableStateOf("") }
    var selectedGender by remember { mutableStateOf("") }

    val jenisKelamin = listOf("laki - laki","Perempuan")

    var confirmnama by rememberSaveable { mutableStateOf("") }
    var confirmEmail by remember { mutableStateOf("") }
    var confirmAlamat by remember { mutableStateOf("") }
    var confirmNoHP by remember { mutableStateOf("") }
    var confirmJenisKelamin by remember { mutableStateOf("") }

    Column (Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment =Alignment.CenterHorizontally ){
        OutlinedTextField(value = nama,
            onValueChange = {nama = it},
            placeholder = { Text("Masukkan Nama") },
            label = { Text("Nama") },
            modifier = Modifier.fillMaxWidth().padding(5.dp))
        Row {
            jenisKelamin.forEach { item ->
                Row (verticalAlignment = Alignment.CenterVertically){ RadioButton(selected = selectedGender == item,
                    onClick ={
                        selectedGender = item
                    } )
                    Text(item)
                }
            }
        }

        OutlinedTextField(value = email,
            onValueChange = {email = it},
            placeholder = { Text("Masukkan Email") }, label = { Text("Email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth().padding(5.dp))

        OutlinedTextField(value = alamat,
            onValueChange = {alamat = it},
            placeholder = { Text("Masukkan Alamat") }, label = { Text("Alamat") },
            modifier = Modifier.fillMaxWidth().padding(5.dp))

        OutlinedTextField(value = noHP,
            onValueChange = {noHP = it},
            placeholder = { Text("Masukkan No Hp") }, label = { Text("No Hp") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth().padding(5.dp))

        Button(onClick = {
            confirmnama = nama
            confirmJenisKelamin = selectedGender
            confirmEmail = email
            confirmAlamat = alamat
            confirmNoHP = noHP

        }) { Text("Simpan") }
        Card (modifier.size(height =200.dp, width = 300.dp)){
            CardSection(judulParam = "Nama", isiParam = confirmnama)
            CardSection(judulParam = "Jenis Kelamin", isiParam = confirmJenisKelamin)
            CardSection(judulParam = "Email", isiParam = confirmEmail)
            CardSection(judulParam = "Alamat", isiParam = confirmAlamat)
            CardSection(judulParam = "No HP", isiParam = confirmNoHP)
        }
    }
}
@Composable
fun CardSection(judulParam:String,isiParam:String){
    Column(horizontalAlignment = Alignment.Start) {
        Row (modifier = Modifier.fillMaxWidth().padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(text = judulParam, modifier = Modifier.weight(0.8f))
            Text(text = ":", modifier = Modifier.weight(0.2f))
            Text(text = isiParam, modifier = Modifier.weight(2f))
        }
    }
}