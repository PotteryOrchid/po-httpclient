package com.po.model;

import com.po.constant.HttpInfo;
import com.po.utils.StrUtil;
import java.io.Serializable;
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
public class PageParam implements Serializable {

  private static final long serialVersionUID = 1L;

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
