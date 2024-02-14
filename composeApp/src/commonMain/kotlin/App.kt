import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App(countries: List<Country> = MockCountry().countries()) {
    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }
        var location by remember { mutableStateOf("Europe/Paris") }
        var timeAtLocation by remember { mutableStateOf("No location selected") }
        var timeAtLocationZone by remember { mutableStateOf("No location / zone selected") }
        var showCountries by remember { mutableStateOf(false) }
        val greeting = remember { Greeting().greet() }
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Today's date is ${Date().todaysDate()}",
                modifier = Modifier.padding(20.dp),
                fontSize = 24.sp,
                textAlign = TextAlign.Center
            )
            Text(
                timeAtLocation,
                style = TextStyle(fontSize = 20.sp),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth().align(Alignment.CenterHorizontally)
            )
            TextField(value = location,
                modifier = Modifier.padding(top = 16.dp),
                onValueChange = { location = it })
            Button(
                modifier = Modifier.padding(top = 16.dp),
                onClick = {
                    timeAtLocation = Date().currentTimeAtLocation(location) ?: "Invalid Location"
                }) {
                Text("Show Time At Location")
            }
            Text(
                timeAtLocationZone,
                style = TextStyle(fontSize = 20.sp),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth().align(Alignment.CenterHorizontally)
                    .padding(start = 20.dp, top = 24.dp)
            )
            Row(modifier = Modifier.padding(start = 20.dp, top = 16.dp)) {
                DropdownMenu(
                    expanded = showCountries,
                    onDismissRequest = { showCountries = false }
                ) {
                    MockCountry().countries().forEach { (name, zone, image) ->
                        DropdownMenuItem(
                            onClick = {
                                timeAtLocationZone = Date().currentTimeAt(name, zone)
                                showCountries = false
                            }
                        ) {

                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Image(
                                    painterResource(image),
                                    modifier = Modifier.size(50.dp).padding(end = 10.dp),
                                    contentDescription = "$name flag"
                                )
                                Text(name)
                            }
                        }
                    }
                }
            }
            Button(modifier = Modifier.padding(start = 20.dp, top = 16.dp),
                onClick = { showCountries = !showCountries }) {
                Text("Select Location")
            }




            Button(
                modifier = Modifier.padding(top = 10.dp),
                onClick = { showContent = !showContent }) {
                Text("Click me!")
            }
            AnimatedVisibility(showContent) {
                Column(
                    Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(painterResource("compose-multiplatform.xml"), null)
                    Text("Compose: $greeting")
                }
            }
        }
    }
}