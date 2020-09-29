package com.assertj.example.api.data;

import com.assertj.example.api.Car;

import java.time.LocalDateTime;

public class CarDetailsTestData {

  public static Car lexus(String registration) {
    return Car.builder()
        .name("Lexus")
        .nextMaintanance(LocalDateTime.now().plusMonths(2))
        .registration(null != registration ? registration : DataUtil.generateAlphanumericString(6))
        .engineDetails(EngineDetailsTestData.diesel())
        .build();
  }

  public static Car subaru(String registration) {
    return Car.builder()
        .name("Subaru")
        .nextMaintanance(LocalDateTime.now())
        .registration(null != registration ? registration : DataUtil.generateAlphanumericString(6))
        .engineDetails(EngineDetailsTestData.gasoline())
        .build();
  }

  public static Car toyota(String registration) {
    return Car.builder()
        .name("Toyota")
        .nextMaintanance(LocalDateTime.now())
        .registration(null != registration ? registration : DataUtil.generateAlphanumericString(6))
        .engineDetails(EngineDetailsTestData.hybrid())
        .build();
  }

}
