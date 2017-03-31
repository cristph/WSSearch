package com.wssearch.controller;

import com.alibaba.fastjson.JSON;
import com.wssearch.model.*;
import com.wssearch.model.Vo.Dsr;
import com.wssearch.model.Vo.PfFjx;
import com.wssearch.model.Vo.ZkjlZm;
import com.wssearch.service.*;
import com.wssearch.util.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
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

    @Resource
    SSJLService ssjlService;

    @Resource
    CpfxgcService cpfxgcService;

    @Resource
    XSPJJGService xspjjgService;

    @RequestMapping(value="/search")
    public String searchByAh(@RequestParam("AH")String AH,
                             Model model){
        Condition condition=new Condition(SearchWord.AH,AH);
        List<Condition> conditions=new ArrayList<>();
        conditions.add(condition);
        Sort sort=new Sort(SortClass.PJRQ,SortType.DESC);
        List<Sort> sorts=new ArrayList<>();
        sorts.add(sort);
        List<WsAjxxb> list=ajjbxxService.searchWsAjxxb(conditions, sorts, 0, 5);
        model.addAttribute("list",list);


        model.addAttribute("AH",AH);
        model.addAttribute("SortClass",SortClass.PJRQ);
        model.addAttribute("SortType",SortType.DESC);

        int count=ajjbxxService.searchByAjxhCount(AH);
        model.addAttribute("AjCount",count);
        return "/search";
    }

    @ResponseBody
    @RequestMapping(value = "/goPage",produces = "text/html;charset=cp936")
    public ModelAndView goPage(@RequestParam("AH")String AH,
                               @RequestParam("SortClass")String sortClass,
                               @RequestParam("SortType")String sortType,
                               @RequestParam("BeginIndex")int BeginIndex,
                               ModelAndView modelAndView){

        String AH_UTF8=null;
        try {
            AH_UTF8=URLDecoder.decode(AH,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Condition condition=new Condition(SearchWord.AH,AH_UTF8);
        List<Condition> conditions=new ArrayList<>();
        conditions.add(condition);
        Sort sort=new Sort(SortClass.PJRQ,SortType.DESC);
        List<Sort> sorts=new ArrayList<>();
        sorts.add(sort);
        List<WsAjxxb> list=ajjbxxService.searchWsAjxxb(conditions, sorts, (BeginIndex-1)*5, 5);
        modelAndView.addObject("list",list);
        modelAndView.setViewName("ajPage");
        return modelAndView;
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
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/getQK",produces = "text/html;charset=cp936")
    public ModelAndView getQK(@RequestParam("Ajxh")String Ajxh,
                              @RequestParam("Dsrbh")String Dsrbh,
                              ModelAndView modelAndView){
        List<WsDsrQk> list=dsrService.getWsDsrQkList(Integer.valueOf(Ajxh),Integer.valueOf(Dsrbh));
        modelAndView.addObject("WsDsrQkList",list);
        modelAndView.setViewName("dsrQK");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/getQZCS",produces = "text/html;charset=cp936")
    public ModelAndView getQZCS(@RequestParam("Ajxh")String Ajxh,
                                @RequestParam("Dsrbh")String Dsrbh,
                                ModelAndView modelAndView){
        List<WsDsrQzcs> list=dsrService.getWsDsrQzcsList(Integer.valueOf(Ajxh),Integer.valueOf(Dsrbh));
        modelAndView.addObject("WsDsrQzcsList",list);
        modelAndView.setViewName("dsrQZCS");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "getSSJL",produces = "text/html;charset=cp936")
    public ModelAndView getSSJL(@RequestParam("Ajxh")String Ajxh,
            ModelAndView modelAndView){
        WsSsjl wsSsjl=ssjlService.getWsSsjl(Ajxh);
        modelAndView.addObject("item",wsSsjl);
        modelAndView.setViewName("ssjl");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "getCTR",produces = "text/html;charset=cp936")
    public ModelAndView getCTR(@RequestParam("Ajxh")String Ajxh,
                                ModelAndView modelAndView){
        List<WsSsjlCtr> wsSsjlCtrList=ssjlService.getWsSsjlCtrList(Ajxh);
        modelAndView.addObject("list",wsSsjlCtrList);
        modelAndView.setViewName("ctr");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "getZKJL",produces = "text/html;charset=cp936")
    public ModelAndView getZKJL(@RequestParam("Ajxh")String Ajxh,
                               ModelAndView modelAndView){
        List<ZkjlZm> list=ssjlService.getZkjlZmList(Ajxh);
        modelAndView.addObject("list",list);
        modelAndView.setViewName("zkjl");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value="getCPFXGC",produces = "text/html;charset=cp936")
    public ModelAndView getCPFXGC(@RequestParam("Ajxh")String Ajxh,
                                  ModelAndView modelAndView){
        WsCpfxgc wsCpfxgc=cpfxgcService.getWsCpfxgc(Ajxh);
        modelAndView.addObject("item",wsCpfxgc);
        modelAndView.setViewName("cpfxgc");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value="getFLFT",produces = "text/html;charset=cp936")
    public ModelAndView getFLFT(@RequestParam("Ajxh")String Ajxh,
                                  ModelAndView modelAndView){
        List<WsCpfxgcFlft> list=cpfxgcService.getWsCpfxgcFlftList(Ajxh);
        modelAndView.addObject("list",list);
        modelAndView.setViewName("flft");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value="getLXQJ",produces = "text/html;charset=cp936")
    public ModelAndView getLXQJ(@RequestParam("Ajxh")String Ajxh,
                                  ModelAndView modelAndView){
        List<WsCpfxgcLxqj> list=cpfxgcService.getWsCpfxgcLxqjList(Ajxh);
        modelAndView.addObject("list",list);
        modelAndView.setViewName("lxqj");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value="getXSPJJG",produces = "text/html;charset=cp936")
    public ModelAndView getXSPJJG(@RequestParam("Ajxh")String Ajxh,
                                  ModelAndView modelAndView){
        List<WsXspjjgfz> list=xspjjgService.getWsXspjjgfzList(Ajxh);
        modelAndView.addObject("list",list);
        modelAndView.setViewName("xspjjg");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value="getPF",produces = "text/html;charset=cp936")
    public ModelAndView getXSPJJG(@RequestParam("Ajxh")String Ajxh,
                                  @RequestParam("Fzbh")String Fzbh,
                                  ModelAndView modelAndView){
        List<PfFjx> list=xspjjgService.getPfFjxList(Ajxh,Fzbh);
        modelAndView.addObject("list",list);
        modelAndView.setViewName("pf");
        return modelAndView;
    }

}
