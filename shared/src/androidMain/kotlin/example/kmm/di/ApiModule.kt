package example.kmm.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import example.kmm.data.ApiManager
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal class ApiModule {
    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient {
        return HttpClient(OkHttp) {
        }
    }

    @Provides
    @Singleton
    fun provideApiManager(httpClient: HttpClient): ApiManager {
        return ApiManager(httpClient)
    }
}