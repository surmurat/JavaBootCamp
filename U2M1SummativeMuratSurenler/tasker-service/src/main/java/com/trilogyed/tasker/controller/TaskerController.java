package com.trilogyed.tasker.controller;

import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.service.TaskerServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RefreshScope
public class TaskerController {

    @Autowired
    TaskerServiceLayer service;

    public TaskerController(TaskerServiceLayer service) {

        this.service = service;
    }

    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.DELETE)
    public void deleteTask(@PathVariable int id) {
        service.deleteTask(id);
    }


    @RequestMapping(value = "/tasks", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public TaskViewModel createTask(@RequestBody @Valid TaskViewModel taskViewModel) {
        service.newTask(taskViewModel);

        return taskViewModel;
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.PUT)
    public void updateTask(@RequestBody TaskViewModel taskViewModel, @PathVariable(name = "id") int id) {

        service.updateTask(taskViewModel);
    }

    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public TaskViewModel getTasks(@PathVariable int id) {
        if (id < 1) {
            throw new IllegalArgumentException("Task id must be greater than 0.");
        }
        return service.fetchTask(id);
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    public List<TaskViewModel> getAllTasks() {

        return service.fetchAllTasks();
    }

    @RequestMapping(value="/tasks/category/{category}", method = RequestMethod.GET)
    public List<TaskViewModel> getTasksByCategory(@PathVariable(name="category") String category) {

        List<TaskViewModel> tasks = service.fetchTasksByCategory(category);

        return tasks;
    }


}
