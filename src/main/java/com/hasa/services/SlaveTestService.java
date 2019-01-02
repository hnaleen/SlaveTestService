package com.hasa.services;

import com.hasa.services.tests.SlaveTestExecutor;
import org.springframework.stereotype.Service;
import se.cambio.test.runner.framework.dto.TestCaseResultDTO;

/**
 * - SlaveTestService -
 * @author Hasantha Alahakoon
 */
@Service public class SlaveTestService
{
  public TestCaseResultDTO runTest(String testClassName, String testMethodName)
  {
    TestCaseResultDTO result = new SlaveTestExecutor().execute(testClassName, testMethodName);
    return result;
  }
}
