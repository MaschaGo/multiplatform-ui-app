package di

import Greeting
import org.koin.dsl.module

val commonModule = module {
    single { Greeting(get()) }
}