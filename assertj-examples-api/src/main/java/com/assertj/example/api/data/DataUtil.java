package com.assertj.example.api.data;

import java.util.Random;

public class DataUtil {

  private static final int _0 = 48;
  private static final int _Z = 122;

  public static String generateAlphanumericString(int length) {
    Random random = new Random();

    return random.ints(_0, _Z + 1)
        .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
        .limit(length)
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        .toString();
  }
}
