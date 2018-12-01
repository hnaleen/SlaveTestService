package com.hasa.controllers;

import com.hasa.services.SlaveTestService;
import org.junit.runner.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * - SlaveTestService -
 * @author Hasantha Alahakoon
 */
@RestController @RequestMapping(value = "/v1/tests")
public class SlaveTestServiceController
{
  @Autowired
  SlaveTestService testService;

  @RequestMapping(value = "/{testClass}/{testMethodName}", method = RequestMethod.GET)
  public Result run(
      @PathVariable("testClass") String testClass, @PathVariable("testMethodName") String testMethodName)
  {
    System.out.println("Test Class : " + testClass + " Test Method " + testMethodName);
    return testService.runTest(testClass, testMethodName);
  }
}
