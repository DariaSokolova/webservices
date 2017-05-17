package com.epam.mentoring.webservices.test;

import org.junit.Ignore;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;

@TestExecutionListeners({ //DbUnitTestExecutionListener.class,
		DependencyInjectionTestExecutionListener.class,
		TransactionDbUnitTestExecutionListener.class })
@Ignore
public class AbstractDBUnitTest extends AbstractDBTest {

}
