package di

import data.MidJourneyApiService
import data.MidJourneyRepositoryImpl
import domain.MidJourneyRepository
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val httpClientModule = module {
    single<HttpClient> {
        val jsonConfiguration = Json {
            prettyPrint = true
            ignoreUnknownKeys = true
            useAlternativeNames = false
        }
        HttpClient {
            install(ContentNegotiation) {
                // TODO Fix API so it serves application/json
                json(json = jsonConfiguration, contentType = ContentType.Any)
            }
            install(Logging) {
                logger = Logger.SIMPLE
                level = LogLevel.ALL
            }
        }
    }
    single {
        val httpClient: HttpClient = get()
        MidJourneyApiService(httpClient)
    }
}

val repositoryModule = module {
    single<MidJourneyRepository> {
        MidJourneyRepositoryImpl(get())
    }
}