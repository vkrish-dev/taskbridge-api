package com.taskbridge.project.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.taskbridge.project.dto.CreateProjectRequest;
import com.taskbridge.project.dto.UpdateProjectMilestoneStatusRequest;
import com.taskbridge.project.entity.ProjectMilestoneStatus;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProjectControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @Order(1)
    void shouldCreateAndFetchProject() throws Exception {
        CreateProjectRequest request = new CreateProjectRequest(
                "TaskBridge Platform",
                "Core collaboration project",
                ProjectMilestoneStatus.INITIATED
        );

        mockMvc.perform(post("/api/projects")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.status", is("CREATED")))
                .andExpect(jsonPath("$.message", is("Project created successfully")))
                .andExpect(jsonPath("$.data.name", is("TaskBridge Platform")))
                .andExpect(jsonPath("$.data.milestoneStatus", is("INITIATED")));

        mockMvc.perform(get("/api/projects"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data", hasSize(1)));
    }

    @Test
    @Order(2)
    void shouldUpdateProjectMilestoneStatusAndDeleteProject() throws Exception {
        UpdateProjectMilestoneStatusRequest request = new UpdateProjectMilestoneStatusRequest(
                ProjectMilestoneStatus.IN_PROGRESS
        );

        mockMvc.perform(patch("/api/projects/1/milestone-status")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status", is("OK")))
                .andExpect(jsonPath("$.data.milestoneStatus", is("IN_PROGRESS")));

        mockMvc.perform(delete("/api/projects/1"))
                .andExpect(status().isNoContent());

        mockMvc.perform(get("/api/projects/1"))
                .andExpect(status().isNotFound());
    }
}
