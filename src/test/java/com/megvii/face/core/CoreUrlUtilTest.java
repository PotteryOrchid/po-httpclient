package com.megvii.face.core;

import static junit.framework.TestCase.assertEquals;

import com.megvii.face.core.model.UrlParam;
import com.megvii.face.core.url.ObjectStorage;
import com.megvii.face.core.utils.CoreUrlUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by ZJ on 02/01/2018.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(com.megvii.face.core.utils.CoreUrlUtil.class)
public class CoreUrlUtilTest {

  @Test
  public void getRealUrlTest() {
    UrlParam bName = new UrlParam(ObjectStorage.PARAM_BNAME, "001");
    UrlParam oName = new UrlParam(ObjectStorage.PARAM_ONAME, "001");

    String url = CoreUrlUtil
        .getRealUrl(ObjectStorage.DELETE_OBJECTSTORAGE_BNAME_ONAME, bName, oName);
    assertEquals("", url.toString());
  }

}
