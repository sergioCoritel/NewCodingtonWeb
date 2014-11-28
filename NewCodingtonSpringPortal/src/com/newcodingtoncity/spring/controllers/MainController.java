package com.newcodingtoncity.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController{
    
    @RequestMapping(value = "/register.htm")
    public String register() {
        return "register";
    }
    
    @RequestMapping(value = "/welcome.htm")
    public String welcome() {
        return "welcome";
    }
    
    @RequestMapping(value = "/about.htm")
    public String about() {
        return "about";
    }
    
    @RequestMapping(value = "/list_events.htm")
    public String list_events() {
        return "list_events";
    }
    
    @RequestMapping(value = "/show_event.htm")
    public String show_event() {
        return "show_event";
    }
}