package com.blog.controllers;

import com.blog.models.User;
import com.blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;


/**
 * com.blog.controllers
 *
 * @author Created by randal on 18-6-25.
 */
@Controller
@RequestMapping(path = "/index")
public class Index extends Base {

    private final UserService userService;

    @Autowired
    public Index(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = "/index-mp", method = RequestMethod.GET)
    public String indexByModalMap(ModelMap model) {
        model.addAttribute("attribute", "this is a message by ModelMap");

        return "index/index";
    }

    @RequestMapping(path = "/index-mav", method = RequestMethod.GET)
    public ModelAndView indexByModelAndView() {
        ModelAndView model = new ModelAndView(); // ModelAndView  todo: servlet.ModelAndView

        model.addObject("attribute", "this is a message by ModelAndView");
        model.setViewName("index/index");

        return model;
    }

    @RequestMapping(path = "/login", method = RequestMethod.GET, params = {"username", "password"})
    @ResponseBody
    public Map<String, Object> login(
            HttpServletRequest request,
            @RequestParam("username") String username,
            @RequestParam("password") String password
    ) {
        HttpSession session = request.getSession();
        Map<String, Object> result = new HashMap<>();

        User user = (User) session.getAttribute("user");
        if (user != null) {
            result.put("code", 302);
            result.put("message", "用户已登录，即将跳转");
            return result;
        }

        try {
            user = userService.findByUsername(username);
            if (userService.login(user, password)) {
                session.setAttribute("user", user);
                result.put("code", 200);
                result.put("message", "登录成功");
            }
            else {
                result.put("code", 500);
                result.put("message", userService.getError());
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return result;
    }
}
