package com.taskbridge.project.dto;

import com.taskbridge.project.entity.ProjectMilestoneStatus;

import java.time.LocalDateTime;

public record ProjectResponse(
        Long id,
        String name,
        String description,
        ProjectMilestoneStatus milestoneStatus,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
