package com.megvii.face.core.utils;

/**
 * Created by ZJ on 16/01/2018.
 */
public class StrUtil {

  /**
   * Get Str.
   */
  public static String getStr(String... strings) {
    StringBuilder stringBuilder = new StringBuilder();

    for (String string : strings) {
      stringBuilder.append(string);
    }

    return stringBuilder.toString();
  }

}
