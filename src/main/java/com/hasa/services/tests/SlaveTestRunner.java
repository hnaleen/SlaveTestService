package com.hasa.services.tests;

import org.testng.ITestResult;
import se.cambio.qa.multiprocess.testframework.dto.TestCaseResultDTO;
import se.cambio.qa.multiprocess.testframework.executor.TestExecutor;
import se.cambio.qa.multiprocess.testframework.executor.impl.remote.NewProcessTestExecutor;
import se.cambio.qa.multiprocess.testframework.reporter.AFTReporter;
import se.cambio.qa.multiprocess.testframework.runner.DelegatingTestRunner;

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
    AFTReporter.logs(resultDTO.getLogs(), false);
  }
}
