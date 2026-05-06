package com.mustafakahvci.githubactivity;

import com.mustafakahvci.githubactivity.service.GitHubActivityService;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Usage: github-activity <github-username>");
            return;
        }

        String username = args[0];

        GitHubActivityService service = new GitHubActivityService();

        try {
            List<String> activities =
                    service.getFormattedUserActivities(username);

            for (String activity : activities) {
                System.out.println(activity);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}