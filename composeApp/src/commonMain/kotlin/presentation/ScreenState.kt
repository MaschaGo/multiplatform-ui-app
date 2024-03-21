package presentation

sealed class ScreenState<out T> {
    object Loading : ScreenState<Nothing>()
    data class Content<T>(val data: T) : ScreenState<T>()
    object Error : ScreenState<Nothing>()
    object Empty : ScreenState<Nothing>()
}