package com.taskbridge.project.validator;

import com.taskbridge.exception.BusinessException;
import org.springframework.stereotype.Component;

@Component
public class ProjectValidator {

    public void validateProjectId(Long projectId) {
        if (projectId == null || projectId <= 0) {
            throw new BusinessException("Project id must be greater than zero");
        }
    }
}
