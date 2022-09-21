package example.kmm.data.api

import example.kmm.BuildKonfig
import example.kmm.data.ApiManager
import example.kmm.model.Article
import example.kmm.model.HeadlineCategory
import example.kmm.model.categoryName

internal class FeedApi(
    private val apiManager: ApiManager,
) {
    suspend fun headlines(
        country: String,
        category: HeadlineCategory,
        sources: String,
    ): List<Article> {
        return apiManager.get(
            url = "${BuildKonfig.apiUrl}/top-headlines",
        ) {
            url {
                parameters.append("country", country)
                parameters.append("category", category.categoryName)
                parameters.append("sources", sources)
                parameters.append("apiKey", BuildKonfig.apiKey)
            }
        }
    }
}