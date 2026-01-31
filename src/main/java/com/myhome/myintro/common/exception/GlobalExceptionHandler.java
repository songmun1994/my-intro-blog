package com.myhome.myintro.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log =
            LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(
            Exception e,
            HttpServletRequest request
    ) {

        log.error("Unhandled exception - URI: {}", request.getRequestURI(), e);

        ModelAndView mv = new ModelAndView("common/error");
        return mv;
    }
}
