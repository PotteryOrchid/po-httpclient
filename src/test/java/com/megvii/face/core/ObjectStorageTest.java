package com.megvii.face.core;

import com.megvii.face.core.service.ObjectStorageService;
import com.megvii.face.core.service.impl.ObjectStorageServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by ZJ on 29/01/2018.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = FaceCoreApplication.class)
public class ObjectStorageTest {

  ObjectStorageService objectStorageService;

  @Before
  public void before() {
    objectStorageService = new ObjectStorageServiceImpl();
  }

  @Test
  public void addBucket() {

  }

  @Test
  public void getBucketList() {

  }

  @Test
  public void delBucket() {

  }

  @Test
  public void addStorageObject() {

  }

  @Test
  public void getStorageObject() {

  }

  @Test
  public void delStorageObject() {

  }

  @After
  public void after() {
    objectStorageService = null;
  }

}
