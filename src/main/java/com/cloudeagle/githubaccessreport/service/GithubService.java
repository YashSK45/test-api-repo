package com.cloudeagle.githubaccessreport.service;

import com.cloudeagle.githubaccessreport.client.GithubClient;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GithubService {

    private final GithubClient githubClient;

    public GithubService(GithubClient githubClient) {
        this.githubClient = githubClient;
    }

    public Map<String, List<String>> generateAccessReport(String org) {

        Map<String, List<String>> userRepoMap = new HashMap<>();

        String repoUrl = "https://api.github.com/orgs/" + org + "/repos";
        String repoResponse = githubClient.getData(repoUrl);

        JSONArray repos = new JSONArray(repoResponse);

        for (int i = 0; i < repos.length(); i++) {

            JSONObject repo = repos.getJSONObject(i);
            String repoName = repo.getString("name");

            String collabUrl =
                    "https://api.github.com/repos/" + org + "/" + repoName + "/collaborators";

            String collabResponse = githubClient.getData(collabUrl);

            JSONArray collaborators = new JSONArray(collabResponse);

            for (int j = 0; j < collaborators.length(); j++) {

                JSONObject user = collaborators.getJSONObject(j);
                String username = user.getString("login");

                userRepoMap
                        .computeIfAbsent(username, k -> new ArrayList<>())
                        .add(repoName);
            }
        }

        return userRepoMap;
    }
}