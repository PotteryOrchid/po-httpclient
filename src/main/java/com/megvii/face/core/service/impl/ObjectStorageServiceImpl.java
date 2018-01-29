package com.megvii.face.core.service.impl;

import com.alibaba.fastjson.JSON;
import com.megvii.face.core.model.CoreRes;
import com.megvii.face.core.model.SuccBody;
import com.megvii.face.core.model.UriParam;
import com.megvii.face.core.service.ObjectStorageService;
import com.megvii.face.core.uri.ObjectStorage;
import com.megvii.face.core.utils.CoreUriUtil;
import com.megvii.face.core.utils.HttpUtil;
import com.megvii.face.core.vo.req.BucketAdd;
import com.megvii.face.core.vo.resp.Bucket;
import com.megvii.face.core.vo.resp.Buckets;
import com.megvii.face.core.vo.resp.StorageObject;

/**
 * Created by ZJ on 29/01/2018.
 */
public class ObjectStorageServiceImpl implements ObjectStorageService {

  @Override
  public CoreRes<Buckets> getBuckets() {

    // Request uri path.
    String uri = CoreUriUtil.getCoreUri(ObjectStorage.GET_OBJECTSTORAGE);
    // Http request util.
    HttpUtil httpUtil = new HttpUtil();

    return httpUtil.doGet(uri, Buckets.class);
  }

  @Override
  public CoreRes<SuccBody> addBucket(BucketAdd bucketAdd) {

    // Request uri path.
    String uri = CoreUriUtil.getCoreUri(ObjectStorage.POST_OBJECTSTORAGE);
    // Http request util.
    HttpUtil httpUtil = new HttpUtil();

    return httpUtil.doPost(uri, JSON.toJSONString(bucketAdd), Bucket.class);
  }

  @Override
  public CoreRes<SuccBody> delBucket(String bucketName) {

    // Request parameters.
    UriParam uriParam = new UriParam(ObjectStorage.PARAM_BNAME, bucketName);
    // Request uri path.
    String uri = CoreUriUtil.getCoreUri(ObjectStorage.DELETE_OBJECTSTORAGE_BNAME);
    // Http request util.
    HttpUtil httpUtil = new HttpUtil();

    return httpUtil.doDelete(uri);
  }

  @Override
  public CoreRes<StorageObject> addObject(String bucketName, String storageObject) {

    // Request parameters.
    UriParam uriParam = new UriParam(ObjectStorage.PARAM_BNAME, bucketName);
    // Request uri path.
    String uri = CoreUriUtil.getCoreUri(ObjectStorage.POST_OBJECTSTORAGE_BNAME, uriParam);
    // Http request util.
    HttpUtil httpUtil = new HttpUtil();

    return httpUtil.doPost(uri, storageObject, StorageObject.class);
  }

  @Override
  public CoreRes<SuccBody> delObject(String bucketName, String objectName) {

    // Request parameters.
    UriParam uriBucketName = new UriParam(ObjectStorage.PARAM_BNAME, bucketName);
    UriParam uriObjectName = new UriParam(ObjectStorage.PARAM_ONAME, objectName);
    // Request uri path.
    String uri = CoreUriUtil
        .getCoreUri(ObjectStorage.DELETE_OBJECTSTORAGE_BNAME_ONAME, uriBucketName, uriObjectName);
    // Http request util.
    HttpUtil httpUtil = new HttpUtil();

    return httpUtil.doDelete(uri);
  }

  @Override
  public CoreRes<SuccBody> getObject(String bucketName, String objectName) {

    // Request parameters.
    UriParam uriBucketName = new UriParam(ObjectStorage.PARAM_BNAME, bucketName);
    UriParam uriObjectName = new UriParam(ObjectStorage.PARAM_BNAME, objectName);
    // Request uri path.
    String uri = CoreUriUtil
        .getCoreUri(ObjectStorage.GET_OBJECTSTORAGE_BNAME_ONAME, uriBucketName, uriObjectName);
    // Http request util.
    HttpUtil httpUtil = new HttpUtil();

    return httpUtil.doGet(uri, Buckets.class);
  }
}
