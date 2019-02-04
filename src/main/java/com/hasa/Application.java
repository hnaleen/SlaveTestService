package com.hasa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.io.File;
import java.net.URL;

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
    System.setProperty("java.awt.headless", "false");
    System.setProperty("headless-mode", "OFF"); //TODO Parameterize this for docker

    String libDirectory = System.getProperty("user.dir") + "/target/lib/*";
    System.out.println("-+- Setting Test Runner Class path to : " + libDirectory);
    System.setProperty("processBuilderClassPath", libDirectory);

    URL chromeDriverFolder = Application.class.getClassLoader().getResource("drivers");
    String exePath = getExecutableFilePath();
    String chromeDriverExePath = new File(chromeDriverFolder.getFile()).getAbsolutePath() + "/" + exePath;
    System.out.println("-+- Setting Chrome Driver path to : " + chromeDriverExePath);
    System.setProperty("web_driver_path", chromeDriverExePath);

    System.setProperty("implicit", "50000"); // TODO Parameterize this
    SpringApplication.run(Application.class, args);
  }

  private static String getExecutableFilePath()
  {
    String path = "";
    if (isWindows())
    {
      path = "windows/chromedriver.exe";
    }
    else
    {
      path = "linux/chromedriver";
    }
    return path;
  }

  private static boolean isWindows()
  {
    return System.getProperty("os.name").contains("Windows");
  }
}
