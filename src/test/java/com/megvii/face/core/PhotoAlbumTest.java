package com.megvii.face.core;

import com.megvii.face.core.model.CoreRes;
import com.megvii.face.core.service.PhotoAlbumCoreService;
import com.megvii.face.core.service.impl.PhotoAlbumCoreServiceImpl;

import com.megvii.face.core.vo.resp.PhotoAlbums;
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

  @After
  public void after() {
    photoAlbumCoreService = null;
  }

}
