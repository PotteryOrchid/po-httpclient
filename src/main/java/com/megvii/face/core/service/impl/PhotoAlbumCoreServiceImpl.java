package com.megvii.face.core.service.impl;

import com.megvii.face.core.model.CoreRes;
import com.megvii.face.core.model.PageParam;
import com.megvii.face.core.model.SuccBody;
import com.megvii.face.core.service.PhotoAlbumCoreService;
import com.megvii.face.core.utils.CoreUriUtil;
import com.megvii.face.core.utils.HttpUtil;
import com.megvii.face.core.vo.req.PhotoAlbumAdd;
import com.megvii.face.core.vo.req.PhotoAlbumUpdate;
import com.megvii.face.core.vo.resp.PhotoAlbum;
import com.megvii.face.core.vo.resp.PhotoAlbums;

/**
 * Created by ZJ on 02/01/2018.
 */
public class PhotoAlbumCoreServiceImpl implements PhotoAlbumCoreService {

  @Override
  public CoreRes<PhotoAlbums> getPhotoAlbumList(String pageToken, Integer pageOffset,
      Integer pageSize) {

    PageParam pageParam = new PageParam(pageToken, pageOffset, pageSize);
    String uri = CoreUriUtil
        .appendPageAndGetParam(
            CoreUriUtil.getCoreUri(com.megvii.face.core.uri.PhotoAlbum.GET_ALBUMS), pageParam,
            null);

    HttpUtil httpUtil = new HttpUtil();

    return httpUtil.doGet(uri, PhotoAlbums.class);
  }

  @Override
  public CoreRes<PhotoAlbum> getPhotoAlbum(String photoAlbumId) {
    return null;
  }

  @Override
  public CoreRes<PhotoAlbum> addPhotoAlbum(PhotoAlbumAdd photoAlbumAdd) {
    return null;
  }

  @Override
  public CoreRes<SuccBody> delPhotoAlbum(String photoAlbumId) {
    return null;
  }

  @Override
  public CoreRes<PhotoAlbum> updatePhotoAlbum(String photoAlbumId,
      PhotoAlbumUpdate photoAlbumUpdate) {
    return null;
  }
}
