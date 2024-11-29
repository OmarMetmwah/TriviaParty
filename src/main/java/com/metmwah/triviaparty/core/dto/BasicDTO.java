package com.metmwah.triviaparty.core.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class BasicDTO {

  protected Integer id;

  protected LocalDateTime createdAt;

  protected LocalDateTime updatedAt;
}
