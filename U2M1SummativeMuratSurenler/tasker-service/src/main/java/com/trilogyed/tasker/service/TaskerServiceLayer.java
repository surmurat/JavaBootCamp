package com.trilogyed.tasker.service;

import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskerServiceLayer {

    @Autowired
    private DiscoveryClient discoveryClient;

    private RestTemplate restTemplate = new RestTemplate();

    @Value("${adServerServiceName}")
    private String adServerServiceName;

    @Value("${serviceProtocol}")
    private String serviceProtocol;

    @Value("${servicePath}")
    private String servicePath;

    TaskerDao dao;

    @Autowired
    public TaskerServiceLayer(TaskerDao dao) {
        this.dao = dao;
    }

    public TaskerServiceLayer(DiscoveryClient discoveryClient, RestTemplate restTemplate, String adServerServiceName, String serviceProtocol, String servicePath, TaskerDao dao) {
        this.discoveryClient = discoveryClient;
        this.restTemplate = restTemplate;
        this.adServerServiceName = adServerServiceName;
        this.serviceProtocol = serviceProtocol;
        this.servicePath = servicePath;
        this.dao = dao;
    }

    public String getAd(){

        List<ServiceInstance> instances = discoveryClient.getInstances(adServerServiceName);

        String adServerServiceNameUri = serviceProtocol + instances.get(0).getHost() + ":" + instances.get(0).getPort() + servicePath;

        String ad = restTemplate.getForObject(adServerServiceNameUri, String.class);

        return ad;
    }

    public TaskViewModel fetchTask(int id) {

        Task task = dao.getTask(id);
        TaskViewModel tvm = new TaskViewModel();

        tvm.setId(task.getId());
        tvm.setDescription(task.getDescription());
        tvm.setCreateDate(task.getCreateDate());
        tvm.setDueDate(task.getDueDate());
        tvm.setCategory(task.getCategory());

        // TODO - get ad from Adserver and put in tvm
        tvm.setAdvertisement(getAd());
        return tvm;
    }

    public List<TaskViewModel> fetchAllTasks() {

        List<Task> taskList = dao.getAllTasks();
        List<TaskViewModel> taskViewModelList = new ArrayList<>();

        taskList.stream()
                .forEach(task -> {
                    TaskViewModel tvm = buildTaskViewModel(task);
                    taskViewModelList.add(tvm);
                });

        return taskViewModelList;
    }

    public List<TaskViewModel> fetchTasksByCategory(String category) {
        List<Task> taskList = dao.getTasksByCategory(category);
        List<TaskViewModel> taskViewModelList = new ArrayList<>();

        taskList.stream()
                .forEach(task -> {
                    TaskViewModel tvm = buildTaskViewModel(task);
                    taskViewModelList.add(tvm);
                });
        return taskViewModelList;
    }

    public TaskViewModel newTask(TaskViewModel taskViewModel) {

        Task task = new Task();
        task.setDescription(taskViewModel.getDescription());
        task.setCreateDate(taskViewModel.getCreateDate());
        task.setDueDate(taskViewModel.getDueDate());
        task.setCategory(taskViewModel.getCategory());

        task = dao.createTask(task);
        taskViewModel.setId(task.getId());

        // TODO - get ad from Adserver and put in taskViewModel
        taskViewModel.setAdvertisement(getAd());
        return taskViewModel;
    }

    public void deleteTask(int id) {
        dao.deleteTask(id);

    }

    public void updateTask(TaskViewModel taskViewModel) {

        Task task = new Task();
        task.setCategory(taskViewModel.getCategory());
        task.setDueDate(taskViewModel.getDueDate());
        task.setCreateDate(taskViewModel.getCreateDate());
        task.setDescription(taskViewModel.getDescription());
        task.setId(taskViewModel.getId());

        dao.updateTask(task);

    }

    private TaskViewModel buildTaskViewModel(Task task){
        TaskViewModel taskViewModel = new TaskViewModel();

        taskViewModel.setId(task.getId());
        taskViewModel.setDescription(task.getDescription());
        taskViewModel.setCreateDate(task.getCreateDate());
        taskViewModel.setDueDate(task.getDueDate());
        taskViewModel.setCategory(task.getCategory());
        taskViewModel.setAdvertisement(getAd());

        return taskViewModel;
    }

}
