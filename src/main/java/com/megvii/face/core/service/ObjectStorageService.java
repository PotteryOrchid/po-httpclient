package com.megvii.face.core.service;

import com.megvii.face.core.model.CoreRes;
import com.megvii.face.core.model.SuccBody;
import com.megvii.face.core.vo.resp.Buckets;

/**
 * Created by ZJ on 29/01/2018.
 */
public interface ObjectStorageService {

  CoreRes<Buckets> getBuckets();

  CoreRes<SuccBody> addBucket();

  CoreRes<SuccBody> delBucket();

  CoreRes<SuccBody> addObject();

  CoreRes<SuccBody> delObject();

  CoreRes<SuccBody> getObject();

}
