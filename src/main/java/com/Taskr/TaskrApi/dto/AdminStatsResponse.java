package com.Taskr.TaskrApi.dto;

public class AdminStatsResponse {
    private Integer totalUsers;
    private Integer totalTasks;
    private Integer inProgress;
    private Integer overdueTasks;

    public AdminStatsResponse(Integer totalUsers, Integer totalTasks, Integer inProgress, Integer overdueTasks) {
        this.totalUsers = totalUsers;
        this.totalTasks = totalTasks;
        this.inProgress = inProgress;
        this.overdueTasks = overdueTasks;
    }

    public Integer getTotalUsers() {
        return totalUsers;
    }

    public void setTotalUsers(Integer totalUsers) {
        this.totalUsers = totalUsers;
    }

    public Integer getTotalTasks() {
        return totalTasks;
    }

    public void setTotalTasks(Integer totalTasks) {
        this.totalTasks = totalTasks;
    }

    public Integer getInProgress() {
        return inProgress;
    }

    public void setInProgress(Integer inProgress) {
        this.inProgress = inProgress;
    }

    public Integer getOverdueTasks() {
        return overdueTasks;
    }

    public void setOverdueTasks(Integer overdueTasks) {
        this.overdueTasks = overdueTasks;
    }
}
