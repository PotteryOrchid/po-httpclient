package com.megvii.face.core.utils;

import com.megvii.face.core.constant.HttpInfo;
import com.megvii.face.core.constant.MsgInfo;
import com.megvii.face.core.model.HttpRes;
import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by ZJ on 11/01/2018.
 */
public class HttpUtil {

  Logger logger = LoggerFactory.getLogger(HttpUtil.class);

  public HttpRes doGet(String uri) {
    CloseableHttpClient httpclient = HttpClients.createDefault();
    try {
      HttpGet httpget = new HttpGet(uri);

      // Create a custom response handler
      ResponseHandler<HttpRes> responseHandler = new ResponseHandler<HttpRes>() {
        @Override
        public HttpRes handleResponse(
            final HttpResponse response) throws IOException {
          HttpEntity entity = response.getEntity();
          return HttpRes
              .getInstance(response.getStatusLine().getStatusCode(),
                  entity != null ? EntityUtils.toString(entity) : null);
        }
      };

      return httpclient.execute(httpget, responseHandler);
    } catch (IOException ioe) {
      logger.warn(StrUtil
          .getStr(MsgInfo.SERVER_ERROR, MsgInfo.MSG_ENTER, uri, MsgInfo.MSG_ENTER, ioe.getMessage()));
      return HttpRes.getInstance(HttpStatus.SC_INTERNAL_SERVER_ERROR, ioe.getMessage());
    } finally {
      try {
        httpclient.close();
      } catch (IOException ioe) {
        ioe.printStackTrace();
      }
    }
  }

  public HttpRes doPost(String uri, String body) {
    CloseableHttpClient httpclient = HttpClients.createDefault();
    try {
      HttpPost httpPost = new HttpPost(uri);

      httpPost.setEntity(new StringEntity(body,HttpInfo.ENCODING));

      // Create a custom response handler
      ResponseHandler<HttpRes> responseHandler = new ResponseHandler<HttpRes>() {
        @Override
        public HttpRes handleResponse(
            final HttpResponse response) throws IOException {
          HttpEntity entity = response.getEntity();
          return HttpRes
              .getInstance(response.getStatusLine().getStatusCode(),
                  entity != null ? EntityUtils.toString(entity) : null);
        }
      };

      return httpclient.execute(httpPost, responseHandler);
    } catch (IOException ioe) {
      logger.warn(StrUtil
          .getStr(MsgInfo.SERVER_ERROR, MsgInfo.MSG_ENTER, uri, MsgInfo.MSG_ENTER, ioe.getMessage()));
      return HttpRes.getInstance(HttpStatus.SC_INTERNAL_SERVER_ERROR, ioe.getMessage());
    } finally {
      try {
        httpclient.close();
      } catch (IOException ioe) {
        ioe.printStackTrace();
      }
    }
  }

  public Object doPatch() {
    return null;
  }

  public Object doDelete() {
    return null;
  }

}
