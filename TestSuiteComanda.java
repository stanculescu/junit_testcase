package ro.ase.cts.project.testcase;

import junit.framework.Test;
import junit.framework.TestSuite;

public class TestSuiteComanda {

	public static Test suite() {
		TestSuite suite = new TestSuite(TestSuiteComanda.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(TestComandaConstructor.class);
		suite.addTestSuite(TestComandaValoare.class);
		//$JUnit-END$
		return suite;
	}

}
