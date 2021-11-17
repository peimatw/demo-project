package com.tw.demoproject.exception.task;

public class TaskNotFoundException extends RuntimeException{
    private Integer taskId;

    public TaskNotFoundException(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getTaskId() {
        return taskId;
    }
}
