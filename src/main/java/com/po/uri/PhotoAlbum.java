package com.po.uri;

/**
 * Created by ZJ on 20/12/2017.
 */
public class PhotoAlbum {

  /**
   * Uri parameter photoAlbumId in regex format.
   * 大括号需要转义。
   */
  public static final String PARAM_ID = "\\{photoAlbumId\\}";

  /**
   * Get photoAlbum list.
   */
  public static final String GET_ALBUMS = "/photoAlbums";

  /**
   * Create a new photoAlbum.
   */
  public static final String POST_ALBUMS = "/photoAlbums";

  /**
   * Delete photoAlbum by photoAlbumId.
   */
  public static final String DELETE_ALBUMS_ID = "/photoAlbums/{photoAlbumId}";

  /**
   * Get a photoAlbum detail info by photoAlbumId.
   */
  public static final String GET_ALBUMS_ID = "/photoAlbums/{photoAlbumId}";

  /**
   * Update photoAlbum by photoAlbumId.
   */
  public static final String PATCH_ALBUMS_ID = "/photoAlbums/{photoAlbumId}";

  /**
   * Create photos in a album by photoAlbumId.
   */
  public static final String POST_ALBUMS_ID_ALLOCATE = "/photoAlbums/{photoAlbumId}/allocateIds";

  /**
   * Export photoAlbum diff file by photoAlbumId.
   */
  public static final String POST_ALBUMS_ID_EXPORT = "/photoAlbums/{photoAlbumId}/export";

  /**
   * Import photoAlbum diff file by photoAlbumId.
   */
  public static final String POST_ALBUMS_ID_IMPORT = "/photoAlbums/{photoAlbumId}/import";

  /**
   * Get photoAlbum status details by photoAlbumId.
   */
  public static final String GET_ALBUMS_ID_STATUS = "/photoAlbums/{photoAlbumId}/status";

}
