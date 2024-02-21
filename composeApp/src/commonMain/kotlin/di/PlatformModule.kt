package di

import Platform
import getPlatform
import org.koin.dsl.module

val platformModule = module {
//    singleOf(::Platform)
    single<Platform> { getPlatform() }
}