package com.javaB7.javaB7.controller.rest;

import com.javaB7.javaB7.exception.NotFoundException;
import com.javaB7.javaB7.model.domain.Projects;
import com.javaB7.javaB7.model.dto.CreateProject;
import com.javaB7.javaB7.model.dto.UpdateProject;
import com.javaB7.javaB7.service.ProjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    @Operation(summary = "Create a new project")
    public Projects createProject(@RequestBody CreateProject createProject) {
        return projectservice.createProject(createProject);
    }

    @GetMapping("{id}")
    public ResponseEntity<Projects> getProjectById(@PathVariable Long id) {
        Projects projects;
        try{
            projects = projectservice.getProjectById(id);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    return ResponseEntity.ok(projects);
    }

    public void updateProjectById(@PathVariable Long id, @RequestBody UpdateProject updateProject) {
        try{
            projectservice.updateProject(id, updateProject);
        } catch (NotFoundException e){
             ResponseEntity.notFound().build();
        } catch (Exception e) {
             ResponseEntity.internalServerError().build();
        }
    }
}
