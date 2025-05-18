package com.javaB7.javaB7.service;

import com.javaB7.javaB7.model.domain.Projects;
import com.javaB7.javaB7.model.dto.CreateProject;
import com.javaB7.javaB7.persistence.entity.ProjectEntity;
import com.javaB7.javaB7.persistence.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    public List<Projects> getAllProjects() {
       List<ProjectEntity> projectEntityList = projectRepository.findAll();

       return projectEntityList.stream().map(projectEntity -> {
           Long id = projectEntity.getId();
           String name = projectEntity.getName();
           String description = projectEntity.getDescription();
           return new Projects(id, name, description);
       }).toList();
    }

    public Projects createProject(CreateProject projectRequest) {

        //Request project data
        String projectName = projectRequest.getName();
        String description = projectRequest.getDescription();

        //save to database
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setName(projectName);
        projectEntity.setDescription(description);
        projectRepository.save(projectEntity);

        //Map entity to domain object
        Long projectId = projectEntity.getId();
        String projectEntityName = projectEntity.getName();
        String projectEntityDescription = projectEntity.getDescription();
        return new Projects(projectId, projectEntityName, projectEntityDescription);

    }
}
