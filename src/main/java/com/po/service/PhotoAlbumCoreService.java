package com.po.service;

import com.po.model.CoreRes;
import com.po.model.SuccBody;
import com.po.vo.req.PhotoAlbumAdd;
import com.po.vo.req.PhotoAlbumUpdate;
import com.po.vo.resp.PhotoAlbum;
import com.po.vo.resp.PhotoAlbums;

/**
 * Created by ZJ on 16/01/2018.
 */
public interface PhotoAlbumCoreService {

  CoreRes<PhotoAlbums> getPhotoAlbumList(String pageToken, Integer pageOffset, Integer pageSize);

  CoreRes<PhotoAlbum> getPhotoAlbum(String photoAlbumId);

  CoreRes<PhotoAlbum> addPhotoAlbum(PhotoAlbumAdd photoAlbumAdd);

  CoreRes<SuccBody> delPhotoAlbum(String photoAlbumId);

  CoreRes<PhotoAlbum> updatePhotoAlbum(String photoAlbumId, PhotoAlbumUpdate photoAlbumUpdate);

}
