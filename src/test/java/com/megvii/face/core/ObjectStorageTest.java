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
import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
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
    BucketAdd bucketAdd = new BucketAdd("test", DefaultInfo.BUCKET_REPLICA);
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
  public void addStorageObject() throws IOException {

    byte[] bytes =null;

    CloseableHttpClient httpclient = HttpClients.createDefault();
    try {
      HttpGet httpget = new HttpGet("http://10.201.102.122:8080/v4/photos/a3-AAABYgUHWP0CmGB7AAAAAg==/data");

      System.out.println("Executing request " + httpget.getRequestLine());

      // Create a custom response handler
      ResponseHandler<byte[]> responseHandler = new ResponseHandler<byte[]>() {

        @Override
        public byte[] handleResponse(
            final HttpResponse response) throws ClientProtocolException, IOException {
          int status = response.getStatusLine().getStatusCode();
          if (status >= 200 && status < 300) {
            HttpEntity entity = response.getEntity();
            return entity != null ? EntityUtils.toByteArray(entity) : null;
          } else {
            throw new ClientProtocolException("Unexpected response status: " + status);
          }
        }

      };
      bytes = httpclient.execute(httpget, responseHandler);
    } finally {
      httpclient.close();
    }



    CoreRes<StorageObject> coreRes = objectStorageService.addObject("test", bytes);

    System.out.println("1:" + coreRes);
    System.out.println(coreRes.toString());
    if (coreRes.getStatus() == HttpStatus.SC_OK) {
      System.out.println("ok:" + coreRes.getBody());
    } else {
      System.out.println("fail:" + coreRes.getFailedBody());
    }

//    File file = new File("/Users/zj/Desktop/ok/1400.mp4");
//    CoreRes<StorageObject> coreRes = objectStorageService.addObject("test", file);
//
//    System.out.println("1:" + coreRes);
//    System.out.println(coreRes.toString());
//    if (coreRes.getStatus() == HttpStatus.SC_OK) {
//      System.out.println("ok:" + coreRes.getBody());
//    } else {
//      System.out.println("fail:" + coreRes.getFailedBody());
//    }
  }

  @Test
  public void getStorageObject() {
    CoreRes<SuccBody> coreRes = objectStorageService
        .getObject("test", "weed---5044-_0157d22e4151e06d");
    if (coreRes.getStatus() == HttpStatus.SC_OK) {
      System.out.println(coreRes.getBody());
    } else {
      System.out.println(coreRes.getFailedBody());
    }
  }

  @Test
  public void delStorageObject() {
    CoreRes<SuccBody> coreRes = objectStorageService
        .delObject("test", "weed---5044-_0157d22e4151e06d");
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
