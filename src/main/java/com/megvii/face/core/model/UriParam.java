package com.megvii.face.core.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by ZJ on 05/01/2018.
 */
@AllArgsConstructor
@Getter
public class UriParam implements Serializable {

  private static final long serialVersionUID = 1L;

  private String name;

  private String value;

}
