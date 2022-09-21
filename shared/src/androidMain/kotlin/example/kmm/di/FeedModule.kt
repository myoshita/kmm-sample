package example.kmm.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import example.kmm.data.ApiManager
import example.kmm.data.api.FeedApi
import example.kmm.data.repository.FeedDataRepository
import example.kmm.repository.FeedRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal class FeedModule {
    @Provides
    @Singleton
    fun provideFeedRepository(feedApi: FeedApi): FeedRepository = FeedDataRepository(feedApi)

    @Provides
    @Singleton
    fun provideFeedApi(apiManager: ApiManager): FeedApi = FeedApi(apiManager)
}
