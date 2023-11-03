package com.example.sfj_springboot.controller;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.Map;

@Controller
public class ErrorPageController implements ErrorController {

    private static final String ERR_PATH="/error";
    private ErrorAttributes errorAttributes;

    public ErrorPageController(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    @RequestMapping(ERR_PATH)
    public String error(Model model, HttpServletRequest request){
        String resultPage = "detailedError";
        ServletWebRequest requestAttribute = new ServletWebRequest(request);
        Map<String, Object> error = this.errorAttributes.getErrorAttributes(requestAttribute, ErrorAttributeOptions.defaults());

        model.addAttribute("timestamp", error.get("timestamp"));
        model.addAttribute("error", error.get("error"));
        model.addAttribute("message", error.get("message"));
        model.addAttribute("path", error.get("path"));
        model.addAttribute("status", error.get("status"));

        if((int) error.get("status") == 404){
            resultPage = pageNotFound(model, request);
        }

        return resultPage; //a keresett template, amelyre átirányít a hiba elkapásakor
    }


    public String pageNotFound(Model model, HttpServletRequest request){
        model.addAttribute("messageHU", "Az oldal nem található!");
        return "404PageHU";
    }

}
