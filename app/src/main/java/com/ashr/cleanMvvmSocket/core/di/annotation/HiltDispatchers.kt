package com.ashr.cleanMvvmSocket.core.di.annotation

import javax.inject.Qualifier

annotation class HiltDispatchers {

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class Main

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class IO

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class Default
}