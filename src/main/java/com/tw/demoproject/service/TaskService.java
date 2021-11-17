package com.tw.demoproject.service;

import com.tw.demoproject.domain.task.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<Task> getTask(Task task);

    void addTask(Task task);

    void updateTask(Task task);

    void deleteTaskById(Integer taskId);
}
