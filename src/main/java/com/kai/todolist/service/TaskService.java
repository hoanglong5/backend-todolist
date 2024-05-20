package com.kai.todolist.service;
import com.kai.todolist.dto.TaskDto;
import com.kai.todolist.entity.Task;
import com.kai.todolist.enums.SuccessMessage;
import com.kai.todolist.mapper.TasksMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.*;
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
        int validPageSize = (pageSize <= 0) ? 10 : pageSize;
        Pageable pageable = PageRequest.of(pageNumber,validPageSize, Sort.by("id"));
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
        taskToUpdate.setDateCreated(taskToUpdate.getDateCreated());
        taskToUpdate.setToDo(task.getToDo());
        taskToUpdate.setDone(task.isDone());
        taskEntityService.CreateTask(taskToUpdate);
        return SuccessMessage.UPDATE_TASK_SUCCESSFUL.getDetail();
    }

    public String DeleteAll(){
        taskEntityService.DeletaAllTask();
        return SuccessMessage.DELETE_TASKS_SUCCESSFUL.getDetail();
    }
}
