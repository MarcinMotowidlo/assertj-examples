package assertj.examples.classic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExceptionTests {
  private static final String SOME_EXCEPTION_DETAILS = "someExceptionDetails";
  private static final String SOME_CAUSE_DETAILS = "someCauseDetails";

  @Test
  public void testVerifyExceptionDetails() {
    Throwable error = Assertions.assertThrows(IllegalStateException.class, this::methodThrowingException);
    Assertions.assertTrue(error.getCause() instanceof IllegalArgumentException);
    Assertions.assertEquals(error.getMessage(), SOME_EXCEPTION_DETAILS);
    Assertions.assertEquals(error.getCause().getMessage(), SOME_CAUSE_DETAILS);
  }

  private void methodThrowingException() throws IllegalStateException {
    throw new IllegalStateException(SOME_EXCEPTION_DETAILS, new IllegalArgumentException(SOME_CAUSE_DETAILS));
  }
}
