package com.po.service.impl;

import com.alibaba.fastjson.JSON;
import com.po.model.CoreRes;
import com.po.model.PageParam;
import com.po.model.SuccBody;
import com.po.model.UriParam;
import com.po.service.PhotoAlbumCoreService;
import com.po.utils.CoreUriUtil;
import com.po.utils.HttpUtil;
import com.po.vo.req.PhotoAlbumAdd;
import com.po.vo.req.PhotoAlbumUpdate;
import com.po.vo.resp.PhotoAlbum;
import com.po.vo.resp.PhotoAlbums;

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
            CoreUriUtil.getCoreUri(com.po.uri.PhotoAlbum.GET_ALBUMS), pageParam,
            null);
    // Http request util.
    HttpUtil httpUtil = new HttpUtil();

    return httpUtil.doGet(uri, PhotoAlbums.class);
  }

  @Override
  public CoreRes<PhotoAlbum> getPhotoAlbum(String photoAlbumId) {

    // Request parameters.
    UriParam uriParam = new UriParam(com.po.uri.PhotoAlbum.PARAM_ID, photoAlbumId);
    // Request uri path.
    String uri = CoreUriUtil
        .getCoreUri(com.po.uri.PhotoAlbum.GET_ALBUMS_ID, uriParam);
    // Http request util.
    HttpUtil httpUtil = new HttpUtil();

    return httpUtil.doGet(uri, PhotoAlbum.class);
  }

  @Override
  public CoreRes<PhotoAlbum> addPhotoAlbum(PhotoAlbumAdd photoAlbumAdd) {

    // Request uri path.
    String uri = CoreUriUtil
        .getCoreUri(com.po.uri.PhotoAlbum.POST_ALBUMS);
    // Http request util.
    HttpUtil httpUtil = new HttpUtil();

    return httpUtil.doPost(uri, JSON.toJSONString(photoAlbumAdd), PhotoAlbum.class);
  }

  @Override
  public CoreRes<SuccBody> delPhotoAlbum(String photoAlbumId) {

    // Request parameters.
    UriParam uriParam = new UriParam(com.po.uri.PhotoAlbum.PARAM_ID, photoAlbumId);
    // Request uri path.
    String uri = CoreUriUtil
        .getCoreUri(com.po.uri.PhotoAlbum.DELETE_ALBUMS_ID, uriParam);
    // Http request util.
    HttpUtil httpUtil = new HttpUtil();

    return httpUtil.doDelete(uri);
  }

  @Override
  public CoreRes<PhotoAlbum> updatePhotoAlbum(String photoAlbumId,
      PhotoAlbumUpdate photoAlbumUpdate) {

    // Request parameters.
    UriParam uriParam = new UriParam(com.po.uri.PhotoAlbum.PARAM_ID, photoAlbumId);
    // Request uri path.
    String uri = CoreUriUtil
        .getCoreUri(com.po.uri.PhotoAlbum.PATCH_ALBUMS_ID, uriParam);
    // Http request util.
    HttpUtil httpUtil = new HttpUtil();

    return httpUtil.doPatch(uri, JSON.toJSONString(photoAlbumUpdate), PhotoAlbum.class);
  }
}
