package com.kai.todolist.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {
    private String toDo;
    private boolean done;
    private LocalDate dateCreated;
}
