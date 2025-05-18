package com.javaB7.javaB7.controller.rest;

import com.javaB7.javaB7.model.domain.Projects;
import com.javaB7.javaB7.model.dto.CreateProject;
import com.javaB7.javaB7.service.ProjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Tag(name = "Project Resource")
@RestController
@RequestMapping("/api/projects")
public class ProjectsRestController {

    @Autowired
    ProjectService projectservice;


    @GetMapping
    @Operation(summary = "Get all Projects")
    public List<Projects> getAllProjects() {
        return projectservice.getAllProjects();
    }

    @PostMapping
    @Operation(summary = "Create project")
    public Projects createProject(@RequestBody CreateProject createProject) {
        return projectservice.createProject(createProject);
    }
}
