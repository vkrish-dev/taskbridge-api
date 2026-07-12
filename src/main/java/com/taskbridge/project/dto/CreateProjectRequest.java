package com.taskbridge.project.dto;

import com.taskbridge.project.entity.ProjectMilestoneStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateProjectRequest(
        @NotBlank(message = "Project name is required")
        @Size(max = 100, message = "Project name must be at most 100 characters")
        String name,

        @Size(max = 500, message = "Project description must be at most 500 characters")
        String description,

        @NotNull(message = "Project milestone status is required")
        ProjectMilestoneStatus milestoneStatus
) {
}
