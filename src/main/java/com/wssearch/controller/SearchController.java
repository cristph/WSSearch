package com.wssearch.controller;

import com.alibaba.fastjson.JSON;
import com.wssearch.model.User;
import com.wssearch.model.WsAjxxb;
import com.wssearch.service.AJJBXXService;
import com.wssearch.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cristph on 2017/3/24.
 */

@Controller
public class SearchController {

//    @Resource
//    TestService testService;

    @Resource
    AJJBXXService ajjbxxService;


    @RequestMapping("/se")
    public String search(){
        return "/search";
    }

//    @ResponseBody
//    @RequestMapping(value="/searchByAh",produces = "text/plain;charset=cp936")
//    public String searchByAh(@RequestParam("Ah")String Ah,
//                             Model model){
//        WsAjxxb wsAjxxb=ajjbxxService.searchByAh(Ah);
//        model.addAttribute("wsAjxxb",wsAjxxb);
//        System.out.println(wsAjxxb.toString());
////        response.setContentType("application/json;charset=UTF-8");
////        return JSON.toJSONString(wsAjxxb);
//        return wsAjxxb.toString();
//    }


    @RequestMapping(value="/searchByAh")
    public String searchByAh(@RequestParam("Ah")String Ah,
                             Model model){
        WsAjxxb wsAjxxb=ajjbxxService.searchByAh(Ah);
        List<WsAjxxb> wsAjxxbList=new ArrayList<>();
        wsAjxxbList.add(wsAjxxb);
        model.addAttribute("list",wsAjxxbList);
//        System.out.println("size: "+wsAjxxbList.size()+"item:"+ wsAjxxbList.get(0).toString());
        return "/search";
    }
}
