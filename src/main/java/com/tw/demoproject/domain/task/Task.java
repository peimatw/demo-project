package com.tw.demoproject.domain.task;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Task {

    private Integer taskId;

    @NotNull
    private String taskName;

    @Max(3)
    @Min(0)
    private Integer taskType;

    private String createTime;

    private String currentTime;

    @Max(3)
    @Min(0)
    private Integer taskStatus;

    private Integer userId;

    public Task() {
    }

    public Task(Integer taskId, String taskName, Integer taskType, String createTime, String currentTime, Integer taskStatus, Integer userId) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskType = taskType;
        this.createTime = createTime;
        this.currentTime = currentTime;
        this.taskStatus = taskStatus;
        this.userId = userId;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Integer getTaskType() {
        return taskType;
    }

    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public Integer getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
