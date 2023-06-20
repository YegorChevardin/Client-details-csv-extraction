package com.test.task.yegorchevardin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for handling requests for showing main page
 * @author yegorchevardin
 * @version 0.0.1
 */
@Controller
@RequestMapping({"/", "/home"})
public class ClientsController {
    /**
     * Method for showing main page
     */
    @GetMapping
    public String showMainPage() {
        return "home";
    }
}
