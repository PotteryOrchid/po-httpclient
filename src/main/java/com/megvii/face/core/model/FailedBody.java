package com.megvii.face.core.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * Created by ZJ on 22/01/2018.
 */
@Data
public class FailedBody {

  @JSONField
  private String code;

  @JSONField
  private String message;

  @JSONField
  private String requestId;

}
