package com.po.filter;

/**
 * Created by ZJ on 18/01/2018.
 */

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.MDC;

public class XRequestIdFilter implements Filter {

  public static final String X_REQUEST_ID = "X-Request-Id";

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequestWrapper httpServletRequestWrapper = new XRequestIdHttpServletRequest(
        (HttpServletRequest) servletRequest);
    String xRequestId = httpServletRequestWrapper.getHeader(X_REQUEST_ID);
    ((HttpServletResponse) servletResponse).addHeader(X_REQUEST_ID, xRequestId);
    MDC.put(X_REQUEST_ID, xRequestId);
    filterChain.doFilter(httpServletRequestWrapper, servletResponse);
    MDC.remove(X_REQUEST_ID);
  }

  @Override
  public void destroy() {
  }
}