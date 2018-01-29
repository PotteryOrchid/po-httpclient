package com.megvii.face.core.utils;

import com.alibaba.fastjson.JSON;
import com.megvii.face.core.constant.HttpInfo;
import com.megvii.face.core.constant.MsgInfo;
import com.megvii.face.core.filter.XRequestIdFilter;
import com.megvii.face.core.model.FailedBody;
import com.megvii.face.core.model.CoreRes;
import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
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
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

/**
 * Created by ZJ on 11/01/2018.
 */
public class HttpUtil {

  Logger logger = LoggerFactory.getLogger(HttpUtil.class);

  public CoreRes doGet(String uri, Class clazz) {
    CloseableHttpClient httpclient = HttpClients.createDefault();
    try {
      HttpGet httpget = new HttpGet(uri);
      this.setHttpRequest(httpget);

      // Create a custom response handler
      ResponseHandler<CoreRes> responseHandler = getCoreResResponseHandler(clazz);
      return httpclient.execute(httpget, responseHandler);
    } catch (IOException ioe) {
      logger.error(StrUtil
          .getStr(MsgInfo.SERVER_ERROR, MsgInfo.MSG_ENTER, HttpGet.METHOD_NAME, MsgInfo.MSG_SPACE,
              uri, MsgInfo.MSG_ENTER, ioe.getMessage()));
      return new CoreRes(HttpStatus.SC_INTERNAL_SERVER_ERROR, null, null);
    } finally {
      try {
        httpclient.close();
      } catch (IOException ioe) {
        ioe.printStackTrace();
      }
    }
  }

  public CoreRes doPost(String uri, String body, Class clazz) {
    CloseableHttpClient httpclient = HttpClients.createDefault();
    try {
      HttpPost httpPost = new HttpPost(uri);
      this.setHttpRequest(httpPost);
      httpPost.setEntity(new StringEntity(body, HttpInfo.ENCODING));

      // Create a custom response handler
      ResponseHandler<CoreRes> responseHandler = getCoreResResponseHandler(clazz);
      return httpclient.execute(httpPost, responseHandler);
    } catch (IOException ioe) {
      logger.error(StrUtil
          .getStr(MsgInfo.SERVER_ERROR, MsgInfo.MSG_ENTER, HttpPost.METHOD_NAME, MsgInfo.MSG_SPACE,
              uri, MsgInfo.MSG_ENTER, body, MsgInfo.MSG_ENTER, ioe.getMessage()));
      return new CoreRes(HttpStatus.SC_INTERNAL_SERVER_ERROR, null, null);
    } finally {
      try {
        httpclient.close();
      } catch (IOException ioe) {
        ioe.printStackTrace();
      }
    }
  }

  public CoreRes doPatch(String uri, String body, Class clazz) {
    CloseableHttpClient httpclient = HttpClients.createDefault();
    try {
      HttpPatch httpPatch = new HttpPatch(uri);
      this.setHttpRequest(httpPatch);
      httpPatch.setEntity(new StringEntity(body, HttpInfo.ENCODING));

      // Create a custom response handler
      ResponseHandler<CoreRes> responseHandler = getCoreResResponseHandler(clazz);
      return httpclient.execute(httpPatch, responseHandler);
    } catch (IOException ioe) {
      logger.error(StrUtil
          .getStr(MsgInfo.SERVER_ERROR, MsgInfo.MSG_ENTER, HttpPatch.METHOD_NAME, MsgInfo.MSG_SPACE,
              uri, MsgInfo.MSG_ENTER, body, MsgInfo.MSG_ENTER, ioe.getMessage()));
      return new CoreRes(HttpStatus.SC_INTERNAL_SERVER_ERROR, null, null);
    } finally {
      try {
        httpclient.close();
      } catch (IOException ioe) {
        ioe.printStackTrace();
      }
    }
  }

  public CoreRes doDelete(String uri) {
    CloseableHttpClient httpclient = HttpClients.createDefault();
    try {
      HttpDelete httpDelete = new HttpDelete(uri);
      this.setHttpRequest(httpDelete);

      // Create a custom response handler
      ResponseHandler<CoreRes> responseHandler = getCoreResResponseHandler();
      return httpclient.execute(httpDelete, responseHandler);
    } catch (IOException ioe) {
      logger.error(StrUtil
          .getStr(MsgInfo.SERVER_ERROR, MsgInfo.MSG_ENTER, HttpDelete.METHOD_NAME,
              MsgInfo.MSG_SPACE, uri, MsgInfo.MSG_ENTER, ioe.getMessage()));
      return new CoreRes(HttpStatus.SC_INTERNAL_SERVER_ERROR, null, null);
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

  private ResponseHandler<CoreRes> getCoreResResponseHandler(Class clazz) {
    return new ResponseHandler<CoreRes>() {
      @Override
      public CoreRes handleResponse(
          final HttpResponse response) throws IOException {

        int status = response.getStatusLine().getStatusCode();
        HttpEntity entity = response.getEntity();

        CoreRes coreRes = new CoreRes();
        coreRes.setStatus(status);

        if (HttpStatus.SC_OK == status) {
          coreRes.setBody(
              JSON.parseObject(entity != null ? EntityUtils.toString(entity) : null, clazz));
        } else {
          coreRes.setFailedBody(
              JSON.parseObject(entity != null ? EntityUtils.toString(entity) : null,
                  FailedBody.class));
        }
        return coreRes;
      }
    };
  }

  /**
   * For Http DELETE Request.
   */
  private ResponseHandler<CoreRes> getCoreResResponseHandler() {
    return new ResponseHandler<CoreRes>() {
      @Override
      public CoreRes handleResponse(
          final HttpResponse response) throws IOException {

        int status = response.getStatusLine().getStatusCode();
        HttpEntity entity = response.getEntity();

        CoreRes coreRes = new CoreRes();
        coreRes.setStatus(status);
        coreRes.setBody(null);

        if (HttpStatus.SC_OK != status) {
          coreRes.setFailedBody(
              JSON.parseObject(entity != null ? EntityUtils.toString(entity) : null,
                  FailedBody.class));
        }
        return coreRes;
      }
    };
  }

}
