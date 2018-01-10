/**
 * 〈一句话功能简述〉 * 〈功能详细描述〉
 *
 * @author ZJ
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 * @deprecated （可选）
 */

package com.megvii.face.core;

import java.io.Serializable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.megvii.face.core"})
public class FaceCoreApplication implements Serializable {

  public static void main(String[] args) {
    SpringApplication.run(FaceCoreApplication.class, args);
  }

}
