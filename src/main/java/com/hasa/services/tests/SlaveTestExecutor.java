package com.hasa.services.tests;

import org.testng.xml.XmlSuite;
import se.cambio.qa.multiprocess.testframework.executor.impl.local.TestNgTestExecutor;
import se.cambio.qa.multiprocess.testframework.runner.DelegatingTestRunner;

/**
 * - SlaveTestService -
 * @author Hasantha Alahakoon 
 */
public class SlaveTestExecutor extends TestNgTestExecutor
{
  @Override protected XmlSuite createTemporaryTestSuite(String testClassName, String testMethodName) throws Exception
  {
    XmlSuite temporaryTestSuite = super.createTemporaryTestSuite(testClassName, testMethodName);
    temporaryTestSuite.addListener(SlaveTestRunner.class.getName());
    return temporaryTestSuite;
  }
}
