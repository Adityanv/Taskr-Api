package com.Taskr.TaskrApi.dto;

import com.Taskr.TaskrApi.enums.Priority;

import java.time.LocalDate;

public class TaskRequest {
    private String title;
    private String description;
    private Priority priority;
    private LocalDate createdAt;
    private Integer assigneeId;

    public TaskRequest(String title, String description, Priority priority, LocalDate createdAt, Integer assigneeId) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.createdAt = createdAt;
        this.assigneeId = assigneeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getAssigneeId() {
        return assigneeId;
    }

    public void setAssigneeId(Integer assigneeId) {
        this.assigneeId = assigneeId;
    }
}
