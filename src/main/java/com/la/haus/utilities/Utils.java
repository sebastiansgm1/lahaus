package com.la.haus.utilities;

import java.util.Random;

public class Utils {

  public static int[] getRandomNumber(int length) {
    int[] set = new int[length];
    for (int i = 0; i < length; i++) {
      set[i] = new Random().nextInt(10);
    }
    return set;
  }

}
