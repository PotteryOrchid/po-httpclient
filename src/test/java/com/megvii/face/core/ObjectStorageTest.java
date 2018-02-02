package com.megvii.face.core;

import com.megvii.face.core.constant.DefaultInfo;
import com.megvii.face.core.model.CoreRes;
import com.megvii.face.core.model.SuccBody;
import com.megvii.face.core.service.ObjectStorageService;
import com.megvii.face.core.service.impl.ObjectStorageServiceImpl;
import com.megvii.face.core.vo.req.BucketAdd;
import com.megvii.face.core.vo.resp.Bucket;
import com.megvii.face.core.vo.resp.Buckets;
import com.megvii.face.core.vo.resp.StorageObject;
import java.io.File;
import org.apache.http.HttpStatus;
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
    BucketAdd bucketAdd = new BucketAdd("test2", DefaultInfo.BUCKET_REPLICA);
    CoreRes<Bucket> coreRes = objectStorageService.addBucket(bucketAdd);

    if (coreRes.getStatus() == HttpStatus.SC_OK) {
      System.out.println(coreRes.getBody());
    } else {
      System.out.println(coreRes.getFailedBody());
    }
  }

  @Test
  public void getBucketList() {
    CoreRes<Buckets> coreRes = objectStorageService.getBuckets();
    if (coreRes.getStatus() == HttpStatus.SC_OK) {
      System.out.println(coreRes.getBody().getBuckets().size());
      System.out.println(coreRes.getBody().getBuckets().get(0));
    } else {
      System.out.println(coreRes.getFailedBody());
    }
  }

  @Test
  public void delBucket() {
    CoreRes<SuccBody> coreRes = objectStorageService.delBucket("test");

    if (coreRes.getStatus() == HttpStatus.SC_OK) {
      System.out.println(coreRes.getBody());
    } else {
      System.out.println(coreRes.getFailedBody());
    }
  }

  @Test
  public void addStorageObject() {
    File file = new File("/Users/zj/Desktop/y2018.mp4");
    CoreRes<StorageObject> coreRes = objectStorageService.addObject("test2", file);

    System.out.println("1:" + coreRes);
    System.out.println(coreRes.toString());
    if (coreRes.getStatus() == HttpStatus.SC_OK) {
      System.out.println("ok:" + coreRes.getBody());
    } else {
      System.out.println("fail:" + coreRes.getFailedBody());
    }
  }

  @Test
  public void getStorageObject() {
    CoreRes<SuccBody> coreRes = objectStorageService
        .getObject("test2", "weed---5044-_0157d22e4151e06d");
    if (coreRes.getStatus() == HttpStatus.SC_OK) {
      System.out.println(coreRes.getBody());
    } else {
      System.out.println(coreRes.getFailedBody());
    }
  }

  @Test
  public void delStorageObject() {
    CoreRes<SuccBody> coreRes = objectStorageService
        .delObject("test2", "weed---5044-_0157d22e4151e06d");
    if (coreRes.getStatus() == HttpStatus.SC_OK) {
      System.out.println(coreRes.getBody());
    } else {
      System.out.println(coreRes.getFailedBody());
    }
  }

  @After
  public void after() {
    objectStorageService = null;
  }

}
