package com.mustafakahvci.githubactivity.formatter;

import com.mustafakahvci.githubactivity.model.GitHubEvent;
import com.mustafakahvci.githubactivity.model.Payload;

public class EventFormatter {

    public String format(GitHubEvent event) {
        String repoName = event.getRepo().getName();

        return switch (event.getType()) {
            case "PushEvent" -> formatPushEvent(event, repoName);
            case "CreateEvent" -> formatCreateEvent(event, repoName);
            case "WatchEvent" -> "- Starred " + repoName;
            case "ForkEvent" -> "- Forked " + repoName;
            case "IssuesEvent" -> "- Worked on an issue in " + repoName;
            case "PullRequestEvent" -> "- Worked on a pull request in " + repoName;
            default -> "- " + event.getType() + " in " + repoName;
        };
    }

    private String formatPushEvent(GitHubEvent event, String repoName) {
        Payload payload = event.getPayload();

        if (payload != null) {
            if (payload.getCommits() != null && !payload.getCommits().isEmpty()) {
                int commitCount = payload.getCommits().size();

                if (commitCount == 1) {
                    return "- Pushed 1 commit to " + repoName;
                }

                return "- Pushed " + commitCount + " commits to " + repoName;
            }

            if (payload.getSize() != null && payload.getSize() > 0) {
                int commitCount = payload.getSize();

                if (commitCount == 1) {
                    return "- Pushed 1 commit to " + repoName;
                }

                return "- Pushed " + commitCount + " commits to " + repoName;
            }
        }

        return "- Pushed to " + repoName;
    }


    private String formatCreateEvent(GitHubEvent event, String repoName) {
        Payload payload = event.getPayload();

        if (payload == null) {
            return "- Created something in " + repoName;
        }

        String refType = payload.getRefType() != null ? payload.getRefType() : "item";
        String ref = payload.getRef() != null ? payload.getRef() : "";

        return "- Created " + refType + " " + ref + " in " + repoName;
    }
}