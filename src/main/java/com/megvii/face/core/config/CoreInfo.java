package com.megvii.face.core.config;

import com.megvii.face.core.constant.HttpInfo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by ZJ on 04/01/2018.
 */
@Data
@Component
public class CoreInfo {

  @Value("${sng.core.ip}")
  private static String ip;

  @Value("${sng.core.port}")
  private static String port;

  @Value("${sng.core.version}")
  private static String version;

  public static String getCorePrefixUrl() {

    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(HttpInfo.HTTP_PREFIX);
    stringBuffer.append(ip);
    stringBuffer.append(HttpInfo.PORT_SPLIT);
    stringBuffer.append(port);
    stringBuffer.append(HttpInfo.PATH_SPLIT);
    stringBuffer.append(version);

    return stringBuffer.toString();
  }

}
