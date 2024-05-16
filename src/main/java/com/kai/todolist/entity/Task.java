package com.kai.todolist.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",updatable = false)
    private Long id;
    @Column(name = "todo", nullable = false)
    @Size(min = 0,max = 100,message = "Task must be between 0 and 100 characters")
    private String toDo;
    @Column(name = "completed", nullable = false)
    private boolean done;
    @Column(name = "created_date", nullable = false)
    @DateTimeFormat(pattern = "dd-MM-yy")
    private LocalDate dateCreated;
}
