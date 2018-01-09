package com.megvii.face.core.url;

/**
 * Created by ZJ on 20/12/2017.
 */
public class FaceGroup {

  /**
   * Url parameter faceGroupId in regex format.
   * 大括号需要转义。
   */
  public static final String PARAM_ID = "\\{faceGroupI\\}";

  /**
   *
   */
  public static final String GET_FACEGROUPS = "/faceGroups";

  /**
   *
   */
  public static final String GET_FACEGROUPS_ID = "/faceGroups/{faceGroupId}";

}
