package presentation

import data.remote.model.ApiResponse
import domain.MidJourneyFetchImagesUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope

open class MidJourneyViewModel(
    private val fetchUseCase: MidJourneyFetchImagesUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow<ScreenState<ApiResponse>>(ScreenState.Empty)
    val state: StateFlow<ScreenState<ApiResponse>> = _state


    fun fetchDummy(page: Int = 1) {
        _state.value = ScreenState.Loading
        viewModelScope.launch {
            try {
                // Simulate data loading delay
                delay(5000L)
                val data = "Some data"
//                _state.value = ScreenState.Content(data)
            } catch (e: Exception) {
                _state.value = ScreenState.Error
            }
        }
    }


    suspend fun fetchImages(
        page: Int = 1,
    ) {
        fetchUseCase
            .fetchImages(page).onSuccess { items ->
                _state.value = ScreenState.Content(items)
//        if (items.isNotEmpty()) {
//
//        } else {
//            _state.value = ScreenState.Empty
//        }
            }
            .onFailure {
                _state.value = ScreenState.Error
            }
    }

    /*
    fun loadMore() {
        with(_images.value) {
            if (currentPage < totalPages) {
                fetchImages(currentPage + 1)
            }
        }
    }

    fun refreshImages() {
        _images.value = ApiResponse()
        fetchImages()
    }
     */
}