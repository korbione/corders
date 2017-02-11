package com.dakor.app.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * .
 *
 * @author dkor
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public ModelAndView login(ModelAndView modelAndView) {
        if (!(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken)) {
            modelAndView.setViewName("redirect:app");
        } else {
            modelAndView.setViewName("login");
        }

        return modelAndView;
    }

    @RequestMapping("/registration")
    public ModelAndView register(ModelAndView modelAndView) {
        if (!(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken)) {
            modelAndView.setViewName("redirect:app");
        } else {
            modelAndView.setViewName("registration");
        }

        return modelAndView;
    }
}
