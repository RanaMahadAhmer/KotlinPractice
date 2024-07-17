package com.ranamahadahmer.unitconverter

import android.annotation.SuppressLint
import android.content.res.Configuration.UI_MODE_NIGHT_YES
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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Devices
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
val units = listOf("Meter", "Foot", "Inches", "Centimetre")


@Composable
fun Greeting() {
    val inputUnit = remember { mutableStateOf(false) }
    val outputUnit = remember { mutableStateOf(false) }
    val inputUnitSelected = remember { mutableStateOf(units.first()) }
    val outputUnitSelected = remember { mutableStateOf(units.first()) }
    val input = remember { mutableStateOf("") }
    val output = remember { mutableStateOf("") }


    fun computeValue() {
        if (input.value.isNotEmpty()) {
            val num: Float =
                if (inputUnitSelected.value == outputUnitSelected.value) 1.0f else conversion["${inputUnitSelected.value}-${outputUnitSelected.value}"].toString()
                    .toFloat()
            output.value =
                (input.value.toFloat() * num).toString()
        } else {
            output.value = ""
        }
    }
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
            value = input.value,
            onValueChange = {
                input.value = it.replace(",", "").replace("(", "").replace(")", "").replace(",", "")
                    .replace("+", "").replace("-", "").replace("N", "").replace("/", "")
                    .replace("#", "").replace(" ", "").replace(";", "").replace("*", "")
                computeValue()
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            placeholder = { Text("Enter a value") })
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            CreateButton(
                menuState = inputUnit,
                selectedUnit = inputUnitSelected,
                func = ::computeValue
            )
            Spacer(modifier = Modifier.width(16.dp))
            CreateButton(
                menuState = outputUnit,
                selectedUnit = outputUnitSelected,
                func = ::computeValue
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "The result is: ${output.value}",
            fontWeight = FontWeight(600)
        )
    }
}

@Composable
fun CreateButton(
    menuState: MutableState<Boolean>,
    selectedUnit: MutableState<String>,
    func: () -> Unit
) {
    Box {

        Button(
            onClick = { menuState.value = !menuState.value }) {
            Text(selectedUnit.value)
            Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "Convert")
        }
        DropdownMenu(
            expanded = menuState.value,
            onDismissRequest = { menuState.value = false }) {
            for (unit in units) {
                DropdownMenuItem(text = { Text(unit) }, onClick = {
                    selectedUnit.value = unit
                    menuState.value = false
                    func()
                })
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    apiLevel = 35,
    device = Devices.PIXEL_7_PRO,
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
fun GreetingPreview() {
    UnitConverterTheme {
        Greeting()
    }
}