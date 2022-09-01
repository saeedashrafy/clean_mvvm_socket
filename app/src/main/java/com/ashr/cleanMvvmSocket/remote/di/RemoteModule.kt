package com.ashr.cleanMvvmSocket.remote.di

import android.content.Context
import com.ashr.cleanMvvmSocket.MyApplication
import com.ashr.cleanMvvmSocket.data.datasource.remote.TickerRemoteDataSource
import com.ashr.cleanMvvmSocket.remote.mapper.TickerEntityMapper
import com.ashr.cleanMvvmSocket.remote.socket.CoinbaseService
import com.ashr.cleanMvvmSocket.remote.socket.FlowStreamAdapter
import com.ashr.cleanMvvmSocket.remote.source.CoinRemoteDataSourceImpl
import com.squareup.moshi.Moshi
import com.tinder.scarlet.Scarlet
import com.tinder.scarlet.lifecycle.android.BuildConfig
import com.tinder.scarlet.messageadapter.moshi.MoshiMessageAdapter
import com.tinder.scarlet.websocket.okhttp.newWebSocketFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RemoteModule {

    @Provides
    @Singleton
    fun provideScarlet(application: MyApplication, client: OkHttpClient, moshi: Moshi): Scarlet {
        return Scarlet.Builder()
            .webSocketFactory(client.newWebSocketFactory(BASE_URL))
            .addMessageAdapterFactory(MoshiMessageAdapter.Factory(moshi))
            .addStreamAdapterFactory(FlowStreamAdapter.Factory())
            //.lifecycle(AndroidLifecycle.ofApplicationForeground(application))
            //.backoffStrategy(LinearBackoffStrategy(1000L))
            .build()
    }


    /**
     * Provide context as CryptoApp
     */
    @Provides
    @Singleton
    fun providesApplication(@ApplicationContext context: Context): MyApplication {
        return context as MyApplication
    }


    /**
     * Moshi for json serialization
     */
    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .build()
    }


    /**
     * Okhttp
     */
    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        val logger = HttpLoggingInterceptor()
            .setLevel(
                if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BASIC
                else HttpLoggingInterceptor.Level.NONE
            )

        return OkHttpClient.Builder()
            .addInterceptor(logger)
            .build()
    }

    @Provides
    @Singleton
    fun provideCoinbaseService(scarlet: Scarlet): CoinbaseService {
        return scarlet.create()
    }


    @Provides
    fun provideTickerEntityMapper(): TickerEntityMapper = TickerEntityMapper()

    @Provides
    @Singleton
    fun provideCoinRemoteDataSource(
        coinbaseService: CoinbaseService,
        tickerEntityMapper: TickerEntityMapper
    ): TickerRemoteDataSource =
        CoinRemoteDataSourceImpl(coinbaseService, tickerEntityMapper)

    companion object {

        const val BASE_URL = "wss://ws-feed.pro.coinbase.com/"
    }
}