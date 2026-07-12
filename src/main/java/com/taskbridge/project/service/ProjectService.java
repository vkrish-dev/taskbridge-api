package com.taskbridge.project.service;

import com.taskbridge.exception.BusinessException;
import com.taskbridge.exception.ResourceNotFoundException;
import com.taskbridge.project.dto.CreateProjectRequest;
import com.taskbridge.project.dto.ProjectResponse;
import com.taskbridge.project.dto.UpdateProjectMilestoneStatusRequest;
import com.taskbridge.project.entity.Project;
import com.taskbridge.project.mapper.ProjectMapper;
import com.taskbridge.project.repository.ProjectRepository;
import com.taskbridge.project.validator.ProjectValidator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;
    private final ProjectValidator projectValidator;

    @Transactional
    public ProjectResponse createProject(CreateProjectRequest request) {
        Project project = projectMapper.toEntity(request);
        Project savedProject = projectRepository.save(project);
        return projectMapper.toResponse(savedProject);
    }

    public ProjectResponse getProjectById(Long projectId) {
        projectValidator.validateProjectId(projectId);
        Project project = findProjectById(projectId);
        return projectMapper.toResponse(project);
    }

    public List<ProjectResponse> getAllProjects() {
        return projectRepository.findAll().stream()
                .map(projectMapper::toResponse)
                .toList();
    }

    @Transactional
    public ProjectResponse updateProjectMilestoneStatus(Long projectId, UpdateProjectMilestoneStatusRequest request) {
        projectValidator.validateProjectId(projectId);
        Project project = findProjectById(projectId);
        project.setMilestoneStatus(request.milestoneStatus());
        Project updatedProject = projectRepository.save(project);
        return projectMapper.toResponse(updatedProject);
    }

    @Transactional
    public void deleteProject(Long projectId) {
        projectValidator.validateProjectId(projectId);
        Project project = findProjectById(projectId);
        projectRepository.delete(project);
    }

    private Project findProjectById(Long projectId) {
        return projectRepository.findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found with id: " + projectId));
    }
}
