package data

import domain.MidJourneyRepository

class MidJourneyRepositoryImpl(
    private val apiService: MidJourneyApiService
) : MidJourneyRepository {

    override suspend fun getImages(page: Int) =
        runCatching {
            apiService.getImages(page)
        }.fold(
            onSuccess = { images ->
                Result.success(
                    images
                )
            },
            onFailure = Result.Companion::failure
        )
}
