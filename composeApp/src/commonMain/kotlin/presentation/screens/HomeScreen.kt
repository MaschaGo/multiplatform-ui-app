package presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import moe.tlaster.precompose.navigation.Navigator


@Composable
fun HomeScreen( navigator: Navigator,modifier: Modifier = Modifier) {
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally)  {
        Text("Experimental Content")
        Button(
            onClick = {
                navigator.navigate(route = "/greeting")
            }
        ) {
            Text(text = "GO to Greeting Page!")
        }
    }
}