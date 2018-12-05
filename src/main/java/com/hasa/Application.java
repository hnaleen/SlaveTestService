package com.hasa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * - SlaveTestRunner -
 * @author Hasantha Alahakoon
 */
@SpringBootApplication
@EnableEurekaClient
public class Application
{
  public static void main(String[] args)
  {
    String libDirectory = System.getProperty("user.dir") + "\\target\\lib\\*";
    System.out.println("-+- Setting Test Runner Class path to : " + libDirectory);
    System.setProperty("processBuilderClassPath", libDirectory);
    SpringApplication.run(Application.class, args);
  }
}
