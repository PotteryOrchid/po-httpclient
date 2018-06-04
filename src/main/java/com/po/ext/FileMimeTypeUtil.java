package com.po.ext;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import org.apache.tika.exception.TikaException;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;
import org.apache.tika.mime.MimeTypes;
import org.apache.tika.mime.MimeTypesFactory;

/**
 * Created by ZJ on 09/02/2018.
 */
public class FileMimeTypeUtil {

  private Metadata metadata;
  private URL url;

  public FileMimeTypeUtil() {
    metadata = new Metadata();
    url = Thread.currentThread().getContextClassLoader().getResource("megvii-mimetypes.xml");
  }

  /**
   * Return file mediaType.
   *
   * @param file File
   * @return MediaType
   * @throws TikaException in detect method.
   * @throws IOException if file is not exist.
   */
  public MediaType getFileMimeType(File file) throws TikaException, IOException {
    // Defined metadata
    metadata.add(Metadata.RESOURCE_NAME_KEY, file.getName());
    MimeTypes mimeTypes = MimeTypesFactory.create(url);

    return mimeTypes
        .detect(TikaInputStream.get(new FileInputStream(file)), metadata);
  }

  /**
   * Return file mediaType Str.
   *
   * @param file File
   * @return MediaType
   * @throws TikaException in detect method.
   * @throws IOException if file is not exist.
   */
  public String getFileMimeTypeStr(File file) throws TikaException, IOException {
    return this.getFileMimeType(file).toString();
  }

}
