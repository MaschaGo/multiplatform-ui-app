package domain

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext

class MidJourneyFetchImagesUseCase(
    private val repo: MidJourneyRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    suspend  fun fetchImages(page :Int) = withContext(dispatcher) {
        repo.getImages(page)
    }

 // ToDo: map result
//    fun getImages(page: Int): Flow<ApiResponse> =
//        repo
//            .getImages(page = page)
//            .map(mapper::mapMjImages)

    //suspend operator fun invoke() = withContext(dispatcher) {}

}