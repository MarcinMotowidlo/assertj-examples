package assertj.examples.soft;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExceptionTests {

  private static final String SOME_EXCEPTION_DETAILS = "someExceptionDetails";
  private static final String SOME_CAUSE_DETAILS = "someCauseDetails";

  @Test
  public void testVerifyExceptionDetails() {
    Throwable error = Assertions.catchThrowable(this::methodThrowingException);

    Assertions.assertThat(error)
        .isInstanceOf(IllegalStateException.class)
        .hasMessage(SOME_EXCEPTION_DETAILS)
        .hasRootCauseInstanceOf(IllegalArgumentException.class)
        .hasRootCauseMessage(SOME_CAUSE_DETAILS);
  }

  private void methodThrowingException() throws IllegalStateException {
    throw new IllegalStateException(SOME_EXCEPTION_DETAILS, new IllegalArgumentException(SOME_CAUSE_DETAILS));
  }
}
