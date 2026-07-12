package com.taskbridge.project.dto;

import com.taskbridge.project.entity.ProjectMilestoneStatus;
import jakarta.validation.constraints.NotNull;

public record UpdateProjectMilestoneStatusRequest(
        @NotNull(message = "Milestone status is required")
        ProjectMilestoneStatus milestoneStatus
) {
}
