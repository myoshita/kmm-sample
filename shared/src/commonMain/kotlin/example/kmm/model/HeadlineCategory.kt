package example.kmm.model

public enum class HeadlineCategory {
    BUSINESS,
    ENTERTAINMENT,
    GENERAL,
    HEALTH,
    SCIENCE,
    SPORTS,
    TECHNOLOGY,
}

internal val HeadlineCategory.categoryName: String
    get() = when (this) {
        HeadlineCategory.BUSINESS -> "business"
        HeadlineCategory.ENTERTAINMENT -> "entertainment"
        HeadlineCategory.GENERAL -> "general"
        HeadlineCategory.HEALTH -> "health"
        HeadlineCategory.SCIENCE -> "science"
        HeadlineCategory.SPORTS -> "sports"
        HeadlineCategory.TECHNOLOGY -> "technology"
    }
