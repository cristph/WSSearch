package com.wssearch.controller;

import com.wssearch.model.User;
import com.wssearch.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cristph on 2017/3/24.
 */

@Controller
public class SearchController {

    @Resource
    TestService testService;

    @RequestMapping("/home")
    public String home(Model model){
        List<User> list=testService.getAll();
        model.addAttribute("list",list);
        return "/home";
    }

    @RequestMapping("/search")
    public String search(){
        return "/search";
    }
}
