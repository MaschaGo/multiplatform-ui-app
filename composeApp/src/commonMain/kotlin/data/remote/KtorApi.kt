package data.remote

import io.ktor.client.request.HttpRequestBuilder
import io.ktor.http.path
import io.ktor.http.takeFrom

abstract class KtorApi {

    /**
     * Use this method for configuring the request url
     */
    fun HttpRequestBuilder.apiUrl(path: String) {
        url {
            takeFrom("https://mj.akgns.com")
            path(path)
        }
    }
}