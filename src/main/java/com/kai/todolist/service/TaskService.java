package com.kai.todolist.service;

import com.kai.todolist.entity.Tasks;
import com.kai.todolist.repository.TasksRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService {
    public final TasksRepository tasksRepository;

    public List<Tasks> GetAllTask(){
        List<Tasks> tasks = tasksRepository.findAll();
        return tasks;
    }

    public Optional<Tasks> GetTaskByID(Long id){
        return tasksRepository.findById(id);
    }
    public void CreateTask(Tasks tasks){
        tasks.setDateCreated(LocalDate.now());
      tasksRepository.save(tasks);
    }
    public void DeleteTask(Long id){
        tasksRepository.deleteById(id);
    }
    public void UpdateTask(Long id,Tasks tasks){
        Optional<Tasks> taskToUpdate = tasksRepository.findById(id);
        taskToUpdate.get().setDateCreated(tasks.getDateCreated());
        taskToUpdate.get().setToDo(tasks.getToDo());
        taskToUpdate.get().setDone(tasks.isDone());
        tasksRepository.save(taskToUpdate.get());
    }
}
