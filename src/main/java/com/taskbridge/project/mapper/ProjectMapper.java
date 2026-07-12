package com.taskbridge.project.mapper;

import com.taskbridge.project.dto.CreateProjectRequest;
import com.taskbridge.project.dto.ProjectResponse;
import com.taskbridge.project.entity.Project;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {

    public Project toEntity(CreateProjectRequest request) {
        return Project.builder()
                .name(request.name())
                .description(request.description())
                .milestoneStatus(request.milestoneStatus())
                .build();
    }

    public ProjectResponse toResponse(Project project) {
        return new ProjectResponse(
                project.getId(),
                project.getName(),
                project.getDescription(),
                project.getMilestoneStatus(),
                project.getCreatedAt(),
                project.getUpdatedAt()
        );
    }
}
