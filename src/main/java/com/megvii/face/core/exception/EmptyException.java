package com.megvii.face.core.exception;

import lombok.Data;

/**
 * Created by ZJ on 02/01/2018.
 */
@Data
public class EmptyException extends Throwable {

  private String code;

  private String message;

  public EmptyException(String message) {
    String s = "The value of " +
        message +
        " can not be empty.";
    this.setMessage(s);
  }

  public EmptyException(String code, String message) {
    this.setCode(code);
    String s = "The value of " +
        message +
        " can not be empty.";
    this.setMessage(s);
  }

}
