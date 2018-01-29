package com.megvii.face.core.service.impl;

import com.alibaba.fastjson.JSON;
import com.megvii.face.core.model.CoreRes;
import com.megvii.face.core.model.PageParam;
import com.megvii.face.core.model.SuccBody;
import com.megvii.face.core.model.UriParam;
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

    // Request parameters.
    PageParam pageParam = new PageParam(pageToken, pageOffset, pageSize);
    // Request uri path.
    String uri = CoreUriUtil
        .appendPageAndGetParam(
            CoreUriUtil.getCoreUri(com.megvii.face.core.uri.PhotoAlbum.GET_ALBUMS), pageParam,
            null);
    // Http request util.
    HttpUtil httpUtil = new HttpUtil();

    return httpUtil.doGet(uri, PhotoAlbums.class);
  }

  @Override
  public CoreRes<PhotoAlbum> getPhotoAlbum(String photoAlbumId) {

    // Request parameters.
    UriParam uriParam = new UriParam(com.megvii.face.core.uri.PhotoAlbum.PARAM_ID, photoAlbumId);
    // Request uri path.
    String uri = CoreUriUtil
        .getCoreUri(com.megvii.face.core.uri.PhotoAlbum.GET_ALBUMS_ID, uriParam);
    // Http request util.
    HttpUtil httpUtil = new HttpUtil();

    return httpUtil.doGet(uri, PhotoAlbum.class);
  }

  @Override
  public CoreRes<PhotoAlbum> addPhotoAlbum(PhotoAlbumAdd photoAlbumAdd) {

    // Request uri path.
    String uri = CoreUriUtil
        .getCoreUri(com.megvii.face.core.uri.PhotoAlbum.POST_ALBUMS);
    // Http request util.
    HttpUtil httpUtil = new HttpUtil();

    return httpUtil.doPost(uri, JSON.toJSONString(photoAlbumAdd), PhotoAlbum.class);
  }

  @Override
  public CoreRes<SuccBody> delPhotoAlbum(String photoAlbumId) {

    // Request parameters.
    UriParam uriParam = new UriParam(com.megvii.face.core.uri.PhotoAlbum.PARAM_ID, photoAlbumId);
    // Request uri path.
    String uri = CoreUriUtil
        .getCoreUri(com.megvii.face.core.uri.PhotoAlbum.DELETE_ALBUMS_ID, uriParam);
    // Http request util.
    HttpUtil httpUtil = new HttpUtil();

    return httpUtil.doDelete(uri);
  }

  @Override
  public CoreRes<PhotoAlbum> updatePhotoAlbum(String photoAlbumId,
      PhotoAlbumUpdate photoAlbumUpdate) {

    // Request parameters.
    UriParam uriParam = new UriParam(com.megvii.face.core.uri.PhotoAlbum.PARAM_ID, photoAlbumId);
    // Request uri path.
    String uri = CoreUriUtil
        .getCoreUri(com.megvii.face.core.uri.PhotoAlbum.PATCH_ALBUMS_ID, uriParam);
    // Http request util.
    HttpUtil httpUtil = new HttpUtil();

    return httpUtil.doPatch(uri, JSON.toJSONString(photoAlbumUpdate), PhotoAlbum.class);
  }
}
