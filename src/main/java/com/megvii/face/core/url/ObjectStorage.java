package com.megvii.face.core.url;

/**
 * Created by ZJ on 04/01/2018.
 */
public class ObjectStorage {

  /**
   * Url parameter bucketName in regex format.
   * 大括号需要转义。
   */
  public static final String PARAM_BNAME = "\\{bucketName\\}";

  /**
   * Url parameter objectName in regex format.
   * 大括号需要转义。
   */
  public static final String PARAM_ONAME = "\\{objectName\\}";

  /**
   *
   */
  public static final String GET_OBJECTSTORAGE = "/objectStorage";

  /**
   *
   */
  public static final String POST_OBJECTSTORAGE = "/objectStorage";

  /**
   *
   */
  public static final String DELETE_OBJECTSTORAGE_BNAME = "/objectStorage/{bucketName}";

  /**
   *
   */
  public static final String POST_OBJECTSTORAGE_BNAME = "/objectStorage/{bucketName}";

  /**
   *
   */
  public static final String DELETE_OBJECTSTORAGE_BNAME_ONAME = "/objectStorage/{bucketName}/{objectName}";

  /**
   *
   */
  public static final String GET_OBJECTSTORAGE_BNAME_ONAME = "/objectStorage/{bucketName}/{objectName}";

}
