package domain

import data.remote.model.ApiResponse

interface MidJourneyRepository {

    suspend fun getImages(page: Int): Result<ApiResponse>
}