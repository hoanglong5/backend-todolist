package com.kai.todolist.service;

import com.kai.todolist.dto.TaskDto;
import com.kai.todolist.entity.Task;
import com.kai.todolist.repository.TaskRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class TaskServiceTest {
    @Mock
    private TaskRepository taskRepository;
    @InjectMocks
    private TaskService taskService;

    private Task CreateDummyTask(){
        Task task = new Task();
        task.setId(1L);
        task.setToDo("lam bai");
        task.setDone(true);
        task.setDateCreated(LocalDate.now());
        return task;
    }
    private TaskDto CreateDummyTaskDto(){
        TaskDto taskDto = new TaskDto();
        taskDto.setToDo("lam bai");
        taskDto.setDone(true);
        taskDto.setDateCreated(LocalDate.now());
        return taskDto;
    }
    private List<TaskDto> CreateDummyListTaskDto(){
        List<TaskDto> taskDtos = new ArrayList<>();
        TaskDto taskDto = CreateDummyTaskDto();
        taskDtos.add(taskDto);
        return taskDtos;
    }
    private List<Task> CreateDummyTaskList(){
        List<Task> tasks = new ArrayList<>();
        Task task = CreateDummyTask();
        tasks.add(task);
        return tasks;
    }
    @Test
    void getAllTask() {
        List<Task> tasks = CreateDummyTaskList();
        List<TaskDto> expectedTasks = CreateDummyListTaskDto();
        Mockito.when(taskRepository.findAll()).thenReturn(tasks );
        List<TaskDto> actualResult = taskService.GetAllTask();
        Assertions.assertEquals(expectedTasks, actualResult);
        Assertions.assertNotNull(actualResult);
    }

    @Test
    void getAllTaskWithPagination() {

    }

    @Test
    void getTaskByID() {
        Optional<Task> expectedResult = Optional.of(CreateDummyTask());
        Long taskId = expectedResult.get().getId();
        Mockito.when(taskRepository.findById(taskId)).thenReturn(expectedResult);
        TaskDto actualResult = taskService.GetTaskByID(taskId);
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