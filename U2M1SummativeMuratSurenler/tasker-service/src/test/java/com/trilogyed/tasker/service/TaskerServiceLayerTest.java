package com.trilogyed.tasker.service;

import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.dao.TaskerDaoJdbcTemplateImpl;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.DefaultServiceInstance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;


public class TaskerServiceLayerTest {

    @Autowired
    private DiscoveryClient discoveryClient;

    private RestTemplate restTemplate ;

    @Value("${adServerServiceName}")
    private String adServerServiceName;

    @Value("${serviceProtocol}")
    private String serviceProtocol;

    @Value("${servicePath}")
    private String servicePath;


    private TaskerDao taskerDao;
    private TaskerServiceLayer taskerServiceLayer;

    @Before
    public void setUp() throws Exception {

        setUpTaskerDaoMock();
        setUpRestTemplateMock();
        setUpDiscoveryClientMock();

        taskerServiceLayer = new TaskerServiceLayer(discoveryClient, restTemplate,"adserver-service","http://","/ad",taskerDao);
    }

    private void setUpTaskerDaoMock(){
        taskerDao = mock(TaskerDaoJdbcTemplateImpl.class);

        Task task  = new Task();
        task.setId(1);
        task.setDescription("job");
        task.setCreateDate(LocalDate.of(2019,7,7));
        task.setDueDate(LocalDate.of(2019,7,8));
        task.setCategory("event");

        Task task1 = new Task();

        task1.setDescription("job");
        task1.setCreateDate(LocalDate.of(2019,7,7));
        task1.setDueDate(LocalDate.of(2019,7,8));
        task1.setCategory("event");

        List<Task> taskList= new ArrayList<>();
        taskList.add(task);

        doReturn(task).when(taskerDao).createTask(task1);
        doReturn(task).when(taskerDao).getTask(1);
        doReturn(taskList).when(taskerDao).getAllTasks();
        doReturn(taskList).when(taskerDao).getTasksByCategory("event");
    }

    private void setUpRestTemplateMock(){
        restTemplate = mock(RestTemplate.class);

        doReturn("Toyota Camry").when(restTemplate).getForObject("http://localhost:6107/ad",String.class);
    }


    private void setUpDiscoveryClientMock(){
        discoveryClient = mock(DiscoveryClient.class);

        List<ServiceInstance> instances =new LinkedList<>();

        DefaultServiceInstance defaultServiceInstance = new DefaultServiceInstance("","","localhost",6107,true);
        instances.add(defaultServiceInstance);

        doReturn(instances).when(discoveryClient).getInstances("adserver-service");
    }


    @Test
    public void newFetchTask() {

        TaskViewModel task = new TaskViewModel();

        task.setDescription("job");
        task.setCreateDate(LocalDate.of(2019,7,7));
        task.setDueDate(LocalDate.of(2019,7,8));
        task.setCategory("event");

        task = taskerServiceLayer.newTask(task);
        TaskViewModel fromService = taskerServiceLayer.fetchTask(task.getId());
        assertEquals(task,fromService);
    }

    @Test
    public void fetchAllTasks() {

        TaskViewModel taskViewModel = new TaskViewModel();

        taskViewModel.setId(1);
        taskViewModel.setDescription("job");
        taskViewModel.setCreateDate(LocalDate.of(2019,7,7));
        taskViewModel.setDueDate(LocalDate.of(2019,7,8));
        taskViewModel.setCategory("event");

        List<TaskViewModel> taskViewModels = taskerServiceLayer.fetchAllTasks();
        assertEquals(taskViewModels.size(),1);
    }

    @Test
    public void fetchTasksByCategory() {
        TaskViewModel taskViewModel = new TaskViewModel();

        taskViewModel.setDescription("job");
        taskViewModel.setCreateDate(LocalDate.of(2019,7,7));
        taskViewModel.setDueDate(LocalDate.of(2019,7,8));
        taskViewModel.setCategory("event");

        taskViewModel = taskerServiceLayer.newTask(taskViewModel);

        List<TaskViewModel> taskViewModels = taskerServiceLayer.fetchTasksByCategory("event");

        assertEquals(taskViewModels.size(),1);
        assertEquals(taskViewModels.get(0),taskViewModel);
    }


}