package com.javaB7.javaB7.service;

import com.javaB7.javaB7.model.domain.Projects;
import com.javaB7.javaB7.model.dto.CreateProject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {
    List<Projects> projects = new ArrayList<>();

    public List<Projects> getAllProjects() {
        return projects;
    }

    public Projects createProject(CreateProject projectRequest) {

        String projectName = projectRequest.getName();
        String description = projectRequest.getDescription();

        Projects project = new Projects(projectName, description);
        projects.add(project);
        return project;
    }
}
