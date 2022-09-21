package example.kmm.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get

internal class ApiManager(private val httpClient: HttpClient) {
    suspend inline fun <reified T : Any> get(
        url: String,
        block: HttpRequestBuilder.() -> Unit = {},
    ): T = try {
        httpClient.get(url, block)
            .body()
    } catch (e: Exception) {
        throw e // TODO Map to app error
    }
}
