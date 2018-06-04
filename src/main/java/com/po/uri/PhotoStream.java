package com.po.uri;

/**
 * Created by ZJ on 20/12/2017.
 */
public class PhotoStream {

  /**
   * Uri parameter photoStreamId in regex format.
   * 大括号需要转义。
   */
  public static final String PARAM_ID = "\\{photoStreamId\\}";

  /**
   * Get photoStreams list.
   */
  public static final String GET_PHOTOSTREAMS = "/photoStreams";

  /**
   * Create a new photoStreams.
   */
  public static final String POST_PHOTOSTREAMS = "/photoStreams";

  /**
   * Delete photoStreams by photoStreamId.
   */
  public static final String DELETE_PHOTOSTREAMS_ID = "/photoStreams/{photoStreamId}";

  /**
   * Get a photoStream detail.
   */
  public static final String GET_PHOTOSTREAMS_ID = "/photoStreams/{photoStreamId}";

  /**
   * Update photoStream detail.
   */
  public static final String PATCH_PHOTOSTREAMS_ID = "/photoStreams/{photoStreamId}";

  /**
   * Get count number of passerby in last 24 hours.
   */
  public static final String GET_PHOTOSTREAMS_ID_STATS = "/photoStreams/{photoStreamId}/stats";

  /**
   * Close photo stream.
   */
  public static final String POST_PHOTOSTREAMS_ID_PAUSE = "/photoStreams/{photoStreamId}/pause";

  /**
   * Reopen photo stream.
   */
  public static final String POST_PHOTOSTREAMS_ID_RESUME = "/photoStreams/{photoStreamId}/resume";

}
