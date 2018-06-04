package com.po.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by ZJ on 31/01/2018.
 */
@Component
public class Buckets {

  public static String bucketName;

//  @Value("${sng.face.module.bucket.name}")
  private void setSng_face_module_bucket_name(String bucketName) {
    Buckets.bucketName = bucketName;
  }

}
