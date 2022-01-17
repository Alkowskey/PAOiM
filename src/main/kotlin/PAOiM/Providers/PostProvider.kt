package PAOiM.Providers

import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class PostProvider {
    fun sendGet(): String {
        val client = HttpClient.newBuilder().build();
        val request = HttpRequest.newBuilder()
            .uri(URI.create("https://jsonplaceholder.typicode.com/posts"))
            .build();

        val response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();

    }
}