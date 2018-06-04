package com.po.uri;

/**
 * Created by ZJ on 20/12/2017.
 */
public class Clip {

  /**
   * Uri parameter clipId in regex format.
   * 大括号需要转义。
   */
  public static final String PARAM_ID = "\\{clipId\\}";

  /**
   * Get a video clip detail by clipId.
   */
  public static final String GET_CLIPS_ID = "/clips/{clipId}";

  /**
   * Get video clip stream data by clipId.
   */
  public static final String GET_CLIPS_ID_DATA = "/clips/{clipId}/data";

}
