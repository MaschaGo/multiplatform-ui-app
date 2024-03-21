package data

import data.remote.KtorApi
import data.remote.model.ApiResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class MidJourneyApiService(private val client: HttpClient) : KtorApi() {

    suspend fun getImages(
        page: Int,
    ): ApiResponse = client.get {
        apiUrl("images")
        parameter("page", page)
    }.body()
}