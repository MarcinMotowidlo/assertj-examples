package assertj.examples.classic;


import com.assertj.example.api.Car;
import com.assertj.example.api.data.CarDetailsTestData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicClassicTests {

  @Test
  public void softlyCompareSelectedFields() {

    Car firstCar = CarDetailsTestData.lexus("LX 1234");
    Car secondCar = CarDetailsTestData.subaru("SU 1234");

    assertEquals(firstCar.getName(), secondCar.getName());
    assertEquals(firstCar.getNextMaintanance(), secondCar.getNextMaintanance());
    assertEquals(firstCar.getPurchaseDate(), secondCar.getPurchaseDate());
    assertEquals(firstCar.getRegistration(), secondCar.getRegistration());
  }

  @Test
  public void compareFieldByField() {
    Car firstCar = CarDetailsTestData.lexus("LX 1234");
    Car secondCar = CarDetailsTestData.subaru("SU 1234");
    assertEquals(firstCar, secondCar);
  }

}
