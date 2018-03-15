package com.megvii.face.core.utils;

import java.io.IOException;
import java.util.concurrent.Callable;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * Created by ZJ on 07/03/2018.
 */
class PhotoBytesCallable implements Callable<PhotoBytesRes> {

  private String url;

  public PhotoBytesCallable(String url) {
    this.url = url;
  }

  @Override
  public PhotoBytesRes call() {

    PhotoBytesRes photoBytesRes = new PhotoBytesRes();

    CloseableHttpClient httpclient = HttpClients.createDefault();
    try {
      HttpGet httpget = new HttpGet(url);
      photoBytesRes.setUrl(url);

      // Create a custom response handler
      ResponseHandler<byte[]> responseHandler = new ResponseHandler<byte[]>() {

        @Override
        public byte[] handleResponse(
            final HttpResponse response) throws IOException {
          int status = response.getStatusLine().getStatusCode();
          if (status == 200) {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
              byte[] bytes = EntityUtils.toByteArray(entity);
              return bytes;
            }
            return null;
          } else {
            throw new IOException("Unexpected response status: " + status);
          }
        }
      };

      photoBytesRes.setBytes(httpclient.execute(httpget, responseHandler));
      return photoBytesRes;
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        httpclient.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return null;
  }

}
