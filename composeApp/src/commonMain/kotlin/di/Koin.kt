package di

import org.koin.core.context.startKoin
import org.koin.dsl.module

fun appModule() = module {
    listOf(commonModule, platformModule)
}


fun initKoin() {
    startKoin {
       appModule()
    }
}