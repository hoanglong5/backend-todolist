package com.kai.todolist.repository;

import com.kai.todolist.entity.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TasksRepository extends JpaRepository<Tasks,Long> {
}
