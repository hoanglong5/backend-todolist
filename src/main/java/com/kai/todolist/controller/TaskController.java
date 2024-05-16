package com.kai.todolist.controller;

import com.kai.todolist.dto.TaskDto;
import com.kai.todolist.entity.Task;
import com.kai.todolist.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/${application.version}/tasks")
@AllArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping
    public ResponseEntity<List<TaskDto>> GetAllTask(){
        List<TaskDto> taskDtos = taskService.GetAllTask();
        return new ResponseEntity<>(taskDtos, HttpStatus.OK);
    }

    @GetMapping("/pagination")
    public ResponseEntity<Page<TaskDto>> GetAllTaskWithPagination(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){
        Page<TaskDto> tasksDtoPagination = taskService.GetAllTaskWithPagination(page, size);
        return ResponseEntity.ok(tasksDtoPagination);
    }
    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> GetTaskByID(@PathVariable Long id){
        TaskDto taskDto = taskService.GetTaskByID(id);
        return ResponseEntity.ok(taskDto);
    }
    @PostMapping()
    public ResponseEntity<String> CreateTask(@RequestBody Task task){
        String result = taskService.CreateTask(task);
        return ResponseEntity.ok(result);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> DeleteTask(@PathVariable Long id){
        String result = taskService.DeleteTask(id);
        return ResponseEntity.ok(result);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> UpdateTask(@RequestBody Task task, @PathVariable Long id){
        String result = taskService.UpdateTask(id, task);
        return ResponseEntity.ok(result);
    }
}
