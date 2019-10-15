package com.ebbinghaus.controller;

import com.ebbinghaus.service.TaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "任务", tags = "task")
@RequestMapping(value = "/task")
public class TaskController {
    @Autowired
    private TaskService service;

    @ApiOperation(value = "添加任务", notes = "", httpMethod = "GET")
    @GetMapping("/{task}")
    public String processTask(@PathVariable String task) {
        return service.acceptTask(task);
    }
    @ApiOperation(value = "查询某天任务", notes = "", httpMethod = "GET")
    @GetMapping("/day/{day}")
    public String findTaskByDate(@PathVariable String day) {
        return service.findTaskByDate(day);
    }
}
