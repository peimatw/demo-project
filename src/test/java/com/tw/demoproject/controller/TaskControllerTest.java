package com.tw.demoproject.controller;

import com.tw.demoproject.domain.task.Task;
import com.tw.demoproject.operation.TaskManageService;
import com.tw.demoproject.service.TaskService;
import com.tw.demoproject.service.impl.TaskServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class TaskControllerTest {
    private TaskController taskController;
    private TaskManageService taskManageService;
    private TaskService taskService;

    @BeforeEach
    public void setUp(){
        this.taskService = new TaskServiceImpl();
        this.taskManageService = new TaskManageService(taskService);
        this.taskController = new TaskController(taskManageService);
    }


}
