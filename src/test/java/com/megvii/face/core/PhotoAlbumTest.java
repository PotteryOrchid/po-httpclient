package com.megvii.face.core;

import com.megvii.face.core.model.CoreRes;
import com.megvii.face.core.model.SuccBody;
import com.megvii.face.core.service.PhotoAlbumCoreService;
import com.megvii.face.core.service.impl.PhotoAlbumCoreServiceImpl;

import com.megvii.face.core.vo.req.PhotoAlbumAdd;
import com.megvii.face.core.vo.req.PhotoAlbumU;
import com.megvii.face.core.vo.req.PhotoAlbumUpdate;
import com.megvii.face.core.vo.resp.PhotoAlbum;
import com.megvii.face.core.vo.resp.PhotoAlbums;
import org.apache.http.HttpStatus;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by ZJ on 23/01/2018.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = FaceCoreApplication.class)
public class PhotoAlbumTest {

  PhotoAlbumCoreService photoAlbumCoreService;

  @Before
  public void before() {
    photoAlbumCoreService = new PhotoAlbumCoreServiceImpl();
  }

  @Test
  public void getPhotoAlbumList() {
    CoreRes<PhotoAlbums> coreRes = photoAlbumCoreService.getPhotoAlbumList(null, 0, 3);
    System.out.println(coreRes.getBody().toString());
  }

  @Test
  public void getPhotoAlbum() {
    CoreRes<PhotoAlbum> coreRes = photoAlbumCoreService
        .getPhotoAlbum("8242c163-d892-3769-8cf5-95ce5c21069b");
    System.out.println(coreRes.getBody().toString());
  }

  @Test
  public void addPhotoAlbum() {
    PhotoAlbumAdd photoAlbumAdd = new PhotoAlbumAdd("test001", "MONITOR", 0);
    CoreRes<PhotoAlbum> coreRes = photoAlbumCoreService.addPhotoAlbum(photoAlbumAdd);
    if (coreRes.getStatus() != HttpStatus.SC_OK) {
      System.out.println(coreRes.getFailedBody().toString());
    } else {
      System.out.println(coreRes.getBody().toString());
    }
  }

  @Test
  public void delPhotoAlbum() {
    CoreRes<SuccBody> coreRes = photoAlbumCoreService
        .delPhotoAlbum("d8bec7ea-2330-3e8a-c838-7cd0431a7955");
    if (coreRes.getStatus() != HttpStatus.SC_OK) {
      System.out.println(coreRes.getFailedBody().toString());
    } else {
      System.out.println(coreRes.getBody());
    }
  }

  @Test
  public void updatePhotoAlbum() {
    PhotoAlbumUpdate photoAlbumUpdate = new PhotoAlbumUpdate(new PhotoAlbumU("test2", "MONITOR"));
    CoreRes<PhotoAlbum> coreRes = photoAlbumCoreService
        .updatePhotoAlbum("8242c163-d892-3769-8cf5-95ce5c21069b", photoAlbumUpdate);
    System.out.println(coreRes.getBody().toString());
  }

  @After
  public void after() {
    photoAlbumCoreService = null;
  }

}
