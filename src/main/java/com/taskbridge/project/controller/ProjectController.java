package com.taskbridge.project.controller;

import com.taskbridge.common.api.ApiResponse;
import com.taskbridge.common.api.ApiResponseBuilder;
import com.taskbridge.project.dto.CreateProjectRequest;
import com.taskbridge.project.dto.ProjectResponse;
import com.taskbridge.project.dto.UpdateProjectMilestoneStatusRequest;
import com.taskbridge.project.service.ProjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping
    public ResponseEntity<ApiResponse<ProjectResponse>> createProject(@Valid @RequestBody CreateProjectRequest request) {
        ProjectResponse response = projectService.createProject(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponseBuilder.success(HttpStatus.CREATED, "Project created successfully", response));
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<ApiResponse<ProjectResponse>> getProjectById(@PathVariable Long projectId) {
        ProjectResponse response = projectService.getProjectById(projectId);
        return ResponseEntity.ok(ApiResponseBuilder.success(HttpStatus.OK, "Project retrieved successfully", response));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<ProjectResponse>>> getAllProjects() {
        List<ProjectResponse> response = projectService.getAllProjects();
        return ResponseEntity.ok(ApiResponseBuilder.success(HttpStatus.OK, "Projects retrieved successfully", response));
    }

    @PatchMapping("/{projectId}/milestone-status")
    public ResponseEntity<ApiResponse<ProjectResponse>> updateProjectMilestoneStatus(
            @PathVariable Long projectId,
            @Valid @RequestBody UpdateProjectMilestoneStatusRequest request) {
        ProjectResponse response = projectService.updateProjectMilestoneStatus(projectId, request);
        return ResponseEntity.ok(ApiResponseBuilder.success(HttpStatus.OK, "Project milestone status updated successfully", response));
    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long projectId) {
        projectService.deleteProject(projectId);
        return ResponseEntity.noContent().build();
    }
}
