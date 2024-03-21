import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import moe.tlaster.precompose.PreComposeApp
import org.koin.compose.KoinContext
import presentation.navigation.RootContent

@Composable
fun App() {
    KoinContext {
        PreComposeApp {
            MaterialTheme {
                RootContent()
            }
        }
    }
}