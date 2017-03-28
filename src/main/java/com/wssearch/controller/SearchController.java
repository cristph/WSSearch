package com.wssearch.controller;

import com.alibaba.fastjson.JSON;
import com.wssearch.model.User;
import com.wssearch.model.Vo.Dsr;
import com.wssearch.model.WsAjxxb;
import com.wssearch.model.WsDsr;
import com.wssearch.model.WsDsrQk;
import com.wssearch.service.AJJBXXService;
import com.wssearch.service.DsrService;
import com.wssearch.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
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

    @Resource
    DsrService dsrService;


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
        List<WsAjxxb> wsAjxxbList=ajjbxxService.searchByAh(Ah);
        model.addAttribute("list",wsAjxxbList);
        System.out.println("size: "+wsAjxxbList.size()+"item:"+ wsAjxxbList.get(0).toString());
        return "/search";
    }


    @RequestMapping("/wsInfo")
    public String wsInfo(@RequestParam("Ajxh")String Ajxh,
                         Model model){
        WsAjxxb wsAjxxb=ajjbxxService.searchByAjxh(Ajxh);
        model.addAttribute("item",wsAjxxb);
        return "/wsInfo";
    }

    @ResponseBody
    @RequestMapping(value = "/getDsrList",produces = "text/html;charset=cp936")
    public ModelAndView getDsrList(@RequestParam("Ajxh")String Ajxh,
                             ModelAndView modelAndView){
        List<WsDsr> list= dsrService.getWsDsrList(Integer.valueOf(Ajxh));
        modelAndView.addObject("list",list);
        modelAndView.setViewName("wsDsr");
        for(WsDsr dsr:list){
            System.out.println(dsr.toString());
        }
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/getQK",produces = "text/html;charset=cp936")
    public ModelAndView getQK(@RequestParam("Ajxh")String Ajxh,
                              @RequestParam("Dsrbh")String Dsrbh,
                              ModelAndView modelAndView){
        List<WsDsrQk> list=dsrService.getWsDsrQkList(Integer.valueOf(Ajxh),Integer.valueOf(Dsrbh));
        System.out.println("listsize:"+list.size());
        for(WsDsrQk wsDsrQk:list){
            System.out.println(wsDsrQk.toString());
        }
        modelAndView.addObject("WsDsrQkList",list);
        modelAndView.setViewName("dsrQK");
        return modelAndView;
    }
}
