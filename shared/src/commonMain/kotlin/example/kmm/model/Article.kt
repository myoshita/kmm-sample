package example.kmm.model

import kotlinx.serialization.Serializable

@Serializable
public data class Article(
    val source: Source,
    val author: String?,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String?,
    val publishedAt: String,
    val content: String?,
    val isFavorite: Boolean,
)
