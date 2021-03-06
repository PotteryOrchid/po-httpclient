package com.po.service.impl;

import com.alibaba.fastjson.JSON;
import com.po.model.CoreRes;
import com.po.model.SuccBody;
import com.po.model.UriParam;
import com.po.service.ObjectStorageService;
import com.po.uri.ObjectStorage;
import com.po.utils.CoreUriUtil;
import com.po.utils.HttpFileUtil;
import com.po.utils.HttpUtil;
import com.po.vo.req.BucketAdd;
import com.po.vo.resp.Bucket;
import com.po.vo.resp.Buckets;
import com.po.vo.resp.StorageObject;
import java.io.File;
import org.springframework.util.StringUtils;

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
  public CoreRes<Bucket> addBucket(BucketAdd bucketAdd) {

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
    String uri = CoreUriUtil.getCoreUri(ObjectStorage.DELETE_OBJECTSTORAGE_BNAME, uriParam);
    // Http request util.
    HttpUtil httpUtil = new HttpUtil();

    return httpUtil.doDelete(uri);
  }

  @Override
  public CoreRes<StorageObject> addObject(String bucketName, File file) {

    // Request parameters.
    UriParam uriParam = new UriParam(ObjectStorage.PARAM_BNAME, bucketName);
    // Request uri path.
    String uri = CoreUriUtil.getCoreUri(ObjectStorage.POST_OBJECTSTORAGE_BNAME, uriParam);
    // Http request util.
    HttpFileUtil httpFileUtil = new HttpFileUtil();

    return httpFileUtil.doPost(uri, file, StorageObject.class);
  }

  @Override
  public CoreRes<StorageObject> addObject(String bucketName, String str) {
    // Request parameters.
    UriParam uriParam = new UriParam(ObjectStorage.PARAM_BNAME, bucketName);
    // Request uri path.
    String uri = CoreUriUtil.getCoreUri(ObjectStorage.POST_OBJECTSTORAGE_BNAME, uriParam);
    // Http request util.
    HttpFileUtil httpFileUtil = new HttpFileUtil();

    return httpFileUtil.doPost(uri, str, StorageObject.class);
  }

  @Override
  public CoreRes<StorageObject> addObject(String bucketName, byte[] bytes) {
    // Request parameters.
    UriParam uriParam = new UriParam(ObjectStorage.PARAM_BNAME, bucketName);
    // Request uri path.
    String uri = CoreUriUtil.getCoreUri(ObjectStorage.POST_OBJECTSTORAGE_BNAME, uriParam);
    // Http request util.
    HttpFileUtil httpFileUtil = new HttpFileUtil();

    return httpFileUtil.doPost(uri, bytes, StorageObject.class);
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
    UriParam uriObjectName = new UriParam(ObjectStorage.PARAM_ONAME, objectName);
    // Request uri path.
    String uri = CoreUriUtil
        .getCoreUri(ObjectStorage.GET_OBJECTSTORAGE_BNAME_ONAME, uriBucketName, uriObjectName);
    // Http request util.
    HttpFileUtil httpFileUtil = new HttpFileUtil();

    return httpFileUtil.doGet(uri);
  }

  @Override
  public String getObjectUri(String bucketName, String objectName, String contentType) {
    // Request parameters.
    UriParam uriBucketName = new UriParam(ObjectStorage.PARAM_BNAME, bucketName);
    UriParam uriObjectName = new UriParam(ObjectStorage.PARAM_ONAME, objectName);
    // Request uri path.
    String uri = CoreUriUtil
        .getCoreUri(ObjectStorage.GET_OBJECTSTORAGE_BNAME_ONAME, uriBucketName, uriObjectName);
    if (StringUtils.isEmpty(contentType)) {
      return uri;
    } else {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(uri).append("?content-type=").append(contentType);
      return stringBuilder.toString();
    }
  }
}
