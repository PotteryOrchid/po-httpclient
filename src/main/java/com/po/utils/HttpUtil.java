package com.po.utils;

import com.po.constant.HttpInfo;
import com.po.constant.MsgInfo;
import com.po.filter.XRequestIdFilter;
import com.po.model.CoreRes;
import com.po.model.FailedBody;
import java.io.IOException;
import org.apache.http.HttpStatus;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

/**
 * Universal HTTP request methods.
 * Created by ZJ on 11/01/2018.
 */
public class HttpUtil {

  Logger logger = LoggerFactory.getLogger(HttpUtil.class);

  /**
   * @param uri HTTP request uri.
   * @param clazz Class to define the return data type.
   * @return All of the return data will be packaged in Class CoreRes.
   */
  public CoreRes doGet(String uri, Class clazz) {
    CloseableHttpClient httpclient = HttpClients.createDefault();
    try {
      HttpGet httpget = new HttpGet(uri);
      this.setHttpRequest(httpget);

      // Create a custom response handler
      ResponseHandler<CoreRes> responseHandler = new HttpResponseHandler()
          .getResponseHandlerWithBody(clazz);
      return httpclient.execute(httpget, responseHandler);
    } catch (IOException ioe) {
      logger.error(StrUtil
          .getStr(MsgInfo.SERVER_ERROR, MsgInfo.MSG_ENTER, HttpGet.METHOD_NAME, MsgInfo.MSG_SPACE,
              uri, MsgInfo.MSG_ENTER, ioe.getMessage()));
      return new CoreRes(HttpStatus.SC_INTERNAL_SERVER_ERROR, null, new FailedBody(null, StrUtil
          .getStr(MsgInfo.SERVER_ERROR, MsgInfo.MSG_SPACE, HttpGet.METHOD_NAME,
              MsgInfo.MSG_SPACE, uri), null));
    } finally {
      try {
        httpclient.close();
      } catch (IOException ioe) {
        ioe.printStackTrace();
      }
    }
  }

  /**
   * @param uri HTTP request uri.
   * @param body HTTP request body.
   * @param clazz Class to define the return data type.
   * @return All of the return data will be packaged in Class CoreRes.
   */
  public CoreRes doPost(String uri, String body, Class clazz) {
    CloseableHttpClient httpclient = HttpClients.createDefault();
    try {
      HttpPost httpPost = new HttpPost(uri);
      this.setHttpRequest(httpPost);
      httpPost.setEntity(new StringEntity(body, HttpInfo.ENCODING));

      // Create a custom response handler
      ResponseHandler<CoreRes> responseHandler = new HttpResponseHandler()
          .getResponseHandlerWithBody(clazz);
      return httpclient.execute(httpPost, responseHandler);
    } catch (IOException ioe) {
      logger.error(StrUtil
          .getStr(MsgInfo.SERVER_ERROR, MsgInfo.MSG_ENTER, HttpPost.METHOD_NAME, MsgInfo.MSG_SPACE,
              uri, MsgInfo.MSG_ENTER, body, MsgInfo.MSG_ENTER, ioe.getMessage()));
      return new CoreRes(HttpStatus.SC_INTERNAL_SERVER_ERROR, null, new FailedBody(null, StrUtil
          .getStr(MsgInfo.SERVER_ERROR, MsgInfo.MSG_SPACE, HttpPost.METHOD_NAME,
              MsgInfo.MSG_SPACE, uri), null));
    } finally {
      try {
        httpclient.close();
      } catch (IOException ioe) {
        ioe.printStackTrace();
      }
    }
  }

  /**
   * @param uri HTTP request uri.
   * @param body HTTP request body.
   * @param clazz Class to define the return data type.
   * @return All of the return data will be packaged in Class CoreRes.
   */
  public CoreRes doPatch(String uri, String body, Class clazz) {
    CloseableHttpClient httpclient = HttpClients.createDefault();
    try {
      HttpPatch httpPatch = new HttpPatch(uri);
      this.setHttpRequest(httpPatch);
      httpPatch.setEntity(new StringEntity(body, HttpInfo.ENCODING));

      // Create a custom response handler
      ResponseHandler<CoreRes> responseHandler = new HttpResponseHandler()
          .getResponseHandlerWithBody(clazz);
      return httpclient.execute(httpPatch, responseHandler);
    } catch (IOException ioe) {
      logger.error(StrUtil
          .getStr(MsgInfo.SERVER_ERROR, MsgInfo.MSG_ENTER, HttpPatch.METHOD_NAME, MsgInfo.MSG_SPACE,
              uri, MsgInfo.MSG_ENTER, body, MsgInfo.MSG_ENTER, ioe.getMessage()));
      return new CoreRes(HttpStatus.SC_INTERNAL_SERVER_ERROR, null, new FailedBody(null, StrUtil
          .getStr(MsgInfo.SERVER_ERROR, MsgInfo.MSG_SPACE, HttpPatch.METHOD_NAME,
              MsgInfo.MSG_SPACE, uri), null));
    } finally {
      try {
        httpclient.close();
      } catch (IOException ioe) {
        ioe.printStackTrace();
      }
    }
  }

  /**
   * @param uri HTTP request uri.
   * @return All of the return data will be packaged in Class CoreRes.
   */
  public CoreRes doDelete(String uri) {
    CloseableHttpClient httpclient = HttpClients.createDefault();
    try {
      HttpDelete httpDelete = new HttpDelete(uri);
      this.setHttpRequest(httpDelete);

      // Create a custom response handler
      ResponseHandler<CoreRes> responseHandler = new HttpResponseHandler()
          .getResponseHandlerOutBody();
      return httpclient.execute(httpDelete, responseHandler);
    } catch (IOException ioe) {
      logger.error(StrUtil
          .getStr(MsgInfo.SERVER_ERROR, MsgInfo.MSG_ENTER, HttpDelete.METHOD_NAME,
              MsgInfo.MSG_SPACE, uri, MsgInfo.MSG_ENTER, ioe.getMessage()));
      return new CoreRes(HttpStatus.SC_INTERNAL_SERVER_ERROR, null, new FailedBody(null, StrUtil
          .getStr(MsgInfo.SERVER_ERROR, MsgInfo.MSG_SPACE, HttpDelete.METHOD_NAME,
              MsgInfo.MSG_SPACE, uri), null));
    } finally {
      try {
        httpclient.close();
      } catch (IOException ioe) {
        ioe.printStackTrace();
      }
    }
  }

  private void setHttpRequest(HttpRequestBase httpRequestBase) {
    httpRequestBase.setHeader("Content-type", "application/json;charset=UTF-8");

    String xRequestId = MDC.get(XRequestIdFilter.X_REQUEST_ID);
    if (null != xRequestId && !"".equals(xRequestId)) {
      httpRequestBase.addHeader(XRequestIdFilter.X_REQUEST_ID, xRequestId);
    }
  }

}
