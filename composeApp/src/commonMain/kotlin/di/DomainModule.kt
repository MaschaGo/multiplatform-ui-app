package di

import domain.MidJourneyFetchImagesUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { MidJourneyFetchImagesUseCase(get()) }
}