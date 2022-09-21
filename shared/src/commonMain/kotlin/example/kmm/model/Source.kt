package example.kmm.model

import kotlinx.serialization.Serializable

@Serializable
public data class Source(
    val id: String,
    val name: String,
)