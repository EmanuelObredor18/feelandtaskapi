package com.mikelauwrence.feelandtaskapi.service;

import com.mikelauwrence.feelandtaskapi.dto.CreateTaskDTO;
import com.mikelauwrence.feelandtaskapi.dto.TaskResponseDTO;
import com.mikelauwrence.feelandtaskapi.exceptions.ResourceNotFoundException;

public interface TaskService {

  TaskResponseDTO createTask(CreateTaskDTO createTaskDTO);

  String deleteTask(Long id) throws ResourceNotFoundException;

  TaskResponseDTO getTaskById(Long id) throws ResourceNotFoundException;

  TaskResponseDTO updateTask(Long id, CreateTaskDTO createTaskDTO) throws ResourceNotFoundException;

  // TODO: Implement the method to get a task by its ID and user ID
  // TaskResponseDTO getTaskByIdAndUserId(Long id, Long userId);

  // TODO: Implement the method to get all tasks by user ID
  // Set<TaskResponseDTO> getAllTasksByUserId(Long userId);
}
