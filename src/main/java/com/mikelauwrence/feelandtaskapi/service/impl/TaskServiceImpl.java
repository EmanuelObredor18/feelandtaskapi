package com.mikelauwrence.feelandtaskapi.service.impl;

import org.springframework.stereotype.Service;

import com.mikelauwrence.feelandtaskapi.dto.CreateTaskDTO;
import com.mikelauwrence.feelandtaskapi.dto.TaskResponseDTO;
import com.mikelauwrence.feelandtaskapi.exceptions.ResourceNotFoundException;
import com.mikelauwrence.feelandtaskapi.repository.TaskRepository;
import com.mikelauwrence.feelandtaskapi.service.TaskService;
import com.mikelauwrence.feelandtaskapi.utils.mappers.TaskMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

  private final ResourceNotFoundException resourceNotFoundException = new ResourceNotFoundException("Task not found");

  private final TaskRepository taskRepository;
  private final TaskMapper taskMapper;

  @Override
  public TaskResponseDTO createTask(CreateTaskDTO createTaskDTO) {
    return taskMapper.toTaskResponseDTO(
        taskRepository.save(taskMapper.toTask(createTaskDTO)));
  }

  @Override
  public String deleteTask(Long id) throws ResourceNotFoundException {
    
    if (!taskRepository.existsById(id)) throw resourceNotFoundException;
    
    taskRepository.deleteById(id);
    return "Task deleted successfully";

  }

  @Override
  public TaskResponseDTO getTaskById(Long id) throws ResourceNotFoundException {
    return taskMapper.toTaskResponseDTO(
        taskRepository.findById(id).orElseThrow(() -> resourceNotFoundException));
  }

  @Override
  public TaskResponseDTO updateTask(Long id, CreateTaskDTO createTaskDTO) throws ResourceNotFoundException {
    if (!taskRepository.existsById(id)) throw resourceNotFoundException;
    
    return taskMapper.toTaskResponseDTO(
        taskRepository.save(taskMapper.toTask(createTaskDTO)));
  }
  
}
