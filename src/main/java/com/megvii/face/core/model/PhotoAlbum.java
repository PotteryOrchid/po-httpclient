package com.megvii.face.core.model;

import lombok.Data;

/**
 * Created by ZJ on 16/01/2018.
 */
@Data
public class PhotoAlbum {

  public String id;

  public String name;

  public String description;

  public String type;

  public String estimatedSize;

  public String faceGroupId;

  public String creator;

  public String createTime;

  public String updateTime;

}
