package com.po.uri;

/**
 * Created by ZJ on 20/12/2017.
 */
public class Face {

  /**
   * Uri parameter faceId in regex format.
   * 大括号需要转义。
   */
  public static final String PARAM_ID = "\\{faceId\\}";

  /**
   * Create face.
   */
  public static final String POST_FACES = "/faces";

  /**
   * Delete face by faceId.
   */
  public static final String DELETE_FACES_ID = "/faces/{faceId}";

  /**
   * Get face detail by faceId.
   */
  public static final String GET_FACES_ID = "/faces/{faceId}";

}
