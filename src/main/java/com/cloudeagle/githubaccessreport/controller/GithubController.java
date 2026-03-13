package com.cloudeagle.githubaccessreport.controller;

import com.cloudeagle.githubaccessreport.service.GithubService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/github")
public class GithubController {

    private final GithubService githubService;

    public GithubController(GithubService githubService) {
        this.githubService = githubService;
    }

    @GetMapping("/access-report")
    public Map<String, List<String>> getAccessReport(@RequestParam String org) {
        return githubService.generateAccessReport(org);
    }
}