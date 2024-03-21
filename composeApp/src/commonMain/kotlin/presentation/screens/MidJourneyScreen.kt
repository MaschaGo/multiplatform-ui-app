package presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import data.remote.model.ApiResponse
import presentation.MidJourneyViewModel
import presentation.ScreenState


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MidJourneyScreen(viewModel: MidJourneyViewModel) {

    val state by viewModel.state.collectAsState()

    LaunchedEffect(true) {
        viewModel.fetchImages()
    }

//    val isRefreshing = remember {
//        derivedStateOf {
//            state ==
//        }
//    }
//    val pullRefreshState = rememberPullRefreshState(isRefreshing.value, onRefresh)

    Column(
        Modifier.fillMaxWidth()
            .padding(24.dp)
//            .pullRefresh(state = pullRefreshState)
        ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var textToShow = ""
        textToShow = when (state) {
            is ScreenState.Loading -> "Here will be MidJourney" //ToDo: showLoading()
            is ScreenState.Content -> (state as ScreenState.Content<ApiResponse>)
                .data.totalImages.toString() //ToDo: showContent(state.data) as Grid or List
            is ScreenState.Error -> "Error" //ToDo: showError()
            is ScreenState.Empty -> "Empty" //ToDo: showEmpty()
        }

        Text(textToShow)
    }
}