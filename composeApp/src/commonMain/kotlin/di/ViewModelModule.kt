package di

import org.koin.dsl.module
import presentation.MidJourneyViewModel

val viewModelModule = module {
    factory { MidJourneyViewModel(get()) }
}