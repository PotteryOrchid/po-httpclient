package com.po.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * Created by ZJ on 23/01/2018.
 */
@Data
public class SuccBody {

  @JSONField
  private String code;

  @JSONField
  private String message;

  @JSONField
  private String requestId;

}
