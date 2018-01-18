package com.megvii.face.core;

import com.megvii.face.core.model.PageParam;

/**
 * Created by ZJ on 16/01/2018.
 */
public class Test {

  public static void main(String[] args) throws IllegalAccessException {
    PageParam pageParam = new PageParam(null, 2, 3);

//    CoreUriParamUtil.getCoreUri("",pageParam,null);

//    System.out.println(pageParam.getUriPageParamStr());
    String string = "asdsr";
    System.out.println(string.charAt(string.length()-1));
    System.out.println("r".equals(String.valueOf(string.charAt(string.length()-1))));

    System.out.println(string.lastIndexOf("r"));
    System.out.println(string.length());
  }

}
