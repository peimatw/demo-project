package com.tw.demoproject.service.impl;

import com.tw.demoproject.constant.TaskStatus;
import com.tw.demoproject.domain.task.*;
import com.tw.demoproject.service.TaskService;
import com.tw.demoproject.util.CommonUtils;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    private final Map<Integer, Task> tasks = new HashMap<>();

    @Override
    public List<Task> getTask(Task task) {
        Map<Integer, Task> map = tasks.entrySet().stream()
                .filter(e -> {
                    if (task.getTaskId() != null) {
                        return e.getValue().getTaskId().equals(task.getTaskId());
                    } else {
                        return true;
                    }
                })
                .filter(e -> {
                    if (task.getTaskName() != null) {
                        return e.getValue().getTaskName().equals(task.getTaskName());
                    } else {
                        return true;
                    }
                })
                .filter(e -> {
                    if (task.getTaskType() != null) {
                        return e.getValue().getTaskType().equals(task.getTaskType());
                    } else {
                        return true;
                    }
                })
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));

        return new ArrayList<>(map.values());
    }

    @Override
    public void addTask(Task task) {
        tasks.put(task.getTaskId(), task);
    }

    @Override
    public void updateTask(Task task) {
        Task oldTask = tasks.get(task.getTaskId());
        if (TaskStatus.NEW.equals(oldTask.getTaskType())){
            oldTask.setTaskName(task.getTaskName());
            oldTask.setCurrentTime(CommonUtils.getCurrentTime());
        }
        else {
            oldTask.setTaskStatus(oldTask.getTaskType());
            oldTask.setCurrentTime(CommonUtils.getCurrentTime());
            oldTask.setUserId(task.getUserId());
        }
    }

    @Override
    public void deleteTaskById(Integer taskId) {
        tasks.remove(taskId);
    }
}
