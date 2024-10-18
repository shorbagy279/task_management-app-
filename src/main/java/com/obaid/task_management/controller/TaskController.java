package com.obaid.task_management.controller;

import com.obaid.task_management.entity.Task;
import com.obaid.task_management.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")

public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task>getAllTasks()
    {
        return taskService.readAll();
    }

    @GetMapping("/{id}")
    public Task getById(@PathVariable Integer id)
    {
        return taskService.readById(id);
    }


}
