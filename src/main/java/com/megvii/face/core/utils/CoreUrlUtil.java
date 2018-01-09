package com.megvii.face.core.utils;

import com.megvii.face.core.model.UrlParam;
import com.megvii.face.core.config.CoreInfo;

/**
 * Created by ZJ on 04/01/2018.
 */
public class CoreUrlUtil {

  /**
   * Get a real http or https core url Str. Create a new http or https core url Str according the original Str, and transfer the url
   * parameter value into it. Example
   *
   * @param url String
   * @param urlParams UrlParam
   * @return String
   */
  public static String getRealUrl(String url, UrlParam... urlParams) {

    StringBuffer stringBuffer = new StringBuffer();

    for (UrlParam urlParam : urlParams) {
      url = url.replaceAll(urlParam.getName(), urlParam.getValue());
    }

    stringBuffer.append(CoreInfo.getCorePrefixUrl());
    stringBuffer.append(url);

    return stringBuffer.toString();
  }
}
