package com.megvii.face.core.url;

/**
 * Created by ZJ on 20/12/2017.
 */
public class Pubsub {

  /**
   * Url parameter subscriptionName in regex format.
   * 大括号需要转义。
   */
  public static final String PARAM_SNAME = "\\{subscriptionName\\}";

  /**
   * Url parameter topicName in regex format.
   * 大括号需要转义。
   */
  public static final String PARAM_TNAME = "\\{topicName\\}";

  /**
   *
   */
  public static final String GET_SUBSCRIPTIONS = "/subscriptions";

  /**
   *
   */
  public static final String POST_SUBSCRIPTIONS = "/subscriptions";

  /**
   *
   */
  public static final String DELETE_SUBSCRIPTIONS_NAME = "/subscriptions/{subscriptionName}";

  /**
   *
   */
  public static final String GET_SUBSCRIPTIONS_NAME = "/subscriptions/{subscriptionName}";

  /**
   *
   */
  public static final String PATCH_SUBSCRIPTIONS_NAME = "/subscriptions/{subscriptionName}";

  /**
   *
   */
  public static final String GET_SUBSCRIPTIONS_NAME_MSGS = "/subscriptions/{subscriptionName}/messages";

  /**
   *
   */
  public static final String POST_SUBSCRIPTIONS_NAME_MSGS_ACK = "/subscriptions/{subscriptionName}/messages/acknowledge";

  /**
   *
   */
  public static final String GET_TOPICS = "／topics";

  /**
   *
   */
  public static final String POST_TOPICS = "/topics";

  /**
   *
   */
  public static final String DELETE_TOPICS_NAME = "/topics/{topicName}";

  /**
   *
   */
  public static final String PATCH_TOPICS_NAME = "/topics/{topicName}";

  /**
   *
   */
  public static final String GET_TOPICS_NAME = "/topics/{topicName}";

  /**
   *
   */
  public static final String GET_TOPICS_NAME_SUBS = "/topics/{topicName}/subscriptions";

}
