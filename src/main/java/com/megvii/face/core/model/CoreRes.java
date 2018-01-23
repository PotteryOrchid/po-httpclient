package com.megvii.face.core.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by ZJ on 15/01/2018.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoreRes<T> implements Serializable {

  private static final long serialVersionUID = 1L;

  private int status;

  private T body;

  private FailedBody failedBody;

}
