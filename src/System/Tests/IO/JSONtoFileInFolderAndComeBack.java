package System.Tests.IO;

import java.io.IOException;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import System.Managers.Ellementaries.Car;
import System.Persons.Employer;

// TODO: Auto-generated Javadoc
/**
 * The Class JSONtoFileInFolderAndComeBack.
 */
public class JSONtoFileInFolderAndComeBack {

	/** The _employers. */
	LinkedList<Employer> _employers;

	/** The _temp car. */
	Car _tempCar;

	/** The _test employer. */
	Employer _testEmployer;

	/** The _test employer1. */
	Employer _testEmployer1;

	/** The _test employer2. */
	Employer _testEmployer2;

	/** The _test employer3. */
	Employer _testEmployer3;

	/**
	 * Sets the up before class.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * Sets the up.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Before
	public void setUp() throws Exception {

		_testEmployer = Employer.Instance;
		_tempCar = new Car("Ferrari", "Spider", 100);
	}

	/**
	 * Test read from folder many employers.
	 */
	@Test
	public void testReadFromFolderManyEmployers() {

	}

	/**
	 * Test write to folder many employers.
	 *
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test
	public void testWriteToFolderManyEmployers() throws IOException {
		_testEmployer.addCar(_tempCar);
		_testEmployer.SaveState();
	}
}
