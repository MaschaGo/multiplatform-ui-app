package di

import Platform
import org.koin.dsl.module

val platformModule = module {
    single<Platform> { get() }
}