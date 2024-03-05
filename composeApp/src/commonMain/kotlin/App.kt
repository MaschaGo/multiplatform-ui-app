import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import moe.tlaster.precompose.PreComposeApp
import presentation.navigation.RootContent

@Composable
fun App() {
    PreComposeApp {
        MaterialTheme {
            RootContent()
        }
    }
}