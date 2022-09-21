package example.kmm.data.repository

import example.kmm.data.api.FeedApi
import example.kmm.model.Article
import example.kmm.model.HeadlineCategory
import example.kmm.repository.FeedRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

internal class FeedDataRepository(
    private val feedApi: FeedApi,
) : FeedRepository {
    override suspend fun headlines(
        country: String,
        category: HeadlineCategory,
        sources: String
    ): Flow<List<Article>> = callbackFlow {
        send(feedApi.headlines(country, category, sources))
    }
}