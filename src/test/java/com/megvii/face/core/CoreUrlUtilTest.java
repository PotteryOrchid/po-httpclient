package com.megvii.face.core;

import static junit.framework.TestCase.assertEquals;

import com.megvii.face.core.exception.EmptyException;
import com.megvii.face.core.model.UrlParam;
import com.megvii.face.core.url.ObjectStorage;
import com.megvii.face.core.utils.CoreUrlUtil;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by ZJ on 02/01/2018.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = FaceCoreApplication.class)
public class CoreUrlUtilTest {

  @Test
  public void getRealUrlTest() {

//    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//    Validator validator = factory.getValidator();

    UrlParam bName = new UrlParam(ObjectStorage.PARAM_BNAME, "");
    UrlParam oName = new UrlParam(ObjectStorage.PARAM_ONAME, "001");

//    Set<ConstraintViolation<UrlParam>> constraintViolations =
//        validator.validate(bName);
//
//    System.out.println(constraintViolations.iterator().next().getMessage().toString());

    String url = CoreUrlUtil
        .getRealUrl(ObjectStorage.DELETE_OBJECTSTORAGE_BNAME_ONAME, bName, oName);
//    assertEquals("", url.toString());
    System.out.println(url);
  }

}
