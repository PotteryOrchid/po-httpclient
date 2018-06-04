package com.po.utils;

import com.alibaba.fastjson.JSON;
import com.po.model.CoreRes;
import com.po.model.FailedBody;
import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ResponseHandler;
import org.apache.http.util.EntityUtils;

/**
 * Created by ZJ on 31/01/2018.
 */
public class HttpResponseHandler {

  /**
   * Get ResponseHandler with body.
   *
   * @return ResponseHandler<CoreRes>
   */
  protected ResponseHandler<CoreRes> getResponseHandlerWithBody(Class clazz) {
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
   * For ResponseHandler without body.
   */
  protected ResponseHandler<CoreRes> getResponseHandlerOutBody() {
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

  /**
   * For GET Http File Request.
   */
  protected ResponseHandler<CoreRes> getResponseHandlerWithBody() {
    return new ResponseHandler<CoreRes>() {
      @Override
      public CoreRes handleResponse(
          final HttpResponse response) throws IOException {

        int status = response.getStatusLine().getStatusCode();
        HttpEntity entity = response.getEntity();

        CoreRes coreRes = new CoreRes();
        coreRes.setStatus(status);

        if (HttpStatus.SC_OK == status) {
          coreRes.setBody(EntityUtils.toString(entity));
        } else {
          coreRes.setFailedBody(
              JSON.parseObject(entity != null ? EntityUtils.toString(entity) : null,
                  FailedBody.class));
        }
        return coreRes;
      }
    };
  }

}
