//package com.epam.mentoring.webservices.config;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//
//public class ExecuteTimeInterceptor extends HandlerInterceptorAdapter {
//	private static final Logger logger = LogManager
//			.getLogger(ExecuteTimeInterceptor.class);
//	
//	private static final String START_TIME = "startTime";
//
//	public boolean preHandle(HttpServletRequest request,
//			HttpServletResponse response, Object handler) throws Exception {
//		long startTime = System.currentTimeMillis();
//		request.setAttribute(START_TIME, startTime);
//
//		return super.preHandle(request, response, handler);
//	}
//
//	public void postHandle(HttpServletRequest request,
//			HttpServletResponse response, Object handler,
//			ModelAndView modelAndView) throws Exception {
//		long startTime = (Long) request.getAttribute(START_TIME);
//		long endTime = System.currentTimeMillis();
//		long executeTime = endTime - startTime;
//
//		logger.info("[" + handler + "] Execute Time : " + executeTime + "ms");
//
//		super.postHandle(request, response, handler, modelAndView);
//	}
//}
