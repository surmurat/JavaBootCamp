package com.trilogyed.tasker.dao;

import com.trilogyed.tasker.model.Task;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TaskerDaoTest {

    @Autowired
    protected TaskerDao dao;

    @Before
    public void setUp() throws Exception{
        List<Task> taskList = dao.getAllTasks();

        taskList.stream()
                .forEach(task -> dao.deleteTask(task.getId()));
    }

    @Test
    public void createGetDeleteTask() {
        Task task = new Task();
        task.setCategory("payment");
        task.setDescription("coned");
        task.setCreateDate(LocalDate.of(2019,07,07));
        task.setDueDate(LocalDate.of(2019,8,8));

        task = dao.createTask(task);

        Task task1 = dao.getTask(task.getId());

        assertEquals(task,task1);

        dao.deleteTask(task.getId());

        task1 = dao.getTask(task.getId());

        assertNull(task1);
    }


    @Test
    public void getAllTasks() {

        Task task = new Task();
        task.setCategory("job event");
        task.setDescription("meeting");
        task.setCreateDate(LocalDate.of(2019,11,11));
        task.setDueDate(LocalDate.of(2019,11,11));

        dao.createTask(task);

        task = new Task();
        task.setCategory("job event");
        task.setDescription("hiring");
        task.setCreateDate(LocalDate.of(2019,3,3));
        task.setDueDate(LocalDate.of(2019,3,3));

        dao.createTask(task);

        List<Task> taskList = dao.getAllTasks();

        assertEquals(taskList.size(),2);
    }

    @Test
    public void getTasksByCategory() {
        Task task = new Task();
        task.setCategory("job event");
        task.setDescription("meeting");
        task.setCreateDate(LocalDate.of(2019,11,11));
        task.setDueDate(LocalDate.of(2019,11,11));

        dao.createTask(task);

        task = new Task();
        task.setCategory("job event");
        task.setDescription("hiring");
        task.setCreateDate(LocalDate.of(2019,3,3));
        task.setDueDate(LocalDate.of(2019,3,3));

        dao.createTask(task);

        task = new Task();
        task.setCategory("family");
        task.setDescription("reunite");
        task.setCreateDate(LocalDate.of(2019,1,1));
        task.setDueDate(LocalDate.of(2019,1,1));

        dao.createTask(task);

        List<Task> taskList = dao.getTasksByCategory("job event");
        assertEquals(2,taskList.size());

        taskList = dao.getTasksByCategory("family");
        assertEquals(1,taskList.size());

        taskList = dao.getTasksByCategory("friend");
        assertEquals(0,taskList.size());


    }

    @Test
    public void updateTask() {

        Task task = new Task();
        task.setCategory("payment");
        task.setDescription("coned");
        task.setCreateDate(LocalDate.of(2019,07,07));
        task.setDueDate(LocalDate.of(2019,8,8));

        task = dao.createTask(task);

        task.setDescription("vacation");

        dao.updateTask(task);

        Task task1 = dao.getTask(task.getId());

        assertEquals(task1,task);
    }


}