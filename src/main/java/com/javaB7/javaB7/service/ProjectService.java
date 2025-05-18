package com.javaB7.javaB7.service;

import com.javaB7.javaB7.exception.NotFoundException;
import com.javaB7.javaB7.model.domain.Projects;
import com.javaB7.javaB7.model.dto.CreateProject;
import com.javaB7.javaB7.model.dto.UpdateProject;
import com.javaB7.javaB7.persistence.entity.ProjectEntity;
import com.javaB7.javaB7.persistence.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Projects getProjectById(Long projectId) throws NotFoundException {
        Optional<ProjectEntity> projectEntityOptional = projectRepository.findById(projectId);
        if (projectEntityOptional.isEmpty()) {
            throw new NotFoundException("Project not found"); // bad practice
        }

        //Query on database
        ProjectEntity projectEntity = projectRepository.findById(projectId).orElse(null);
        assert projectEntity != null;
        Long projectEntityId = projectEntity.getId();
        String projectEntityName = projectEntity.getName();
        String projectEntityDescription = projectEntity.getDescription();

        //Map entity to domain object and return
        return new Projects(projectEntityId, projectEntityName, projectEntityDescription);
    }

    public void updateProject(Long projectId, UpdateProject projectRequest) throws NotFoundException {
        //Request value
        String description = projectRequest.getDescription();

        //Query existing project
        //ProjectEntity projectEntity = projectRepository.findById(projectId).orElse(null);
        Optional<ProjectEntity> projectEntityOptional = projectRepository.findById(projectId);
        if(projectEntityOptional.isEmpty()){
            throw new NotFoundException("Project not found");
        }

        ProjectEntity projectEntity = projectEntityOptional.get();
        projectEntity.setDescription(description);
        projectRepository.save(projectEntity);
    }

    public void deleteProject(Long projectId) throws NotFoundException {

        //QUERY EXISTING PROJECT
        Optional<ProjectEntity> projectEntityOptional = projectRepository.findById(projectId);
        if(projectEntityOptional.isEmpty()){
            throw new NotFoundException("Project not found");
        }

        ProjectEntity projectEntity = projectEntityOptional.get();
        projectRepository.delete(projectEntity);
    }
}
