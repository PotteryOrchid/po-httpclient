package com.megvii.face.core.config;

import com.megvii.face.core.constant.HttpInfo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by ZJ on 04/01/2018.
 */
@Component
public class CoreInfo {

  private static String ip;

  private static String port;

  private static String version;

  public static String corePrefixUrl;

  public static void getCorePrefixUrl() {

    StringBuffer stringBuffer = new StringBuffer();

    stringBuffer.append(HttpInfo.HTTP_PREFIX);
    stringBuffer.append(ip);
    stringBuffer.append(HttpInfo.PORT_SPLIT);
    stringBuffer.append(port);
    stringBuffer.append(HttpInfo.PATH_SPLIT);
    stringBuffer.append(version);

    corePrefixUrl = stringBuffer.toString();
  }

  @Value("${sng.core.ip}")
  private void setIp(String ip) {
    CoreInfo.ip = ip;
  }

  @Value("${sng.core.port}")
  private void setPort(String port) {
    CoreInfo.port = port;
  }

  @Value("${sng.core.version}")
  private void setVersion(String version) {
    CoreInfo.version = version;
  }

}
