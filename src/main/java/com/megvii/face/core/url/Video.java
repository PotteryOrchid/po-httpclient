package com.megvii.face.core.url;

/**
 * Created by ZJ on 20/12/2017.
 */
public class Video {

  /**
   * Url parameter videoId in regex format.
   * 大括号需要转义。
   */
  public static final String PARAM_ID = "\\{videoId\\}";

  /**
   * Get video list.
   */
  public static final String GET_VIDEOS = "/videos";

  /**
   * Create video.
   */
  public static final String POST_VIDEOS = "/videos";

  /**
   * Delete video by videoId.
   */
  public static final String DELETE_VIDEOS_ID = "/videos/{videoId}";

  /**
   *
   */
  public static final String GET_VIDEOS_ID = "/videos/{videoId}";

  /**
   *
   */
  public static final String PATCH_VIDEOS_ID = "/videos/{videoId}";

  /**
   *
   */
  public static final String POST_VIDEOS_ID_PAUSE = "/videos/{videoId}/pause";

  /**
   *
   */
  public static final String POST_VIDEOS_ID_RESUME = "/videos/{videoId}/resume";

  /**
   *
   */
  public static final String GET_VIDEOS_ID_STATS = "/videos/{videoId}/stats";

}
