package com.wssearch.controller;

import com.alibaba.fastjson.JSON;
import com.wssearch.model.*;
import com.wssearch.model.Vo.Dsr;
import com.wssearch.model.Vo.Nr;
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
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;
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

    @Resource
    JBQKService jbqkService;

    @Resource
    ComplexSearchService complexSearchService;

//    @RequestMapping(value="/search")
//    public String searchByAh(@RequestParam("AH")String AH,
//                             Model model){
//        Condition condition=new Condition(SearchWord.AH,AH);
//        List<Condition> conditions=new ArrayList<>();
//        conditions.add(condition);
//        Sort sort=new Sort(SortClass.PJRQ,SortType.DESC);
//        List<Sort> sorts=new ArrayList<>();
//        sorts.add(sort);
//        List<WsAjxxb> list=ajjbxxService.searchWsAjxxb(conditions, sorts, 0, 5);
//        model.addAttribute("list",list);
//
//
//        model.addAttribute("AH",AH);
//        model.addAttribute("SortClass",SortClass.PJRQ);
//        model.addAttribute("SortType",SortType.DESC);
//
//        int count=ajjbxxService.searchByAjxhCount(AH);
//        model.addAttribute("AjCount",count);
//        return "/search";
//    }

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

    @ResponseBody
    @RequestMapping(value = "getJBQK",produces = "text/html;charset=cp936")
    public ModelAndView getJBQK(@RequestParam("Ajxh")String Ajxh,
                                @RequestParam("Ajxz")String Ajxz,
                                @RequestParam("Spcx")String Spcx,
                                ModelAndView modelAndView){
        String Ajxz_utf8=null;
        String Spcx_utf8=null;
        try {
            Ajxz_utf8=URLDecoder.decode(Ajxz,"utf-8");
            Spcx_utf8=URLDecoder.decode(Spcx,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if(Ajxz_utf8.equals("民事案件")||Ajxz_utf8.equals("行政案件")){
            WsAjjbqkmsxz wsAjjbqkmsxz=jbqkService.getWsAjjbqkmsxz(Ajxh);
            modelAndView.addObject("item",wsAjjbqkmsxz);
            modelAndView.addObject("cl","msxz");
        }else if(Ajxz_utf8.equals("刑事案件")){
            if(Spcx_utf8.equals("二审案件")){
                WSAjjbqkxses wsAjjbqkxses=jbqkService.getWSAjjbqkxses(Ajxh);
                modelAndView.addObject("item",wsAjjbqkxses);
                modelAndView.addObject("cl","xses");
            }else if(Spcx_utf8.equals("一审案件")){
                WsAjjbqkxsys wsAjjbqkxsys=jbqkService.getWsAjjbqkxsys(Ajxh);
                modelAndView.addObject("item",wsAjjbqkxsys);
                modelAndView.addObject("cl","xsys");
            }
        }
        modelAndView.setViewName("jbqk");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "getQKD",produces = "text/html;charset=cp936")
    public ModelAndView getQKD(@RequestParam("Class")String Class,
                               @RequestParam("Ajxh")String Ajxh,
                               ModelAndView modelAndView){
        List<Nr> list=jbqkService.getNrList(Ajxh,Class);
        modelAndView.addObject("list",list);
        modelAndView.setViewName("nr");
        return modelAndView;
    }


    @RequestMapping(value="/complexSearch")
    public String complexSearch(@RequestParam("ay")String ay,
                                @RequestParam("ah")String ah,
                                @RequestParam("ajmc")String ajmc,
                                @RequestParam("fymc")String fymc,
                                @RequestParam("fycj")String fycj,
                                @RequestParam("ajlx")String ajlx,
                                @RequestParam("spcx")String spcx,
                                @RequestParam("wslx")String wslx,
                                @RequestParam("cprqbegin")String cprqbegin,
                                @RequestParam("cprqend")String cprqend,
                                @RequestParam("cpry")String cpry,
                                @RequestParam("dsr")String dsr,
                                @RequestParam("lvsuo")String lvsuo,
                                @RequestParam("lvshi")String lvshi,
                                @RequestParam("flyj")String flyj,
                                @RequestParam("cpnf")String cpnf,
                                Model model){
        HashMap<String,String> conditions=new HashMap<>();
        String ayUtf8=null;
        String fymcUtf8=null;
        String cprqbeginUtf8=null;
        String cprqendUtf8=null;
        String dsrUtf8=null;
        try {
            ayUtf8=URLDecoder.decode(ay,"utf-8");
            if(ah.trim().length()!=0){
                String ahUtf8=URLDecoder.decode(ah,"utf-8");
                conditions.put("wsah",ahUtf8);
            }
            if(ajmc.trim().length()!=0){
                String ajmcUtf8=URLDecoder.decode(ajmc,"utf-8");
                conditions.put("wsmc",ajmcUtf8);
            }
            fymcUtf8=URLDecoder.decode(fymc,"utf-8");
            if(fycj.trim().length()!=0){
                String fycjUtf8=URLDecoder.decode(fycj,"utf-8");
                conditions.put("fycj",fycjUtf8);
            }
            if(ajlx.trim().length()!=0){
                String ajlxUtf8=URLDecoder.decode(ajlx,"utf-8");
                conditions.put("ajlb",ajlxUtf8);
            }
            if(spcx.trim().length()!=0){
                String spcxUtf8=URLDecoder.decode(spcx,"utf-8");
                conditions.put("spcx",spcxUtf8);
            }
            if(wslx.trim().length()!=0){
                String wslxUtf8=URLDecoder.decode(wslx,"utf-8");
                conditions.put("wslx",wslxUtf8);
            }
            cprqbeginUtf8=URLDecoder.decode(cprqbegin,"utf-8");
            cprqendUtf8=URLDecoder.decode(cprqend,"utf-8");
            if(cpry.trim().length()!=0){
                String cpryUtf8=URLDecoder.decode(cpry,"utf-8");
                conditions.put("spry",cpryUtf8);
            }
            dsrUtf8=URLDecoder.decode(dsr,"utf-8");
            if(lvsuo.trim().length()!=0){
                String lvsuoUtf8=URLDecoder.decode(lvsuo,"utf-8");
                conditions.put("lsmc",lvsuoUtf8);
            }
            if(lvshi.trim().length()!=0){
                String lvshiUtf8=URLDecoder.decode(lvshi,"utf-8");
                conditions.put("lsxm",lvshiUtf8);
            }
            if(flyj.trim().length()!=0){
                String flyjUtf8=URLDecoder.decode(flyj,"utf-8");
                conditions.put("flyj",flyjUtf8);
            }
            if(cpnf.trim().length()!=0){
                String cpnfUtf8=URLDecoder.decode(cpnf,"utf-8");
                conditions.put("cpnf",cpnfUtf8);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }



        //List<Wssxb> list=complexSearchService.getWssxbList(conditions, ayUtf8,fymcUtf8,dsrUtf8,cprqbeginUtf8,cprqendUtf8,new ArrayList<Sort>(),0,5);
        List<Wssxb> list=new ArrayList<>();
        Wssxb wssxb1=new Wssxb();
        wssxb1.setWsah("1111111");
        wssxb1.setSpcx("1zzzzz");
        wssxb1.setWsmc("1wwwwww");
        wssxb1.setXmlPath("/jkdk/dsa");

        Wssxb wssxb2=new Wssxb();
        wssxb2.setWsah("2222222");

        Wssxb wssxb3=new Wssxb();
        wssxb3.setWsah("3333333");

        list.add(wssxb1);
        list.add(wssxb2);
        list.add(wssxb3);

        model.addAttribute("list",list);
        model.addAttribute("ah",ah);
        model.addAttribute("ay",ay);
        model.addAttribute("fycj",fycj);
        model.addAttribute("fymc",fymc);
        model.addAttribute("ajmc",ajmc);
        model.addAttribute("ajlx",ajlx);
        model.addAttribute("spcx",spcx);
        model.addAttribute("wslx",wslx);
        model.addAttribute("cpry",cpry);
        model.addAttribute("lvsuo",lvsuo);
        model.addAttribute("lvshi",lvshi);
        model.addAttribute("flyj",flyj);
        model.addAttribute("cpnf",cpnf);




        model.addAttribute("SortClass",SortClass.PJRQ);
        model.addAttribute("SortType",SortType.DESC);

//        int count=ajjbxxService.searchByAjxhCount(AH);
//        model.addAttribute("AjCount",count);
        return "search";
    }

}
