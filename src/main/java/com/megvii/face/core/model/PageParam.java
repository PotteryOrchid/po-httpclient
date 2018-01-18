package com.megvii.face.core.model;

import com.megvii.face.core.constant.HttpInfo;
import com.megvii.face.core.utils.StrUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

/**
 * Created by ZJ on 16/01/2018.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageParam {

  public String pageToken;

  public Integer pageOffset = 0;

  public Integer pageSize = 10;

  public String getUriPageParamStr() {

    if (StringUtils.isEmpty(pageToken)) {
      return StrUtil.getStr(HttpInfo.PAGE_OFFSET, pageOffset.toString(), HttpInfo.PARAM_AND,
          HttpInfo.PAGE_SIZE, pageSize.toString());
    } else {
      return StrUtil.getStr(HttpInfo.PAGE_TOKEN, pageToken, HttpInfo.PARAM_AND, HttpInfo.PAGE_SIZE,
          pageSize.toString());
    }
  }

}
