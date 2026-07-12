package com.taskbridge.project.service;

import com.taskbridge.exception.ResourceNotFoundException;
import com.taskbridge.project.dto.CreateProjectRequest;
import com.taskbridge.project.dto.ProjectResponse;
import com.taskbridge.project.dto.UpdateProjectMilestoneStatusRequest;
import com.taskbridge.project.entity.Project;
import com.taskbridge.project.mapper.ProjectMapper;
import com.taskbridge.project.repository.ProjectRepository;
import com.taskbridge.project.validator.ProjectValidator;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private static final Logger log = LoggerFactory.getLogger(ProjectService.class);

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;
    private final ProjectValidator projectValidator;

    @Transactional
    public ProjectResponse createProject(CreateProjectRequest request) {
        Project project = projectMapper.toEntity(request);
        Project savedProject = projectRepository.save(project);
        ProjectResponse response = projectMapper.toResponse(savedProject);
        log.info("Created project with id: {}", savedProject.getId());
        return response;
    }
    
    @Transactional(readOnly = true)
    public ProjectResponse getProjectById(Long projectId) {
        projectValidator.validateProjectId(projectId);
        Project project = findProjectById(projectId);
        ProjectResponse response = projectMapper.toResponse(project);
        log.info("Fetched project with id: {}", projectId);
        return response;
    }

    @Transactional(readOnly = true)
    public List<ProjectResponse> getAllProjects() {
        List<ProjectResponse> response = projectRepository.findAll().stream()
                .map(projectMapper::toResponse)
                .toList();
        log.info("Fetched {} projects", response.size());
        return response;
    }

    @Transactional
    public ProjectResponse updateProjectMilestoneStatus(Long projectId, UpdateProjectMilestoneStatusRequest request) {
        projectValidator.validateProjectId(projectId);
        Project project = findProjectById(projectId);
        project.setMilestoneStatus(request.milestoneStatus());
        Project updatedProject = projectRepository.save(project);
        ProjectResponse response = projectMapper.toResponse(updatedProject);
        log.info("Updated milestone status for project id: {}", projectId);
        return response;
    }

    @Transactional
    public void deleteProject(Long projectId) {
        projectValidator.validateProjectId(projectId);
        Project project = findProjectById(projectId);
        projectRepository.delete(project);
        log.info("Deleted project with id: {}", projectId);
    }

    private Project findProjectById(Long projectId) {
        return projectRepository.findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found with id: " + projectId));
    }
}
