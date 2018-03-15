package com.megvii.face.core.service;

import com.megvii.face.core.model.CoreRes;
import com.megvii.face.core.model.SuccBody;
import com.megvii.face.core.vo.req.BucketAdd;
import com.megvii.face.core.vo.resp.Bucket;
import com.megvii.face.core.vo.resp.Buckets;
import com.megvii.face.core.vo.resp.StorageObject;
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

}
