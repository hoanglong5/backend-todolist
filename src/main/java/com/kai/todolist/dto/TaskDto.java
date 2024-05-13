package com.kai.todolist.dto;

import lombok.Data;

import java.time.LocalDate;
@Data
public class TaskDto {
    private String toDo;
    private boolean done;
    private LocalDate dateCreated;
}
