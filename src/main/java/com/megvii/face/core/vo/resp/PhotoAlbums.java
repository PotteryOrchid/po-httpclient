package com.megvii.face.core.vo.resp;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.List;
import lombok.Data;

/**
 * Created by ZJ on 16/01/2018.
 */
@Data
public class PhotoAlbums {

  @JSONField
  List<PhotoAlbum> photoAlbums;

  @JSONField
  public String nextPageToken;

}
