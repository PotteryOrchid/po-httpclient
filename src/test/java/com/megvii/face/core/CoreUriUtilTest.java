package com.megvii.face.core;

import static junit.framework.TestCase.assertEquals;

import com.megvii.face.core.model.UriParam;
import com.megvii.face.core.uri.ObjectStorage;
import com.megvii.face.core.utils.CoreUriUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by ZJ on 02/01/2018.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = FaceCoreApplication.class)
public class CoreUriUtilTest {

  @Test
  public void getRealUriTest() {

//    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//    Validator validator = factory.getValidator();

    UriParam bName = new UriParam(ObjectStorage.PARAM_BNAME, "");
    UriParam oName = new UriParam(ObjectStorage.PARAM_ONAME, "001");

//    Set<ConstraintViolation<UriParam>> constraintViolations =
//        validator.validate(bName);
//
//    System.out.println(constraintViolations.iterator().next().getMessage().toString());

    String uri = CoreUriUtil
        .getCoreUri(ObjectStorage.DELETE_OBJECTSTORAGE_BNAME_ONAME, bName, oName);
//    assertEquals("", uri.toString());

    System.out.println("Core uri: \n" + uri);
  }

}
