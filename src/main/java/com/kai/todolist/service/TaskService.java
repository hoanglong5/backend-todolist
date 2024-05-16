package com.kai.todolist.service;
import com.kai.todolist.dto.TaskDto;
import com.kai.todolist.entity.Task;
import com.kai.todolist.enums.SuccessMessage;
import com.kai.todolist.mapper.TasksMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {
    private final TaskEntityService taskEntityService;
    private final TaskValidationService taskValidationService;


    public List<TaskDto> GetAllTask(){
        List<Task> tasks = taskEntityService.GetAllTask();
        return TasksMapper.INSTANCE.ListTaskToListDto(tasks);
    }

    public Page<TaskDto> GetAllTaskWithPagination(int pageNumber, int pageSize){
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        Page<Task> tasks = taskEntityService.GetAllTask(pageable);
        List<TaskDto> taskDtos = TasksMapper.INSTANCE.ListTaskToListDto(tasks.getContent());
        return new PageImpl<>(taskDtos,pageable,tasks.getTotalElements());
    }

    public TaskDto GetTaskByID(Long id){
        Task task =  taskValidationService.GetIdWithControl(id);
        return TasksMapper.INSTANCE.TasksToTaskDto(task);
    }
    public String CreateTask(Task task){
        task.setDateCreated(LocalDate.now());
        taskValidationService.ControlAllFieldsNotNull(task);
        taskEntityService.CreateTask(task);
        return SuccessMessage.CREATE_TASK_SUCCESSFUL.getDetail();
    }
    public String DeleteTask(Long id){
        Task task = taskValidationService.GetIdWithControl(id);
        taskEntityService.DeleteTask(id);
        return SuccessMessage.DELETE_TASK_SUCCESSFUL.getDetail();
    }
    public String UpdateTask(Long id, Task task){
        Task taskToUpdate = taskValidationService.GetIdWithControl(id);
        taskValidationService.ControlAllFieldsNotNull(task);
        taskToUpdate.setDateCreated(task.getDateCreated());
        taskToUpdate.setToDo(task.getToDo());
        taskToUpdate.setDone(task.isDone());
        taskEntityService.CreateTask(taskToUpdate);
        return SuccessMessage.UPDATE_TASK_SUCCESSFUL.getDetail();
    }

}
