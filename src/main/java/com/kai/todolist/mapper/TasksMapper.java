package com.kai.todolist.mapper;

import com.kai.todolist.dto.TaskDto;
import com.kai.todolist.entity.Task;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import java.util.List;
@Mapper
public interface TasksMapper {
    TasksMapper TASKS_MAPPER = Mappers.getMapper(TasksMapper.class);
    TaskDto TasksToTaskDto(Task task);
    @IterableMapping(elementTargetType = TaskDto.class)
    List<TaskDto> ListTaskToListDto(List<Task> taskList);
}
