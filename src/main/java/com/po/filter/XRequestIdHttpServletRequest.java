package com.po.filter;

import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import org.springframework.util.StringUtils;

/**
 * Created by ZJ on 18/01/2018.
 */
public class XRequestIdHttpServletRequest extends HttpServletRequestWrapper {

  private String xRequestId = null;

  public XRequestIdHttpServletRequest(HttpServletRequest request) {
    super(request);
  }

  public String getHeader(String name) {
    if (XRequestIdFilter.X_REQUEST_ID.equalsIgnoreCase(name)) {
      String value = super.getHeader(name);
      if (StringUtils.isEmpty(value)) {
        //理论上一个ServletRequest是分给一个线程处理的，不会有并发问题
        if (xRequestId == null) {
          xRequestId = UUID.randomUUID().toString();
        }
        return xRequestId;
      }
      return value;
    }
    return super.getHeader(name);
  }
}

