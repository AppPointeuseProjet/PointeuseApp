package com.pointeuse.jdbc.test;



import org.junit.*;

import static org.junit.Assert.*;


import com.pointeuse.jdbc.DaoH2;

public class DaoH2Test {

	private DaoH2 daoh2 = new DaoH2();
	private String name = "toto";
	@Test
	public void verifyExistEmployerNameReturnTrue(){
	  daoh2.connect();
	  assertEquals(true, daoh2.verifyExistEmployer(name));
	  daoh2.disconnect();
	}
}
