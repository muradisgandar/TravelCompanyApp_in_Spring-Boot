/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.main.controller;

import org.springframework.stereotype.Controller;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author murad_isgandar
 */
@Controller
public class ErrorHandlingController implements ErrorController {

    public ErrorHandlingController() {
    }

    @GetMapping(value = "/error")
    public String handleError(HttpServletRequest request) {

        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {

            Integer statusCode = Integer.valueOf(status.toString());

            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                return "error-404";
            }
        }
        return "error/error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }

}
