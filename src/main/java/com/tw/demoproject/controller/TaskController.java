package com.tw.demoproject.controller;

import com.tw.demoproject.constant.ErrorType;
import com.tw.demoproject.domain.task.Task;
import com.tw.demoproject.domain.error.CommonError;
import com.tw.demoproject.exception.task.TaskNotFoundException;
import com.tw.demoproject.exception.task.TaskOperationException;
import com.tw.demoproject.operation.TaskManageService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskManageService taskManageService;

    public TaskController(TaskManageService taskManageService) {
        this.taskManageService = taskManageService;
    }

    @GetMapping("/read")
    public List<Task> getTasks(@RequestParam(value = "taskId", required = false) Integer taskId,
                               @RequestParam(value = "taskName", required = false) String taskName,
                               @RequestParam(value = "taskType", required = false) Integer taskType,
                               @RequestParam(value = "startTime", required = false) String startTime,
                               @RequestParam(value = "endTime", required = false) String currentTime,
                               @RequestParam(value = "taskStatus", required = false) Integer taskStatus,
                               @RequestParam(value = "userId", required = false) Integer userId){
        Task task = new Task(taskId, taskName, taskType, startTime, currentTime, taskStatus, userId);
        return taskManageService.getTasks(task);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addTask(@Valid @RequestBody Task task){
        taskManageService.addTask(task);
    }

    @PostMapping("/update/{taskId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTask(@PathVariable Integer taskId, @RequestBody Task task){
        task.setTaskId(taskId);
        taskManageService.update(task);
    }

    @PostMapping("/delete/{taskId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable Integer taskId){
        taskManageService.deleteTask(taskId);
    }

    @ExceptionHandler(TaskNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public CommonError taskNotFound(TaskNotFoundException e){
        return new CommonError(ErrorType.TASK_NOT_FOUND.getErrorCode(), "The task with ID " + e.getTaskId()
                + " was not found!");
    }

    @ExceptionHandler(TaskOperationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public CommonError TaskOperationError(TaskOperationException e){
        return new CommonError(ErrorType.TASK_OPERATION_ERROR.getErrorCode(), "The task named '"
                + e.getTaskName() + "' already exist!");
    }
}
