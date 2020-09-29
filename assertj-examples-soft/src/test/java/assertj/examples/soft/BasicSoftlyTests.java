package assertj.examples.soft;


import com.assertj.example.api.Car;
import com.assertj.example.api.EngineDetails;
import com.assertj.example.api.data.CarDetailsTestData;
import com.assertj.example.api.data.EngineDetailsTestData;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.Comparator;

/**
 * Please see some more examples
 * https://github.com/joel-costigliola/assertj-examples/tree/main/assertions-examples/src/test/java/org/assertj/examples
 */
public class BasicSoftlyTests {

  @Test
  public void softlyCompareSelectedFields() {

    Car firstCar = CarDetailsTestData.lexus("LX 1234");
    Car secondCar = CarDetailsTestData.subaru("SU 1234");

    SoftAssertions softly = new SoftAssertions();
    softly.assertThat(firstCar.getName()).as("Name").isEqualTo(secondCar.getName());
    softly.assertThat(firstCar.getNextMaintanance()).as("Next maintenance").isEqualTo(secondCar.getNextMaintanance());
    softly.assertThat(firstCar.getPurchaseDate()).as("Purchase date").isEqualTo(secondCar.getPurchaseDate());
    softly.assertThat(firstCar.getRegistration()).as("Registration").isEqualTo(secondCar.getRegistration());

    softly.assertAll();

  }

  @Test
  public void softlyCompareFieldByField() {
    Car firstCar = CarDetailsTestData.lexus("LX 1234");
    Car secondCar = CarDetailsTestData.subaru("SU 1234");

    SoftAssertions softly = new SoftAssertions();
    softly.assertThat(firstCar)
        .usingRecursiveComparison()
        .isEqualTo(secondCar);

    softly.assertAll();
  }

  @Test
  @Deprecated
  public void softlyIgnoreGeneratedFields() {
    Car firstCar = CarDetailsTestData.lexus(null);
    Car secondCar = CarDetailsTestData.lexus(null);

    SoftAssertions softly = new SoftAssertions();
    softly.assertThat(firstCar)
        .usingRecursiveComparison()
        .ignoringFields("nextMaintanance", "registration")
        .isEqualTo(secondCar);

    softly.assertAll();
  }

  @Test
  @Deprecated
  public void softlyIgnoreGeneratedFieldsOfType() {
    Car firstCar = CarDetailsTestData.lexus("LX 1234");
    Car secondCar = CarDetailsTestData.lexus("LX 1234");

    SoftAssertions softly = new SoftAssertions();
    softly.assertThat(firstCar)
        .usingRecursiveComparison()
        .ignoringFieldsOfTypes(Instant.class)
        .isEqualTo(secondCar);

    softly.assertAll();
  }

  @Test
  public void testCompareUsingComparator() {
    Car firstCar = CarDetailsTestData.subaru("AB 1234");
    Car secondCar = CarDetailsTestData.lexus("AB 1234");
    Car thirdCar = CarDetailsTestData.toyota("AB 1234");

    Assertions.assertThat(firstCar)
        .usingComparator(Comparator.comparing(Car::getRegistration))
        .isEqualTo(secondCar)
//        ...
        .isEqualTo(thirdCar);
  }

  @Test
  public void testCompareObjectReference() {
    EngineDetails firstEngine = EngineDetailsTestData.gasoline();
    EngineDetails firstEngineClone = firstEngine;
    EngineDetails thirdEngine = EngineDetailsTestData.gasoline();

    Assertions.assertThat(firstEngine)
        .isSameAs(firstEngineClone)
//        ...
        .isNotSameAs(thirdEngine);
  }

  @Test
  public void testMatcherFunction() {
    EngineDetails firstEngine = EngineDetailsTestData.gasoline();

    Assertions.assertThat(firstEngine).matches(p ->
        p.getEngineType() == EngineDetails.EngineType.GASOLINE &&
            p.getBrand().equals("Subaru"));
  }

  @Test
  public void testExtractFields() {
    EngineDetails firstEngine = EngineDetailsTestData.gasoline();

    Assertions.assertThat(firstEngine)
        .extracting(
            EngineDetails::getEngineType,
//            ...
            EngineDetails::getBrand)
        .containsExactly(EngineDetails.EngineType.GASOLINE, "Subaru");

  }
}
