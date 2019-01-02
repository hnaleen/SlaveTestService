package com.hasa.services.tests;

import org.testng.xml.XmlSuite;
import se.cambio.test.runner.framework.executor.impl.local.TestNgTestExecutor;

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
