package com.assertj.example.api.data;

import com.assertj.example.api.EngineDetails;

import java.math.BigDecimal;
import java.time.Instant;

public class EngineDetailsTestData {

  public static EngineDetails diesel() {
    return EngineDetails.builder()
        .brand("Lexus")
        .displacement(BigDecimal.valueOf(3000))
        .engineType(EngineDetails.EngineType.DIESEL)
        .lastMaintenance(Instant.now())
        .build();
  }

  public static EngineDetails gasoline() {
    return EngineDetails.builder()
        .brand("Subaru")
        .displacement(BigDecimal.valueOf(2500))
        .engineType(EngineDetails.EngineType.GASOLINE)
        .lastMaintenance(Instant.now())
        .build();
  }

  public static EngineDetails hybrid() {
    return EngineDetails.builder()
        .brand("Toyota")
        .displacement(BigDecimal.valueOf(1600))
        .engineType(EngineDetails.EngineType.HYBRID)
        .lastMaintenance(Instant.now())
        .build();
  }
}
