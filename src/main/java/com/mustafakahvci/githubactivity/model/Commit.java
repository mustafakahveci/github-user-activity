package com.mustafakahvci.githubactivity.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Commit {

    private String message;

    public Commit() {
    }

    public String getMessage() {
        return message;
    }
}