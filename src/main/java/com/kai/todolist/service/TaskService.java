package com.kai.todolist.service;

import com.kai.todolist.dto.TaskDto;
import com.kai.todolist.entity.Task;
import com.kai.todolist.mapper.TasksMapper;
import com.kai.todolist.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService {
    public final TaskRepository taskRepository;

    public List<TaskDto> GetAllTask(){
        List<Task> tasks = taskRepository.findAll();
        return TasksMapper.TASKS_MAPPER.ListTaskToListDto(tasks);
    }

    public Page<TaskDto> GetAllTaskWithPagination(int pageNumber, int pageSize){
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        Page<Task> tasks = taskRepository.findAll(pageable);
        List<TaskDto> taskDtos = TasksMapper.TASKS_MAPPER.ListTaskToListDto(tasks.getContent());
        return new PageImpl<>(taskDtos,pageable,tasks.getTotalElements());
    }

    public TaskDto GetTaskByID(Long id){
        Task task =  taskRepository.findById(id).orElseThrow(RuntimeException::new);
        return TasksMapper.TASKS_MAPPER.TasksToTaskDto(task);
    }
    public void CreateTask(Task task){
        task.setDateCreated(LocalDate.now());
      taskRepository.save(task);
    }
    public TaskDto DeleteTask(Long id){
        Task task = taskRepository.findById(id).orElseThrow(RuntimeException::new);
        TaskDto taskDto = TasksMapper.TASKS_MAPPER.TasksToTaskDto(task);
        taskRepository.deleteById(id);
        return taskDto;
    }
    public void UpdateTask(Long id, Task task){
        Optional<Task> taskToUpdate = taskRepository.findById(id);
        taskToUpdate.get().setDateCreated(task.getDateCreated());
        taskToUpdate.get().setToDo(task.getToDo());
        taskToUpdate.get().setDone(task.isDone());
        taskRepository.save(taskToUpdate.get());
    }

}
