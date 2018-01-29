package com.megvii.face.core.vo.req;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by ZJ on 29/01/2018.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BucketAdd {

  @JSONField
  public String name;

  @JSONField
  public String replica;

}
