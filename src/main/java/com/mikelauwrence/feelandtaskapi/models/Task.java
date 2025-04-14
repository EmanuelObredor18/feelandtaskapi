package com.mikelauwrence.feelandtaskapi.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "TASKS")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Task {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(nullable = false, length = 100)
  private String title;
  
  @Column(nullable = false, length = 500)
  private String description;
  
  // TODO: change to enum
  private String status;
  
  // TODO: change to enum
  private String priority;
  
  @Column(nullable = false)
  private LocalDateTime dueDate;
  
  // TODO: use JPA to set this field automatically
  private LocalDateTime createdAt;

}
