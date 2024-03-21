package di

import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

val provideAppModules: Module
    get() = module {
        includes(
            viewModelModule,
            domainModule,
            commonModule, platformModule,
            httpClientModule,
            repositoryModule,
        )
    }

fun initKoin(appDeclaration: KoinAppDeclaration = {}): KoinApplication {
    val koinApplication = startKoin {
        modules(provideAppModules)
        appDeclaration()
    }
    return koinApplication
}

// called by iOS client
fun initKoin() = initKoin {}