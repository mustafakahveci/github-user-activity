package com.mustafakahvci.githubactivity.client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GitHubApiClient {

    private static final String BASE_URL =
            "https://api.github.com/users/";

    private final HttpClient httpClient;

    public GitHubApiClient() {
        this.httpClient = HttpClient.newHttpClient();
    }

    public String fetchUserEvents(String username)
            throws IOException, InterruptedException {

        String url = BASE_URL + username + "/events";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Accept", "application/vnd.github+json")
                .GET()
                .build();

        HttpResponse<String> response =
                httpClient.send(
                        request,
                        HttpResponse.BodyHandlers.ofString()
                );

        if (response.statusCode() == 404) {
            throw new RuntimeException(
                    "GitHub user not found: " + username
            );
        }

        if (response.statusCode() != 200) {
            throw new RuntimeException(
                    "GitHub API error. Status code: "
                            + response.statusCode()
            );
        }

        return response.body();
    }
}