package com.megvii.face.core.url;

/**
 * Created by ZJ on 20/12/2017.
 */
public class Photo {

  /**
   * Url parameter photoId in regex format.
   * 大括号需要转义。
   */
  public static final String PARAM_ID = "\\{photoId\\}";

  /**
   * Get photo list.
   */
  public static final String GET_PHOTOS = "/photos";

  /**
   * Create a photo into a photoAlbum.
   */
  public static final String POST_PHOTOS = "/photos";

  /**
   * Delete a photo by photoId.
   */
  public static final String DELETE_PHOTOS_ID = "/photos/{photoId}";

  /**
   * Get a photo detail by photoId.
   */
  public static final String GET_PHOTOS_ID = "/photos/{photoId}";

  /**
   * Get photo stream data by photoId.
   */
  public static final String GET_PHOTOS_ID_DATA = "/photos/{photoId}/data";

}
