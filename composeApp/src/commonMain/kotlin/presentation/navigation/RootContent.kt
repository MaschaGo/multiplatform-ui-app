package presentation.navigation


import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.rememberNavigator
import presentation.screens.ChatScreen
import presentation.screens.GreetingScreen
import presentation.screens.HomeScreen
import presentation.screens.MidJourneyScreen

@Composable
fun RootContent() {
    val navigator = rememberNavigator()
    Scaffold(bottomBar = { BottomBar(navigator) }) {
        NavHost(
            navigator = navigator,
            initialRoute = "/home",
        ) {
            scene("/home") {
                HomeScreen(navigator)
            }
            scene("/greeting") {
                GreetingScreen()
            }
            scene("/midjourney") {
                MidJourneyScreen()
            }

            scene("/midjourney/{id}") { backstackEntry ->
//                val playerId = allPlayers.random().name//backstackEntry.path<String>("id") ?: allPlayers.random().name
//                val player = allPlayers.find { it.name == playerId } ?: allPlayers.random()
//                MidJourneyDetailScreen(player)
            }

            scene("/chat") { backstackEntry ->
                ChatScreen()
            }
        }
    }
}

@Composable
fun BottomBar(navigator : Navigator) {
    BottomAppBar {
        BottomNavigationItem(
            selected = true,
            onClick = { navigator.navigate("/home")},
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home"
                )
            }
        )
        BottomNavigationItem(
            selected = true,
            onClick = {navigator.navigate("/greeting")},
            icon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Greeting"
                )
            }
        )
        BottomNavigationItem(
            selected = true,
            onClick = {navigator.navigate("/midjourney")},
            icon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "MidJourney"
                )
            }
        )
        BottomNavigationItem(
            selected = true,
            onClick = {navigator.navigate("/chat")},
            icon = {
                Icon(
                    imageVector = Icons.Default.AccountBox,
                    contentDescription = "Chat"
                )
            }
        )
    }
}