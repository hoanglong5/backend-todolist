package com.kai.todolist.service;

import com.kai.todolist.entity.Task;
import com.kai.todolist.enums.ErrorMessage;
import com.kai.todolist.exception.IllegalFieldException;
import com.kai.todolist.exception.ItemNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TaskValidationService {
    private final TaskEntityService taskEntityService;
    public void ControlIsTaskExist(Long id){
        boolean exist = taskEntityService.CheckTaskIsExist(id);
        if (!exist){
            throw new ItemNotFoundException(ErrorMessage.TASK_NOT_FOUND.getDetail());
        }
    }
    public Task GetIdWithControl(Long id){
        Task task = taskEntityService.GetTaskById(id)
                                    .orElseThrow(() -> new ItemNotFoundException(ErrorMessage.ID_NOT_FOUND.getDetail()));
        return task;
    }
    public void ControlAllFieldsNotNull(Task task){
        if (task == null){
            throw new IllegalFieldException(ErrorMessage.PARAMETER_CANNOT_BE_NULL.getDetail());}
        boolean hasNullField = task.getToDo().isBlank() ||
                                task.getDateCreated().toString().isBlank() ;
        if (hasNullField){
            throw new IllegalFieldException(ErrorMessage.PARAMETER_CANNOT_BE_NULL.getDetail());}
    }
}
