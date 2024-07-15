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
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
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

val conversion = mapOf(
    "Meter-Foot" to 3.28084,
    "Meter-Inches" to 36,
    "Meter-Centimetre" to 100,
    "Foot-Meter" to 0.3048,
    "Foot-Inches" to 12,
    "Foot-Centimetre" to 30.480,
    "Inches-Meter" to 0.02540,
    "Inches-Foot" to 0.08333,
    "Inches-Centimetre" to 2.5399,
    "Centimetre-Meter" to 0.01,
    "Centimetre-Foot" to 0.03280,
    "Centimetre-Inches" to 0.3937008,
)
val units = listOf<String>("Meter", "Foot", "Inches", "Centimetre")


@Composable
fun Greeting() {
    var inputUnit by remember { mutableStateOf(false) }
    var outputUnit by remember { mutableStateOf(false) }
    var inputUnitSelected by remember { mutableStateOf(units.first()) }
    var outputUnitSelected by remember { mutableStateOf(units.first()) }
    var input by remember { mutableStateOf("") }
    var output by remember { mutableStateOf("") }


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
            value = input,
            onValueChange = { value ->
                input = value.replace(",", "").replace("(", "").replace(")", "").replace(",", "")
                    .replace("+", "").replace("-", "").replace("N", "").replace("/", "")
                    .replace("#", "").replace(" ", "").replace(";", "").replace("*", "")

            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            placeholder = { Text("Enter a value") })
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Box {

                Button(onClick = { inputUnit = !inputUnit }) {
                    Text(inputUnitSelected)
                    Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "Convert")
                }
                DropdownMenu(expanded = inputUnit, onDismissRequest = { inputUnit = false }) {
                    for (unit in units) {
                        DropdownMenuItem(text = { Text(unit) }, onClick = {
                            inputUnitSelected = unit
                            inputUnit = false
                        })
                    }
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box {
                Button(onClick = { outputUnit = !outputUnit }) {
                    Text(outputUnitSelected)
                    Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "Convert")
                }

                DropdownMenu(expanded = outputUnit, onDismissRequest = { outputUnit = false }) {
                    for (unit in units) {
                        DropdownMenuItem(text = { Text(unit) }, onClick = {
                            outputUnitSelected = unit
                            outputUnit = false
                            if (input.isNotEmpty()) {
                                val num:Float = if (inputUnitSelected == outputUnitSelected) 1.0f else conversion["$inputUnitSelected-$outputUnitSelected"].toString().toFloat()
                                output =
                                    (input.toFloat() * num).toString()
                            }

                        })
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "The result is: $output",
            fontWeight = FontWeight(600)

        )

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UnitConverterTheme {
        Greeting()
    }
}