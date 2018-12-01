package com.hasa.services;

import org.junit.internal.requests.FilterRequest;
import org.junit.runner.Description;
import org.junit.runner.JUnitCore;
import org.junit.runner.Request;
import org.junit.runner.Result;
import org.junit.runner.manipulation.Filter;
import org.springframework.stereotype.Service;
import se.cambio.qa.multiprocess.testframework.runner.DelegatingTestRunner;

/**
 * - SlaveTestService -
 * @author Hasantha Alahakoon
 */
@Service
public class SlaveTestService
{
  public Result runTest(String testClassName, String testMethodName)
  {
    Result testResult = null;
    try
    {
      Class testClass = Class.forName(testClassName);
      testResult = new JUnitCore().run(new FilterRequest(Request.runner(new DelegatingTestRunner(testClass)),
          Filter.matchMethodDescription(Description.createTestDescription(testClass, testMethodName))));
    }
    catch (Exception e)
    {
      e.printStackTrace(); //TODO
    }
    return testResult;
  }
}
