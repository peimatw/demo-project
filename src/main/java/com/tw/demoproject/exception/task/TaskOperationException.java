package com.tw.demoproject.exception.task;

public class TaskOperationException extends RuntimeException{
    private String taskName;

    public TaskOperationException(String taskName){
        this.taskName = taskName;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
}
