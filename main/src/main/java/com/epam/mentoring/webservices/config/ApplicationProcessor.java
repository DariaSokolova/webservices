package com.epam.mentoring.webservices.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class ApplicationProcessor implements BeanPostProcessor {
	private static final Logger logger = LogManager
			.getLogger(ExecuteTimeInterceptor.class);

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		logger.info(beanName + ": beforeInitialization.");
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		logger.info(beanName + ": afterInitialization");
		return bean;
	}

}
