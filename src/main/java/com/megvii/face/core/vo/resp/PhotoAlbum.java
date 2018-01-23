package com.megvii.face.core.vo.resp;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;
import lombok.Data;

/**
 * Created by ZJ on 16/01/2018.
 */
@Data
public class PhotoAlbum implements Serializable {

  private static final long serialVersionUID = 1L;

  @JSONField
  public String id;

  @JSONField
  public String name;

  @JSONField
  public String description;

  @JSONField
  public String type;

  @JSONField
  public String estimatedSize;

  @JSONField
  public String faceGroupId;

  @JSONField
  public String creator;

  @JSONField
  public String createTime;

  @JSONField
  public String updateTime;

}
