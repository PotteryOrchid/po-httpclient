package com.megvii.face.core.service;

import com.megvii.face.core.model.CoreRes;
import com.megvii.face.core.model.SuccBody;
import com.megvii.face.core.vo.req.PhotoAlbumAdd;
import com.megvii.face.core.vo.req.PhotoAlbumUpdate;
import com.megvii.face.core.vo.resp.PhotoAlbum;
import com.megvii.face.core.vo.resp.PhotoAlbums;

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
