package com.po.vo.req;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by ZJ on 24/01/2018.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhotoAlbumU {

  @JSONField
  public String name;

  @JSONField
  public String type;

}
