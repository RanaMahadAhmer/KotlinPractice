package com.ranamahadahmer.unitconverter

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
fun Greeting( ) {
    Column ( verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()){

        Text(
            text = "Unit Converter!",
            fontWeight = FontWeight(1000)

        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = "", onValueChange = { println() }, placeholder = { Text("Enter a value") })
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Button(onClick = { /*TODO*/ }) {
                Text("Convert")
            }
            Spacer(modifier = Modifier.width(40.dp))
            Button(onClick = { /*TODO*/ }) {
                Text("Convert")
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