package com.kai.todolist.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorMessage {
    ID_NOT_FOUND("Id not found","Please check the id of the item"),
    TASK_NOT_FOUND("Customer not found","Please check the id of the Task"),
    DATE_COULD_NOT_BE_CONVERTED("Date could not be converted!","Please be sure your date is correct."),
    PARAMETER_CANNOT_BE_NULL("Parameter cannot be null","Please enter full parameter."),
    REQUEST_BODY_IS_MISSING("Required request body","Required request body is missing");


    private final String message;
    private final String Detail;
}
