package com.mustafakahvci.githubactivity.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubEvent {

    private String type;
    private Repo repo;
    private Payload payload;

    public GitHubEvent() {
    }

    public String getType() {
        return type;
    }

    public Repo getRepo() {
        return repo;
    }

    public Payload getPayload() {
        return payload;
    }
}