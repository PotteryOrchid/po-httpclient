package com.megvii.face.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by ZJ on 23/01/2018.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuccBody {

  private String code;

  private String message;

  private String requestId;

}
