package com.kai.todolist.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "task")
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",updatable = false)
    private Long id;
    @Column(name = "todo", nullable = false)
    private String toDo;
    @Column(name = "completed", nullable = false)
    private boolean done;
    @Column(name = "created_date", nullable = false)
    @DateTimeFormat(pattern = "dd-MM-yy")
    private LocalDate dateCreated;
}
