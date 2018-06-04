package com.po.vo.resp;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * Created by ZJ on 29/01/2018.
 */
@Data
public class Bucket {

  @JSONField
  public String name;

  @JSONField
  public Integer replica;

}
