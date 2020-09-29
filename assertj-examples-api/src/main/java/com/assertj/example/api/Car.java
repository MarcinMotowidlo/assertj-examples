package com.assertj.example.api;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDateTime;

@Data
@Builder
public class Car {

  public String name;
  public String registration;
  public Instant purchaseDate;
  public LocalDateTime nextMaintanance;
  public EngineDetails engineDetails;
}
