package com.javaB7.javaB7.controller;

import com.javaB7.javaB7.model.domain.Projects;
import com.javaB7.javaB7.model.dto.CreateProject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProjectsRestController {

    List<Projects> projects = new ArrayList<>();

    @GetMapping("/api/project")
    public List<Projects> getAllProjects() {
        return projects;
    }

    @PostMapping("/api/projects")
    public Projects createProject(@RequestBody CreateProject createProject) {
        String name = createProject.getName();
        String description = createProject.getDescription();

        Projects projects1 = new Projects(name, description);
        projects.add(projects1);
        return projects1;
    }
}
