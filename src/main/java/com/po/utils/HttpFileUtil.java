package com.po.utils;

import com.po.constant.MsgInfo;
import com.po.filter.XRequestIdFilter;
import com.po.model.CoreRes;
import com.po.model.FailedBody;
import java.io.File;
import java.io.IOException;
import org.apache.http.HttpStatus;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

/**
 * HTTP request methods for Object Storage interface.
 * Created by ZJ on 11/01/2018.
 */
public class HttpFileUtil {

  Logger logger = LoggerFactory.getLogger(HttpFileUtil.class);

  /**
   * @param uri HTTP request uri.
   * @return All of the return data will be packaged in Class CoreRes. And return file data with Str
   * type in body.
   */
  public CoreRes doGet(String uri) {
    CloseableHttpClient httpclient = HttpClients.createDefault();
    try {
      HttpGet httpget = new HttpGet(uri);
      this.setHttpRequest(httpget);

      // Create a custom response handler
      ResponseHandler<CoreRes> responseHandler = new HttpResponseHandler()
          .getResponseHandlerWithBody();
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
   * @param file The file object to be uploaded to Object Storage.
   * @param clazz Class to define the return data type.
   * @return All of the return data will be packaged in Class CoreRes.
   */
  public CoreRes doPost(String uri, File file, Class clazz) {
    CloseableHttpClient httpclient = HttpClients.createDefault();
    try {
      HttpPost httpPost = new HttpPost(uri);
      this.setHttpRequest(httpPost);
      httpPost.setEntity(new FileEntity(file));

      // Create a custom response handler
      ResponseHandler<CoreRes> responseHandler = new HttpResponseHandler()
          .getResponseHandlerWithBody(clazz);
      return httpclient.execute(httpPost, responseHandler);
    } catch (IOException ioe) {
      logger.error(StrUtil
          .getStr(MsgInfo.SERVER_ERROR, MsgInfo.MSG_ENTER, HttpPost.METHOD_NAME, MsgInfo.MSG_SPACE,
              uri, MsgInfo.MSG_ENTER, file.getPath(), MsgInfo.MSG_ENTER, ioe.getMessage()));
      return new CoreRes(HttpStatus.SC_INTERNAL_SERVER_ERROR, null,
          new FailedBody(null, StrUtil
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
   * @param str The Str data to be uploaded to Object Storage.
   * @param clazz Class to define the return data type.
   * @return All of the return data will be packaged in Class CoreRes.
   */
  public CoreRes doPost(String uri, String str, Class clazz) {
    CloseableHttpClient httpclient = HttpClients.createDefault();
    try {
      HttpPost httpPost = new HttpPost(uri);
      this.setHttpRequest(httpPost);
      httpPost.setEntity(new StringEntity(str));

      // Create a custom response handler
      ResponseHandler<CoreRes> responseHandler = new HttpResponseHandler()
          .getResponseHandlerWithBody(clazz);
      return httpclient.execute(httpPost, responseHandler);
    } catch (IOException ioe) {
      logger.error(StrUtil
          .getStr(MsgInfo.SERVER_ERROR, MsgInfo.MSG_ENTER, HttpPost.METHOD_NAME, MsgInfo.MSG_SPACE,
              uri, MsgInfo.MSG_ENTER, ioe.getMessage()));
      return new CoreRes(HttpStatus.SC_INTERNAL_SERVER_ERROR, null,
          new FailedBody(null, StrUtil
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
   * @param bytes The byte data of file to be uploaded to Object Storage.
   * @param clazz Class to define the return data type.
   * @return All of the return data will be packaged in Class CoreRes.
   */
  public CoreRes doPost(String uri, byte[] bytes, Class clazz) {
    CloseableHttpClient httpclient = HttpClients.createDefault();
    try {
      HttpPost httpPost = new HttpPost(uri);
      this.setHttpRequest(httpPost);
      httpPost.setEntity(new ByteArrayEntity(bytes));

      // Create a custom response handler
      ResponseHandler<CoreRes> responseHandler = new HttpResponseHandler()
          .getResponseHandlerWithBody(clazz);
      return httpclient.execute(httpPost, responseHandler);
    } catch (IOException ioe) {
      logger.error(StrUtil
          .getStr(MsgInfo.SERVER_ERROR, MsgInfo.MSG_ENTER, HttpPost.METHOD_NAME, MsgInfo.MSG_SPACE,
              uri, MsgInfo.MSG_ENTER, ioe.getMessage()));
      return new CoreRes(HttpStatus.SC_INTERNAL_SERVER_ERROR, null,
          new FailedBody(null, StrUtil
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

  private void setHttpRequest(HttpRequestBase httpRequestBase) {
    httpRequestBase.setHeader("Content-type", "application/json;charset=UTF-8");

    String xRequestId = MDC.get(XRequestIdFilter.X_REQUEST_ID);
    if (null != xRequestId && !"".equals(xRequestId)) {
      httpRequestBase.addHeader(XRequestIdFilter.X_REQUEST_ID, xRequestId);
    }
  }

}
