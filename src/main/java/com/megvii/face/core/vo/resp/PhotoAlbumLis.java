package com.megvii.face.core.vo.resp;

import com.megvii.face.core.model.PhotoAlbum;
import java.util.List;
import lombok.Data;

/**
 * Created by ZJ on 16/01/2018.
 */
@Data
public class PhotoAlbumLis {

  List<PhotoAlbum> photoAlbums;

  public String nextPageToken;

}
