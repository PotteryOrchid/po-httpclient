package com.po.uri;

/**
 * Created by ZJ on 03/01/2018.
 */
public class Job {

  /**
   * Uri parameter jobId.
   */
  public static final String PARAM_ID = "\\{jobId\\}";

  /**
   *
   */
  public static final String GET_JOBS = "/jobs";

  /**
   *
   */
  public static final String POST_JOBS = "/jobs";

  /**
   *
   */
  public static final String DELETE_JOBS_ID = "/jobs/{jobId}";

  /**
   *
   */
  public static final String GET_JOBS_ID = "/jobs/{jobId}";

  /**
   *
   */
  public static final String PATCH_JOBS_ID = "/jobs/{jobId}";

  /**
   *
   */
  public static final String POST_JOBS_ID_PAUSE = "/jobs/{jobId}/pause";

  /**
   *
   */
  public static final String POST_JOBS_ID_RESUME = "/jobs/{jobId}/resume";

}
