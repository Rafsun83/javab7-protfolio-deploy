package com.javaB7.javaB7.controller.rest;

import com.javaB7.javaB7.model.domain.Projects;
import com.javaB7.javaB7.model.dto.CreateProject;
import com.javaB7.javaB7.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProjectsRestController {

    @Autowired
    ProjectService projectservice;

    @GetMapping("/api/projects")
    public List<Projects> getAllProjects() {
        return projectservice.getAllProjects();
    }

    @PostMapping("/api/projects")
    public Projects createProject(@RequestBody CreateProject createProject) {
        return projectservice.createProject(createProject);
    }
}
