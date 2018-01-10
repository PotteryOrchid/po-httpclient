package com.megvii.face.core.config;

import com.megvii.face.core.constant.HttpInfo;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by ZJ on 04/01/2018.
 */
@Data
@Component
public class CoreInfo {

  @Value("${sng.core.ip}")
  @NotEmpty(message = "Core service IP can not be empty.")
  private static String ip;

  @Value("${sng.core.port}")
  @NotEmpty(message = "Core service port can not be empty.")
  private static String port;

  @Value("${sng.core.version}")
  @NotEmpty(message = "Core service version can not be empty.")
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

}
