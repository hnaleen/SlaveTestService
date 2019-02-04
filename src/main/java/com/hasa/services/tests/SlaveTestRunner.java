package com.hasa.services.tests;

import org.testng.ITestResult;
import se.cambio.test.runner.framework.dto.TestCaseResultDTO;
import se.cambio.test.runner.framework.executor.TestExecutor;
import se.cambio.test.runner.framework.executor.impl.local.TestNgTestExecutor;
import se.cambio.test.runner.framework.executor.impl.remote.NewProcessTestExecutor;
import se.cambio.test.runner.framework.runner.DelegatingTestRunner;

/**
 * - SlaveTestService -
 * @author Hasantha Alahakoon 
 */
public class SlaveTestRunner extends DelegatingTestRunner
{
  @Override protected TestExecutor getTestExecutor(int testCount)
  {
    return new NewProcessTestExecutor();
  }

  @Override protected void handleLogs(TestCaseResultDTO resultDTO, ITestResult testResult)
  {
//    AFTReporter.logs(resultDTO.getLogs(), false); //TODO Fix logging
  }
}
