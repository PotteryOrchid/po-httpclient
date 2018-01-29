package com.megvii.face.core.service;

import com.megvii.face.core.model.CoreRes;
import com.megvii.face.core.model.SuccBody;
import com.megvii.face.core.vo.req.BucketAdd;
import com.megvii.face.core.vo.resp.Buckets;
import com.megvii.face.core.vo.resp.StorageObject;

/**
 * Created by ZJ on 29/01/2018.
 */
public interface ObjectStorageService {

  CoreRes<Buckets> getBuckets();

  CoreRes<SuccBody> addBucket(BucketAdd bucketAdd);

  CoreRes<SuccBody> delBucket(String bucketName);

  CoreRes<StorageObject> addObject(String bucketName, String storageObject);

  CoreRes<SuccBody> delObject(String bucketName, String objectName);

  CoreRes<SuccBody> getObject(String bucketName, String objectName);

}
