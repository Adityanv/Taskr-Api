package com.Taskr.TaskrApi.dto;

public class TaskResponse {
    private Integer ownerId;
    private String ownerName;
    private Integer assigneeId;
    private String assigneeName;

    public TaskResponse(Integer ownerId, String ownerName, Integer assigneeId, String assigneeName) {
        this.ownerId = ownerId;
        this.ownerName = ownerName;
        this.assigneeId = assigneeId;
        this.assigneeName = assigneeName;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Integer getAssigneeId() {
        return assigneeId;
    }

    public void setAssigneeId(Integer assigneeId) {
        this.assigneeId = assigneeId;
    }

    public String getAssigneeName() {
        return assigneeName;
    }

    public void setAssigneeName(String assigneeName) {
        this.assigneeName = assigneeName;
    }
}
