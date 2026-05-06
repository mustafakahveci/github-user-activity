# GitHub User Activity CLI

A simple Java CLI application that fetches and displays recent public GitHub user activities using the GitHub REST API.

This project was built as part of the roadmap.sh backend projects.

## Features

* Fetch recent public GitHub activity by username
* Display activities in a readable terminal format
* Support for multiple GitHub event types
* Basic error handling for invalid usernames and API responses
* Layered project structure
* JSON parsing with Jackson

## Supported Event Types

* PushEvent
* CreateEvent
* WatchEvent
* ForkEvent
* IssuesEvent
* PullRequestEvent

## Technologies Used

* Java 24
* Maven
* GitHub REST API
* Java HttpClient
* Jackson Databind

## Project Structure

```text
src/main/java/com/mustafakahvci/githubactivity
│
├── Main.java
│
├── client
│   └── GitHubApiClient.java
│
├── service
│   └── GitHubActivityService.java
│
├── formatter
│   └── EventFormatter.java
│
└── model
    ├── GitHubEvent.java
    ├── Repo.java
    ├── Payload.java
    └── Commit.java
```

## How It Works

1. The user provides a GitHub username through the terminal.
2. The application sends an HTTP GET request to the GitHub REST API.
3. The API response is received as JSON.
4. Jackson maps the JSON response into Java model classes.
5. Events are formatted into readable messages.
6. The results are displayed in the terminal.

## API Endpoint

```text
https://api.github.com/users/{username}/events
```

## Installation

Clone the repository:

```bash
git clone https://github.com/your-username/github-user-activity.git
```

Move into the project directory:

```bash
cd github-user-activity
```

Install dependencies and build the project:

```bash
mvn clean install
```

## Example Output

```text
- Pushed to mustafakahveci/mustafakahvci.com
- Created branch main in mustafakahveci/mustafakahvci.com
```

## Error Handling

The application handles:

* Missing username arguments
* Invalid GitHub usernames
* Unexpected GitHub API responses
* HTTP errors

## roadmap.sh Project

Project URL:

```text
https://roadmap.sh/projects/github-user-activity
```
