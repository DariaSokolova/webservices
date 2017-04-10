package com.epam.mentoring.webservices;

import static org.junit.Assert.assertNull;

import org.junit.Test;

public class GeneralTest {

	@Test
	public void test() {
		assertNull(null);
	}
	
	@Test
	public void test_fail() {
		assertNull("sdf");
	}
}
