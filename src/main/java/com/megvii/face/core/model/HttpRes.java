package com.megvii.face.core.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by ZJ on 15/01/2018.
 */
@NoArgsConstructor
@Data
public class HttpRes {

  private int status;

  private String body;

  public static HttpRes getInstance(int status, String body) {
    HttpRes httpRes = new HttpRes();
    httpRes.setStatus(status);
    httpRes.setBody(body);
    return httpRes;
  }

}
