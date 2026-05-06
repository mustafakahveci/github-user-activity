package com.mustafakahvci.githubactivity.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mustafakahvci.githubactivity.client.GitHubApiClient;
import com.mustafakahvci.githubactivity.formatter.EventFormatter;
import com.mustafakahvci.githubactivity.model.GitHubEvent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GitHubActivityService {

    private final GitHubApiClient gitHubApiClient;
    private final ObjectMapper objectMapper;
    private final EventFormatter eventFormatter;

    public GitHubActivityService() {
        this.gitHubApiClient = new GitHubApiClient();
        this.objectMapper = new ObjectMapper();
        this.eventFormatter = new EventFormatter();
    }

    public List<String> getFormattedUserActivities(String username)
            throws IOException, InterruptedException {

        String response = gitHubApiClient.fetchUserEvents(username);

        List<GitHubEvent> events = objectMapper.readValue(
                response,
                new TypeReference<>() {}
        );

        List<String> formattedActivities = new ArrayList<>();

        for (GitHubEvent event : events) {
            formattedActivities.add(eventFormatter.format(event));
        }

        return formattedActivities;
    }
}