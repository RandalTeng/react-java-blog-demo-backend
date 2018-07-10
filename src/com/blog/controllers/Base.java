package com.blog.controllers;

import org.springframework.web.servlet.DispatcherServlet;

import java.util.HashMap;
import java.util.Map;

/**
 * com.blog.controllers
 *
 * @author Created by randal on 18-6-25.
 */
public class Base extends DispatcherServlet {
    HashMap<String, Object> getMap(Integer code, String message) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("code", code);
        result.put("message", message);

        return result;
    }
}
