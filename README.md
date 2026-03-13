# GitHub Access Report API

This project is a **Spring Boot REST API** that retrieves repositories from a GitHub organization and lists the collaborators who have access to them.

## Tech Stack

* Java 17
* Spring Boot
* Maven
* GitHub REST API

## Setup

### 1. Clone the repository

git clone https://github.com/YashSK45/test-api-repo.git

### 2. Add your GitHub Personal Access Token in `application.properties`

github.token=YOUR_GITHUB_TOKEN

### 3. Run the application

mvnw spring-boot:run

## API Endpoint

GET /api/github/access-report?org={organization}

Example:

http://localhost:8080/api/github/access-report?org=microsoft

## Output Example

{
"user1": ["repo1","repo2"],
"user2": ["repo3"]
}
