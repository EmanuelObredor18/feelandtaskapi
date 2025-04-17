package com.mikelauwrence.feelandtaskapi.utils.mappers;

import org.mapstruct.Mapper;

import com.mikelauwrence.feelandtaskapi.dto.CreateTaskDTO;
import com.mikelauwrence.feelandtaskapi.dto.TaskResponseDTO;
import com.mikelauwrence.feelandtaskapi.models.Task;

@Mapper(componentModel = "spring")
public interface TaskMapper {
  
    TaskResponseDTO toTaskResponseDTO(Task task);

    // Ignore warning for the following method, the fields "id" and "createdAt" are assigned automatically. 
    Task toTask(CreateTaskDTO createTaskDTO);

}
