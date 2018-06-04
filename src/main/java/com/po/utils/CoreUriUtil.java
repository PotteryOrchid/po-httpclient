package com.po.utils;

import static com.po.config.CoreInfo.*;

import com.po.constant.HttpInfo;
import com.po.constant.MsgInfo;
import com.po.model.GetParam;
import com.po.model.UriParam;
import com.po.model.PageParam;
import java.lang.reflect.Field;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ZJ on 04/01/2018.
 */
public class CoreUriUtil {

  private static Logger logger = LoggerFactory.getLogger(CoreUriUtil.class);

  /**
   * Get a real http or https core uri Str. Create a new http or https core uri Str according the
   * original Str, and put the path parameter value into the uri Str.
   *
   * @param uri String. Prefix Str of original uri.
   * @param uriParams UriParam. Path params include key and value.
   * @return String
   */
  public static String getCoreUri(String uri, UriParam... uriParams) {

    StringBuilder stringBuilder = new StringBuilder();

    for (UriParam uriParam : uriParams) {
      uri = uri.replaceAll(uriParam.getName(), uriParam.getValue());
    }

    if (corePrefixUri == null) {
      getCorePrefixUri();
    }

    stringBuilder.append(corePrefixUri);
    stringBuilder.append(uri);

    return stringBuilder.toString();
  }

  /**
   * @param uri String. Prefix Str of original uri.
   * @param pageParam PageParam. Append page param to http uri Str. Please set the value to null if
   * you do not need this param value.
   * @param getParam GetParam. Append page param to http uri Str. Please set the value to null if
   * you do not need this param value.
   * @return String
   */
  public static String appendPageAndGetParam(String uri, PageParam pageParam, GetParam getParam) {

    StringBuilder stringBuilder = new StringBuilder();

    stringBuilder.append(uri);
    stringBuilder.append(HttpInfo.PARAM_SPLIT);

    if (getParam != null) {
      Field[] fields = getParam.getClass().getDeclaredFields();
      for (Field field : fields) {
        if (field == null) {
          continue;
        }

        field.setAccessible(true);

        Object o;

        try {
          o = field.get(getParam);
        } catch (IllegalAccessException e) {
          logger.warn(StrUtil
              .getStr(MsgInfo.URI_ERROR, MsgInfo.MSG_ENTER, e.getMessage()));
          continue;
        }

        if (o != null) {
          stringBuilder.append(field.getName());
          stringBuilder.append(HttpInfo.PARAM_EQUAL);
          stringBuilder.append(o.toString());
          stringBuilder.append(HttpInfo.PARAM_AND);
        }
      }
    }

    if (pageParam != null) {
      stringBuilder.append(pageParam.getUriPageParamStr());
      return stringBuilder.toString();
    }

    if (HttpInfo.PARAM_AND
        .equals(String.valueOf(stringBuilder.charAt(stringBuilder.length() - 1)))) {
      return stringBuilder.substring(0, stringBuilder.length() - 1);
    }

    return stringBuilder.toString();
  }
}
