package com.kai.todolist.service;

import com.kai.todolist.entity.Tasks;
import com.kai.todolist.repository.TasksRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.scheduling.config.Task;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class TaskServiceTest {
    @Mock
    private TasksRepository tasksRepository;
    @InjectMocks
    private TaskService taskService;

    private Tasks CreateDummyTask(){
        Tasks task = new Tasks();
        task.setId(1L);
        task.setToDo("lam bai");
        task.setDone(true);
        task.setDateCreated(LocalDate.now());
        return task;
    }
    private List<Tasks> CreateDummyTaskList(){
        List<Tasks> tasks = new ArrayList<>();
        Tasks task = CreateDummyTask();
        tasks.add(task);
        return tasks;
    }
    @Test
    void getAllTask() {
        List<Tasks> expectedTasks = CreateDummyTaskList();
        Mockito.when(tasksRepository.findAll()).thenReturn(expectedTasks);
        List<Tasks> actualResult = taskService.GetAllTask();
        Assertions.assertEquals(expectedTasks, actualResult);
    }

    @Test
    void getAllTaskWithPagination() {

    }

    @Test
    void getTaskByID() {
        Optional<Tasks> expectedResult = Optional.of(CreateDummyTask());
        Long taskId = expectedResult.get().getId();
        Mockito.when(tasksRepository.findById(taskId)).thenReturn(expectedResult);
        Optional<Tasks> actualResult = taskService.GetTaskByID(taskId);
        Assertions.assertEquals(expectedResult,actualResult);
    }

    @Test
    void createTask() {
    }

    @Test
    void deleteTask() {
    }

    @Test
    void updateTask() {
    }
}