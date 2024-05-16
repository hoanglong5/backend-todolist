package com.kai.todolist.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SuccessMessage {
    CREATE_TASK_SUCCESSFUL("Success","Create task successful"),
    UPDATE_TASK_SUCCESSFUL("Success","Update task successful"),
    DELETE_TASK_SUCCESSFUL("Success","Delete task successful");

    private final String message;
    private final String Detail;
}
