package com.kai.todolist.service;

import com.kai.todolist.entity.Task;
import com.kai.todolist.enums.ErrorMessage;
import com.kai.todolist.exception.ItemNotFoundException;
import com.kai.todolist.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskEntityService {
    private final TaskRepository taskRepository;
    public List<Task> GetAllTask(){
        return taskRepository.findAll();
    }

    public Optional<Task> GetTaskById(Long id){
        return taskRepository.findById(id);
    }

    public void CreateTask(Task task){
        taskRepository.save(task);
    }
    public void DeleteTask(Long id){
        taskRepository.deleteById(id);
    }
    public Page<Task> GetAllTask(Pageable pageable) {
        return taskRepository.findAll(pageable);
    }

    public boolean CheckTaskIsExist(Long id){
        return taskRepository.existsById(id);
    }
}
