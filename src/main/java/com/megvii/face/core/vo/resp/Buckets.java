package com.megvii.face.core.vo.resp;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.List;
import lombok.Data;

/**
 * Created by ZJ on 29/01/2018.
 */
@Data
public class Buckets {

  @JSONField
  List<Bucket> buckets;

}
