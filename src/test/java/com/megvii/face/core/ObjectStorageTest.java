package com.megvii.face.core;

import com.megvii.face.core.service.ObjectStorageService;
import com.megvii.face.core.service.impl.ObjectStorageServiceImpl;
import org.junit.Before;
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


}
