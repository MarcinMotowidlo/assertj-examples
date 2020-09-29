package com.assertj.example.api;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
public class EngineDetails {

  public BigDecimal displacement;
  public String brand;
  public EngineType engineType;
  public Instant lastMaintenance;

  public enum EngineType {
    DIESEL, GASOLINE, HYBRID
  }
}
