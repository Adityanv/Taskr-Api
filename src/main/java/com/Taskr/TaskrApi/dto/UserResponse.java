package com.Taskr.TaskrApi.dto;

import com.Taskr.TaskrApi.enums.Role;

import java.time.LocalDate;

public class UserResponse {
    private Integer id;
    private String name;
    private String email;
    private Role role;
    private Integer taskCount;
    private LocalDate createdAt;

    public UserResponse(Integer id, String name, String email, Role role, Integer taskCount, LocalDate createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
        this.taskCount = taskCount;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Integer getTaskCount() {
        return taskCount;
    }

    public void setTaskCount(Integer taskCount) {
        this.taskCount = taskCount;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}
