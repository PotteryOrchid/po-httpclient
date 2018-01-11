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
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append("The value of ");
    stringBuffer.append(message);
    stringBuffer.append(" can not be empty.");
    this.setMessage(stringBuffer.toString());
  }

  public EmptyException(String code, String message) {
    this.setCode(code);
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append("The value of ");
    stringBuffer.append(message);
    stringBuffer.append(" can not be empty.");
    this.setMessage(stringBuffer.toString());
  }

}
