package template.Providers

import java.net.HttpURLConnection
import java.net.URI
import java.net.URL
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class PostProvider {
    fun sendGet(): String {
        val url = URL("https://jsonplaceholder.typicode.com/posts")
        val client = HttpClient.newBuilder().build();
        val request = HttpRequest.newBuilder()
            .uri(URI.create("https://jsonplaceholder.typicode.com/posts"))
            .build();

        val response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();

    }
}