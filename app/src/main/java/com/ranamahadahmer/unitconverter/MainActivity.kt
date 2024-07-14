package com.ranamahadahmer.unitconverter

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ranamahadahmer.unitconverter.ui.theme.UnitConverterTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UnitConverterTheme {
                Scaffold {

                    Greeting(


                    )


                }
            }
        }
    }
}

@Composable
fun Greeting() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "Unit Converter!",
            fontWeight = FontWeight(1000)

        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = "",
            onValueChange = { x -> println(x) },
            placeholder = { Text("Enter a value") })
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Box {
                Button(onClick = { }) {
                    Text("Convert")
                    Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "Convert")
                }
                DropdownMenu(expanded = true, onDismissRequest = {}) {
                    DropdownMenuItem(text = { Text("Meter") }, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text("Feet") }, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text("Inches") }, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text("Centimeters") }, onClick = { /*TODO*/ })
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box {
                Button(onClick = {}) {
                    Text("Convert")
                    Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "Convert")
                }

                DropdownMenu(expanded = true, onDismissRequest = {}) {
                    DropdownMenuItem(text = { Text("Meter") }, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text("Feet") }, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text("Inches") }, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text("Centimeters") }, onClick = { /*TODO*/ })
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UnitConverterTheme {
        Greeting()
    }
}