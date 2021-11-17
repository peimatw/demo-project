package com.tw.demoproject.operation;

import com.tw.demoproject.domain.task.Task;
import com.tw.demoproject.exception.task.TaskNotFoundException;
import com.tw.demoproject.exception.task.TaskOperationException;
import com.tw.demoproject.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class TaskManageService {
    private final TaskService taskService;
    private final AtomicInteger atomicInteger = new AtomicInteger(0);

    public TaskManageService(TaskService taskService) {
        this.taskService = taskService;
    }

    public List<Task> getTasks(Task task){
        List<Task> tasks = taskService.getTask(task);

        return tasks;
    }

    public void addTask(Task task){
        boolean exist = isExist(task.getTaskName());
        if (exist){
            throw new TaskOperationException(task.getTaskName());
        }

        task.setTaskId(atomicInteger.getAndIncrement());
        taskService.addTask(task);
    }

    public void update(Task task){
        boolean exist = isExist(task.getTaskId());
        if (!exist){
            throw new TaskNotFoundException(task.getTaskId());
        }

        taskService.updateTask(task);
    }

    public void deleteTask(Integer taskId){
        boolean exist = isExist(taskId);
        if (!exist){
            throw new TaskNotFoundException(taskId);
        }

        taskService.deleteTaskById(taskId);
    }

    private boolean isExist(Integer taskId){
        boolean exist = false;

        Task task = new Task();
        task.setTaskId(taskId);
        List<Task> tasks = taskService.getTask(task);
        if (tasks.size() > 0){
            exist = true;
        }
        return exist;
    }

    private boolean isExist(String taskName){
        boolean exist = false;

        Task task = new Task();
        task.setTaskName(taskName);
        List<Task> tasks = taskService.getTask(task);
        if (tasks.size() > 0){
            exist = true;
        }
        return exist;
    }
}
