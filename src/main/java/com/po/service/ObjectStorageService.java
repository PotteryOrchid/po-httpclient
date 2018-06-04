package com.po.service;

import com.po.model.CoreRes;
import com.po.model.SuccBody;
import com.po.vo.req.BucketAdd;
import com.po.vo.resp.Bucket;
import com.po.vo.resp.Buckets;
import com.po.vo.resp.StorageObject;
import java.io.File;

/**
 * Created by ZJ on 29/01/2018.
 */
public interface ObjectStorageService {

  CoreRes<Buckets> getBuckets();

  CoreRes<Bucket> addBucket(BucketAdd bucketAdd);

  CoreRes<SuccBody> delBucket(String bucketName);

  CoreRes<StorageObject> addObject(String bucketName, File file);

  CoreRes<StorageObject> addObject(String bucketName, String str);

  CoreRes<StorageObject> addObject(String bucketName, byte[] bytes);

  CoreRes<SuccBody> delObject(String bucketName, String objectName);

  CoreRes<SuccBody> getObject(String bucketName, String objectName);

  String getObjectUri(String bucketName, String objectName, String contentType);

}
