package System.Tests.IO;

import java.io.IOException;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import System.Managers.Ellementaries.Car;
import System.Persons.Employer;

public class JSONtoFileInFolderAndComeBack {

	Employer _testEmployer ;
	Employer _testEmployer1 ;
	Employer _testEmployer2 ;
	Employer _testEmployer3 ;
	LinkedList<Employer> _employers;
	Car _tempCar; 
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		_testEmployer = Employer.Instance;
		_tempCar = new Car("Ferrari","Spider",100);
	}

	@Test
	public void testWriteToFolderManyEmployers() throws IOException {	
		_testEmployer.addCar(_tempCar);	
		_testEmployer.SaveState();
	}
	
	@Test
	public void testReadFromFolderManyEmployers() {
		
	}
}
