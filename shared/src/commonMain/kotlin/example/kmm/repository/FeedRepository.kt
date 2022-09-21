package example.kmm.repository

import example.kmm.model.Article
import example.kmm.model.HeadlineCategory
import kotlinx.coroutines.flow.Flow

public interface FeedRepository {
    public suspend fun headlines(
        country: String,
        category: HeadlineCategory,
        sources: String,
    ): Flow<List<Article>>
}
