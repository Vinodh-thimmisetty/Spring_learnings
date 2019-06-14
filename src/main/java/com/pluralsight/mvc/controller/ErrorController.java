package com.pluralsight.mvc.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;

public class ErrorController {

	@GetMapping("/error")
	public String errorHandler(HttpServletRequest request) {
		String viewName = "error/";
		final Object httpStatusCode = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		if (httpStatusCode != null) {
			final Integer statusCode = Integer.valueOf(httpStatusCode.toString());
			if (HttpStatus.NOT_FOUND.value() == statusCode) {
				viewName += "error404";
			} else if (HttpStatus.FORBIDDEN.value() == statusCode) {
				viewName += "error403";
			} else {
				viewName += "error";
			}
		}
		return viewName;
	}

}
