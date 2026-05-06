package com.mustafakahvci.githubactivity.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Payload {

    private String ref;

    @JsonProperty("ref_type")
    private String refType;

    private Integer size;

    private List<Commit> commits;

    public Payload() {
    }

    public String getRef() {
        return ref;
    }

    public String getRefType() {
        return refType;
    }

    public Integer getSize() {
        return size;
    }

    public List<Commit> getCommits() {
        return commits;
    }
}