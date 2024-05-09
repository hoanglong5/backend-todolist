package com.kai.todolist.controller;

import com.kai.todolist.entity.Tasks;
import com.kai.todolist.service.TaskService;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/tasks")
@AllArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping
    public ResponseEntity<List<Tasks>> GetAllTask(){
        List<Tasks> ListTasks = taskService.GetAllTask();
        return new ResponseEntity<>(ListTasks, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Tasks>> GetTaskByID(@PathVariable Long id){
        Optional<Tasks> tasks = taskService.GetTaskByID(id);
        return ResponseEntity.ok(tasks);
    }
    @PostMapping()
    public ResponseEntity<Tasks> CreateTask(@RequestBody Tasks tasks){
        taskService.CreateTask(tasks);
        return ResponseEntity.ok(tasks);
    }
    @DeleteMapping("/{id}")
    public void DeleteTask(@PathVariable Long id){
        taskService.DeleteTask(id);
    }
    @PutMapping("/{id}")
    public void UpdateTask(@RequestBody Tasks tasks,@PathVariable Long id){
        taskService.UpdateTask(id, tasks);
    }
}
