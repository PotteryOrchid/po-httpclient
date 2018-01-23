package com.megvii.face.core.vo.req;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by ZJ on 23/01/2018.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhotoAlbumUpdate {

  @JSONField
  public String name;

  @JSONField
  public String type;

  @JSONField
  public String estimatedSize;

}
