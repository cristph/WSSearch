package com.wssearch.controller;

import com.alibaba.fastjson.JSON;
import com.wssearch.model.*;
import com.wssearch.model.Vo.Dsr;
import com.wssearch.model.Vo.Nr;
import com.wssearch.model.Vo.PfFjx;
import com.wssearch.model.Vo.ZkjlZm;
import com.wssearch.service.*;
import com.wssearch.service.impl.ESServiceImpl;
import com.wssearch.util.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.SQLException;
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

    @Resource
    ESService esService;

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

//    @ResponseBody
//    @RequestMapping(value = "/goPage",produces = "text/html;charset=cp936")
//    public ModelAndView goPage(@RequestParam("AH")String AH,
//                               @RequestParam("SortClass")String sortClass,
//                               @RequestParam("SortType")String sortType,
//                               @RequestParam("BeginIndex")int BeginIndex,
//                               ModelAndView modelAndView){
//
//        String AH_UTF8=null;
//        try {
//            AH_UTF8=URLDecoder.decode(AH,"utf-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//
//        Condition condition=new Condition(SearchWord.AH,AH_UTF8);
//        List<Condition> conditions=new ArrayList<>();
//        conditions.add(condition);
//        Sort sort=new Sort(SortClass.PJRQ,SortType.DESC);
//        List<Sort> sorts=new ArrayList<>();
//        sorts.add(sort);
//        List<WsAjxxb> list=ajjbxxService.searchWsAjxxb(conditions, sorts, (BeginIndex-1)*5, 5);
//        modelAndView.addObject("list",list);
//        modelAndView.setViewName("ajPage");
//        return modelAndView;
//    }


    @RequestMapping("/wsInfo")
    public String wsInfo(@RequestParam("Wsah")String Wsah,
                         Model model){
        System.out.println("search Wsah:"+Wsah);
        WsAjxxb wsAjxxb=ajjbxxService.searchByExactAh(Wsah);
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
    public String complexSearch(@RequestParam("qwjs")String qwjs,
                                @RequestParam("qwjsInput")String qwjsInput,
                                @RequestParam("ay")String ay,
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
                                @RequestParam("flyj")String flyj,
                                @RequestParam("cpnf")String cpnf,
                                Model model){
        HashMap<String,String> preciseConditions=new HashMap<>();
        HashMap<String,String> ambiguousConditions=new HashMap<>();

        String cprqbeginUtf8=null;
        String cprqendUtf8=null;

        try {
            if(qwjsInput.trim().length()!=0){
                String qwjsInputUtf8=URLDecoder.decode(qwjsInput,"utf-8");
                ambiguousConditions.put(qwjs,qwjsInputUtf8.trim());
            }
            if(ah.trim().length()!=0){
                String ahUtf8=URLDecoder.decode(ah,"utf-8");
                ambiguousConditions.put("ah",ahUtf8.trim());
            }
            if(ajmc.trim().length()!=0){
                String ajmcUtf8=URLDecoder.decode(ajmc,"utf-8");
                ambiguousConditions.put("wsmc",ajmcUtf8.trim());
            }
            if(fycj.trim().length()>0){
                String fycjUtf8=URLDecoder.decode(fycj,"utf-8").trim();
                preciseConditions.put("fycj",fycjUtf8.trim());
            }
            if(ajlx.trim().length()!=0){
                String ajlxUtf8=URLDecoder.decode(ajlx,"utf-8");
                preciseConditions.put("ajlx",ajlxUtf8.trim());
            }
            if(spcx.trim().length()!=0){
                String spcxUtf8=URLDecoder.decode(spcx,"utf-8");
                preciseConditions.put("spcx",spcxUtf8.trim());
            }
            if(wslx.trim().length()!=0){
                String wslxUtf8=URLDecoder.decode(wslx,"utf-8");
                preciseConditions.put("wslx",wslxUtf8.trim());
            }
            if(cpry.trim().length()!=0){
                String cpryUtf8=URLDecoder.decode(cpry,"utf-8");
                ambiguousConditions.put("spry",cpryUtf8.trim());
            }
            if(flyj.trim().length()!=0){
                String flyjUtf8=URLDecoder.decode(flyj,"utf-8");
                ambiguousConditions.put("flyj",flyjUtf8.trim());
            }
            if(cpnf.trim().length()!=0){
                String cpnfUtf8=URLDecoder.decode(cpnf,"utf-8");
                preciseConditions.put("cpnf",cpnfUtf8.trim());
            }
            if(ay.trim().length()!=0){
                String ayUtf8=URLDecoder.decode(ay,"utf-8").trim();
                preciseConditions.put("ay", ayUtf8);
            }
            if(dsr.trim().length()!=0){
                String dsrUtf8=URLDecoder.decode(dsr,"utf-8").trim();
                ambiguousConditions.put("dsr",dsrUtf8);
            }
            if(fymc.trim().length()!=0){
                String fymcUtf8=URLDecoder.decode(fymc,"utf-8").trim();
                ambiguousConditions.put("fymc",fymcUtf8);
            }
            cprqbeginUtf8=URLDecoder.decode(cprqbegin,"utf-8").trim();
            cprqendUtf8=URLDecoder.decode(cprqend,"utf-8").trim();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

//        HashMap<String,String> sorts=new HashMap<>();
//        sorts.put("CPRQ","desc");
//        sorts.put("SPCX","desc");
//        sorts.put("FYCJ","desc");

//        List<Wssxb> list= null;
//        try {
//            list = complexSearchService.getWssxList(preciseConditions, ambiguousConditions, ayUtf8.trim(), fymcUtf8.trim(), dsrUtf8.trim(),
//                    cprqbeginUtf8.trim(), cprqendUtf8.trim(), sorts, 1, 5);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        ESService esService=new ESServiceImpl();
        List<WSInfo> list=esService.getWSInfoList(preciseConditions,ambiguousConditions, cprqbeginUtf8.trim(), cprqendUtf8.trim(), true, "", 0, 5);

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
        model.addAttribute("dsr",dsr);
        model.addAttribute("flyj",flyj);
        model.addAttribute("cpnf",cpnf);
        model.addAttribute("qwjs",qwjs);
        model.addAttribute("qwjsInput",qwjsInput);


        model.addAttribute("SortClass",SortClass.PJRQ);
        model.addAttribute("SortType",SortType.DESC);

//        int count=complexSearchService.getWssxbListNum(conditions, ayUtf8.trim(), Integer.valueOf(fycjUtf8),fymcUtf8.trim(), dsrUtf8.trim(),
//                cprqbeginUtf8.trim(), cprqendUtf8.trim());
        int count= 0;
//        try {
//            count = complexSearchService.getWssxListNum(preciseConditions, ambiguousConditions, ayUtf8.trim(), fymcUtf8.trim(), dsrUtf8.trim(),
//                    cprqbeginUtf8.trim(), cprqendUtf8.trim());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        count = (int)esService.getWSInfoListNum(preciseConditions,ambiguousConditions, cprqbeginUtf8.trim(), cprqendUtf8.trim());
        model.addAttribute("AjCount",count);
        int maxPageNum=0;
        if(count%5==0){
            maxPageNum=count/5;
        }else{
            maxPageNum=(count/5)+1;
        }
//        System.out.println("maxPageNum:"+7);
        model.addAttribute("maxPageNum",maxPageNum);
        return "search";
    }

    @ResponseBody
    @RequestMapping(value="/getNum")
    public String getNum(@RequestParam("qwjs")String qwjs,
                         @RequestParam("qwjsInput")String qwjsInput,
                         @RequestParam("ay")String ay,
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
                         @RequestParam("flyj")String flyj,
                         @RequestParam("cpnf")String cpnf){
        HashMap<String,String> preciseConditions=new HashMap<>();
        HashMap<String,String> ambiguousConditions=new HashMap<>();

        String cprqbeginUtf8=null;
        String cprqendUtf8=null;

        try {
            if(qwjsInput.trim().length()!=0){
                String qwjsInputUtf8=URLDecoder.decode(qwjsInput,"utf-8");
                ambiguousConditions.put(qwjs,qwjsInputUtf8.trim());
            }
            if(ah.trim().length()!=0){
                String ahUtf8=URLDecoder.decode(ah,"utf-8");
                ambiguousConditions.put("ah",ahUtf8.trim());
            }
            if(ajmc.trim().length()!=0){
                String ajmcUtf8=URLDecoder.decode(ajmc,"utf-8");
                ambiguousConditions.put("wsmc",ajmcUtf8.trim());
            }
            if(fycj.trim().length()>0){
                String fycjUtf8=URLDecoder.decode(fycj,"utf-8").trim();
                preciseConditions.put("fycj",fycjUtf8.trim());
            }
            if(ajlx.trim().length()!=0){
                String ajlxUtf8=URLDecoder.decode(ajlx,"utf-8");
                preciseConditions.put("ajlx",ajlxUtf8.trim());
            }
            if(spcx.trim().length()!=0){
                String spcxUtf8=URLDecoder.decode(spcx,"utf-8");
                preciseConditions.put("spcx",spcxUtf8.trim());
            }
            if(wslx.trim().length()!=0){
                String wslxUtf8=URLDecoder.decode(wslx,"utf-8");
                preciseConditions.put("wslx",wslxUtf8.trim());
            }
            if(cpry.trim().length()!=0){
                String cpryUtf8=URLDecoder.decode(cpry,"utf-8");
                ambiguousConditions.put("spry",cpryUtf8.trim());
            }
            if(flyj.trim().length()!=0){
                String flyjUtf8=URLDecoder.decode(flyj,"utf-8");
                ambiguousConditions.put("flyj",flyjUtf8.trim());
            }
            if(cpnf.trim().length()!=0){
                String cpnfUtf8=URLDecoder.decode(cpnf,"utf-8");
                preciseConditions.put("cpnf",cpnfUtf8.trim());
            }
            if(ay.trim().length()!=0){
                String ayUtf8=URLDecoder.decode(ay,"utf-8").trim();
                preciseConditions.put("ay", ayUtf8);
            }
            if(dsr.trim().length()!=0){
                String dsrUtf8=URLDecoder.decode(dsr,"utf-8").trim();
                ambiguousConditions.put("dsr",dsrUtf8);
            }
            if(fymc.trim().length()!=0){
                String fymcUtf8=URLDecoder.decode(fymc,"utf-8").trim();
                ambiguousConditions.put("fymc",fymcUtf8);
            }
            cprqbeginUtf8=URLDecoder.decode(cprqbegin,"utf-8").trim();
            cprqendUtf8=URLDecoder.decode(cprqend,"utf-8").trim();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        int count= 0;
//        try {
//            count = complexSearchService.getWssxListNum(preciseConditions, ambiguousConditions, ayUtf8.trim(), fymcUtf8.trim(), dsrUtf8.trim(),
//                    cprqbeginUtf8.trim(), cprqendUtf8.trim());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        ESService esService=new ESServiceImpl();
        count = (int)esService.getWSInfoListNum(preciseConditions,ambiguousConditions, cprqbeginUtf8.trim(), cprqendUtf8.trim());

        int maxPageNum=0;
        if(count%5==0){
            maxPageNum=count/5;
        }else{
            maxPageNum=(count/5)+1;
        }

        String str=String.valueOf(count)+";"+String.valueOf(maxPageNum);
        return str;
    }

//    @ResponseBody
//    @RequestMapping(value = "/goPage",produces = "text/html;charset=cp936")
//    public ModelAndView goPage(@RequestParam("ay")String ay,
//                               @RequestParam("ah")String ah,
//                               @RequestParam("ajmc")String ajmc,
//                               @RequestParam("fymc")String fymc,
//                               @RequestParam("fycj")String fycj,
//                               @RequestParam("ajlx")String ajlx,
//                               @RequestParam("spcx")String spcx,
//                               @RequestParam("wslx")String wslx,
//                               @RequestParam("cprqbegin")String cprqbegin,
//                               @RequestParam("cprqend")String cprqend,
//                               @RequestParam("cpry")String cpry,
//                               @RequestParam("dsr")String dsr,
//                               @RequestParam("lvsuo")String lvsuo,
//                               @RequestParam("lvshi")String lvshi,
//                               @RequestParam("flyj")String flyj,
//                               @RequestParam("cpnf")String cpnf,
//                               @RequestParam("SortClass")String sortClass,
//                               @RequestParam("SortType")String sortType,
//                               @RequestParam("BeginIndex")int BeginIndex,
//                               ModelAndView modelAndView){
//
//        HashMap<String,String> conditions=new HashMap<>();
//        String ayUtf8=null;
//        String fymcUtf8=null;
//        String cprqbeginUtf8=null;
//        String cprqendUtf8=null;
//        String dsrUtf8=null;
//        String fycjUtf8=null;
//
//        try {
//            ayUtf8=URLDecoder.decode(ay,"utf-8");
//            if(ah.trim().length()!=0){
//                String ahUtf8=URLDecoder.decode(ah,"utf-8");
//                conditions.put("wsah",ahUtf8.trim());
//            }
//            if(ajmc.trim().length()!=0){
//                String ajmcUtf8=URLDecoder.decode(ajmc,"utf-8");
//                conditions.put("wsmc",ajmcUtf8.trim());
//            }
//            fymcUtf8=URLDecoder.decode(fymc,"utf-8");
//            fycjUtf8=URLDecoder.decode(fycj,"utf-8");
//            if(ajlx.trim().length()!=0){
//                String ajlxUtf8=URLDecoder.decode(ajlx,"utf-8");
//                conditions.put("ajlb",ajlxUtf8.trim());
//            }
//            if(spcx.trim().length()!=0){
//                String spcxUtf8=URLDecoder.decode(spcx,"utf-8");
//                conditions.put("spcx",spcxUtf8.trim());
//            }
//            if(wslx.trim().length()!=0){
//                String wslxUtf8=URLDecoder.decode(wslx,"utf-8");
//                conditions.put("wslx",wslxUtf8.trim());
//            }
//            cprqbeginUtf8=URLDecoder.decode(cprqbegin,"utf-8");
//            cprqendUtf8=URLDecoder.decode(cprqend,"utf-8");
//            if(cpry.trim().length()!=0){
//                String cpryUtf8=URLDecoder.decode(cpry,"utf-8");
//                conditions.put("spry",cpryUtf8.trim());
//            }
//            dsrUtf8=URLDecoder.decode(dsr,"utf-8");
//            if(lvsuo.trim().length()!=0){
//                String lvsuoUtf8=URLDecoder.decode(lvsuo,"utf-8");
//                conditions.put("lsmc",lvsuoUtf8.trim());
//            }
//            if(lvshi.trim().length()!=0){
//                String lvshiUtf8=URLDecoder.decode(lvshi,"utf-8");
//                conditions.put("lsxm",lvshiUtf8.trim());
//            }
//            if(flyj.trim().length()!=0){
//                String flyjUtf8=URLDecoder.decode(flyj,"utf-8");
//                conditions.put("flyj",flyjUtf8.trim());
//            }
//            if(cpnf.trim().length()!=0){
//                String cpnfUtf8=URLDecoder.decode(cpnf,"utf-8");
//                conditions.put("cpnf",cpnfUtf8.trim());
//            }
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//
//
//
////        List<Wssxb> list=complexSearchService.getWssxbList(conditions, ayUtf8.trim(), Integer.valueOf(fycjUtf8),fymcUtf8.trim(), dsrUtf8.trim(),
////                cprqbeginUtf8.trim(), cprqendUtf8.trim(), new ArrayList<Sort>(),(BeginIndex-1)*5,5);
//        List<Wssxb> list=new ArrayList<>();
////        Wssxb wssxb1=new Wssxb();
////        wssxb1.setWsah("天津市"+Math.random()+"号");
////        wssxb1.setSpcx("一审案件");
////        wssxb1.setWsmc("一审判决书3");
////        wssxb1.setXmlPath("C:\\Users\\cristph\\IdeaProjects\\WSSearch\\out\\artifacts\\WSSearch_war_exploded\\upload\\10030.xml");
////        wssxb1.setDocPath("/jkdk/doc3");
////        wssxb1.setGymc("天津市高级人民法院");
////
////        Wssxb wssxb2=new Wssxb();
////        wssxb2.setWsah("天津市"+Math.random()+"号");
////        wssxb2.setSpcx("一审案件");
////        wssxb2.setWsmc("一审判决书4");
////        wssxb2.setXmlPath("C:\\Users\\cristph\\IdeaProjects\\WSSearch\\out\\artifacts\\WSSearch_war_exploded\\upload\\10031.xml");
////        wssxb2.setDocPath("/jkdk/doc3");
////        wssxb2.setGymc("天津市高级人民法院");
////
////        Wssxb wssxb3=new Wssxb();
////        wssxb3.setWsah("天津市"+Math.random()+"号");
////        wssxb3.setSpcx("一审案件");
////        wssxb3.setWsmc("一审判决书5");
////        wssxb3.setXmlPath("C:\\Users\\cristph\\IdeaProjects\\WSSearch\\out\\artifacts\\WSSearch_war_exploded\\upload\\10032.xml");
////        wssxb3.setDocPath("/jkdk/doc3");
////        wssxb3.setGymc("天津市高级人民法院");
////
////        list.add(wssxb1);
////        list.add(wssxb2);
////        list.add(wssxb3);
//        for(int i=(BeginIndex-1)*5;i<(BeginIndex-1)*5+5;i++){
//            Wssxb wssxb=new Wssxb();
//            wssxb.setWsah("天津市"+i+"号");
//            list.add(wssxb);
//        }
//
//
//        modelAndView.addObject("list",list);
//        modelAndView.setViewName("ajPage");
//        return modelAndView;
//    }


    @ResponseBody
    @RequestMapping(value = "/goPage",produces = "text/html;charset=cp936")
    public ModelAndView goPage(@RequestParam("qwjs")String qwjs,
                               @RequestParam("qwjsInput")String qwjsInput,
                               @RequestParam("ay")String ay,
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
                               @RequestParam("flyj")String flyj,
                               @RequestParam("cpnf")String cpnf,
                               @RequestParam("SortClass[]")String[] sortClass,
                               @RequestParam("SortType[]")String[] sortType,
                               @RequestParam("BeginIndex")int BeginIndex,
                               ModelAndView modelAndView){

        HashMap<String,String> preciseConditions=new HashMap<>();
        HashMap<String,String> ambiguousConditions=new HashMap<>();

        String cprqbeginUtf8=null;
        String cprqendUtf8=null;

        try {
            if(qwjsInput.trim().length()!=0){
                String qwjsInputUtf8=URLDecoder.decode(qwjsInput,"utf-8");
                ambiguousConditions.put(qwjs,qwjsInputUtf8.trim());
            }
            if(ah.trim().length()!=0){
                String ahUtf8=URLDecoder.decode(ah,"utf-8");
                ambiguousConditions.put("ah",ahUtf8.trim());
            }
            if(ajmc.trim().length()!=0){
                String ajmcUtf8=URLDecoder.decode(ajmc,"utf-8");
                ambiguousConditions.put("wsmc",ajmcUtf8.trim());
            }
            if(fycj.trim().length()>0){
                String fycjUtf8=URLDecoder.decode(fycj,"utf-8").trim();
                preciseConditions.put("fycj",fycjUtf8.trim());
            }
            if(ajlx.trim().length()!=0){
                String ajlxUtf8=URLDecoder.decode(ajlx,"utf-8");
                preciseConditions.put("ajlx",ajlxUtf8.trim());
            }
            if(spcx.trim().length()!=0){
                String spcxUtf8=URLDecoder.decode(spcx,"utf-8");
                preciseConditions.put("spcx",spcxUtf8.trim());
            }
            if(wslx.trim().length()!=0){
                String wslxUtf8=URLDecoder.decode(wslx,"utf-8");
                preciseConditions.put("wslx",wslxUtf8.trim());
            }
            if(cpry.trim().length()!=0){
                String cpryUtf8=URLDecoder.decode(cpry,"utf-8");
                ambiguousConditions.put("spry",cpryUtf8.trim());
            }
            if(flyj.trim().length()!=0){
                String flyjUtf8=URLDecoder.decode(flyj,"utf-8");
                ambiguousConditions.put("flyj",flyjUtf8.trim());
            }
            if(cpnf.trim().length()!=0){
                String cpnfUtf8=URLDecoder.decode(cpnf,"utf-8");
                preciseConditions.put("cpnf",cpnfUtf8.trim());
            }
            if(ay.trim().length()!=0){
                String ayUtf8=URLDecoder.decode(ay,"utf-8").trim();
                preciseConditions.put("ay", ayUtf8);
            }
            if(dsr.trim().length()!=0){
                String dsrUtf8=URLDecoder.decode(dsr,"utf-8").trim();
                ambiguousConditions.put("dsr",dsrUtf8);
            }
            if(fymc.trim().length()!=0){
                String fymcUtf8=URLDecoder.decode(fymc,"utf-8").trim();
                ambiguousConditions.put("fymc",fymcUtf8);
            }
            cprqbeginUtf8=URLDecoder.decode(cprqbegin,"utf-8").trim();
            cprqendUtf8=URLDecoder.decode(cprqend,"utf-8").trim();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

//        HashMap<String,String> sorts=new HashMap<>();
//        for(int i=0;i<3;i++){
//            sorts.put(sortClass[i],sortType[i]);
//        }

//        List<Wssxb> list= null;
//        try {
//            list = complexSearchService.getWssxList(preciseConditions, ambiguousConditions, ayUtf8.trim(), fymcUtf8.trim(), dsrUtf8.trim(),
//                    cprqbeginUtf8.trim(), cprqendUtf8.trim(), sorts,(BeginIndex-1)*5+1, 5);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

//        ESService esService=new ESServiceImpl();
        List<WSInfo> list=null;
        if(sortClass[0].startsWith("a")){
            System.out.println(">>>>>>>>>>>>>>>>order by "+sortClass[0]+" "+sortType[0]+" from "+(BeginIndex-1)*5+" get 5");
            list=esService.getWSInfoList(preciseConditions,ambiguousConditions, cprqbeginUtf8.trim(), cprqendUtf8.trim(), true, "", (BeginIndex-1)*5, 5);
        }else{
            System.out.println(">>>>>>>>>>>>>>>>order by "+sortClass[0]+" "+sortType[0]+" from "+(BeginIndex-1)*5+" get 5");
            list=esService.getWSInfoList(preciseConditions,ambiguousConditions, cprqbeginUtf8.trim(), cprqendUtf8.trim(), false, sortType[0], (BeginIndex-1)*5, 5);
        }
//        List<WSInfo> list=esService.getWSInfoList(preciseConditions,ambiguousConditions, cprqbeginUtf8.trim(), cprqendUtf8.trim(), false, BeginIndex*5, 5);

        modelAndView.addObject("list",list);
        modelAndView.setViewName("ajPage");
        return modelAndView;
    }

//    @ResponseBody
//    @RequestMapping(value = "/createView")
//    public String createView(@RequestParam("ay")String ay,
//                             @RequestParam("ah")String ah,
//                             @RequestParam("ajmc")String ajmc,
//                             @RequestParam("fymc")String fymc,
//                             @RequestParam("fycj")String fycj,
//                             @RequestParam("ajlx")String ajlx,
//                             @RequestParam("spcx")String spcx,
//                             @RequestParam("wslx")String wslx,
//                             @RequestParam("cprqbegin")String cprqbegin,
//                             @RequestParam("cprqend")String cprqend,
//                             @RequestParam("cpry")String cpry,
//                             @RequestParam("dsr")String dsr,
//                             @RequestParam("lvsuo")String lvsuo,
//                             @RequestParam("lvshi")String lvshi,
//                             @RequestParam("flyj")String flyj,
//                             @RequestParam("cpnf")String cpnf,
//                             HttpSession httpSession){
//        HashMap<String,String> preciseConditions=new HashMap<>();
//        HashMap<String,String> ambiguousConditions=new HashMap<>();
//        String ayUtf8=null;
//        String fymcUtf8=null;
//        String cprqbeginUtf8=null;
//        String cprqendUtf8=null;
//        String dsrUtf8=null;
//
//        try {
//            if(ah.trim().length()!=0){
//                String ahUtf8=URLDecoder.decode(ah,"utf-8");
//                ambiguousConditions.put("wsah",ahUtf8.trim());
//            }
//            if(ajmc.trim().length()!=0){
//                String ajmcUtf8=URLDecoder.decode(ajmc,"utf-8");
//                ambiguousConditions.put("wsmc",ajmcUtf8.trim());
//            }
//            if(fycj.trim().length()>0){
//                String fycjUtf8=URLDecoder.decode(fycj,"utf-8").trim();
//                preciseConditions.put("fycj",fycjUtf8.trim());
//            }
//            if(ajlx.trim().length()!=0){
//                String ajlxUtf8=URLDecoder.decode(ajlx,"utf-8");
//                preciseConditions.put("ajlb",ajlxUtf8.trim());
//            }
//            if(spcx.trim().length()!=0){
//                String spcxUtf8=URLDecoder.decode(spcx,"utf-8");
//                preciseConditions.put("spcx",spcxUtf8.trim());
//            }
//            if(wslx.trim().length()!=0){
//                String wslxUtf8=URLDecoder.decode(wslx,"utf-8");
//                preciseConditions.put("wslx",wslxUtf8.trim());
//            }
//            if(cpry.trim().length()!=0){
//                String cpryUtf8=URLDecoder.decode(cpry,"utf-8");
//                ambiguousConditions.put("spry",cpryUtf8.trim());
//            }
//            if(lvsuo.trim().length()!=0){
//                String lvsuoUtf8=URLDecoder.decode(lvsuo,"utf-8");
//                ambiguousConditions.put("lsmc",lvsuoUtf8.trim());
//            }
//            if(lvshi.trim().length()!=0){
//                String lvshiUtf8=URLDecoder.decode(lvshi,"utf-8");
//                ambiguousConditions.put("lsxm",lvshiUtf8.trim());
//            }
//            if(flyj.trim().length()!=0){
//                String flyjUtf8=URLDecoder.decode(flyj,"utf-8");
//                ambiguousConditions.put("flyj",flyjUtf8.trim());
//            }
//            if(cpnf.trim().length()!=0){
//                String cpnfUtf8=URLDecoder.decode(cpnf,"utf-8");
//                preciseConditions.put("cpnf",cpnfUtf8.trim());
//            }
//            ayUtf8=URLDecoder.decode(ay,"utf-8").trim();
//            fymcUtf8=URLDecoder.decode(fymc,"utf-8").trim();
//            dsrUtf8=URLDecoder.decode(dsr,"utf-8").trim();
//            cprqbeginUtf8=URLDecoder.decode(cprqbegin,"utf-8").trim();
//            cprqendUtf8=URLDecoder.decode(cprqend,"utf-8").trim();
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        String viewName= null;
//        try {
//            viewName = complexSearchService.createView(preciseConditions, ambiguousConditions, ayUtf8.trim(), fymcUtf8.trim(), dsrUtf8.trim(), cprqbeginUtf8.trim(), cprqendUtf8.trim());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        System.out.println("get viewName:"+viewName);
//        if(httpSession.getAttribute("viewName")!=null){
//            String oldView=(String)httpSession.getAttribute("viewName");
//            try {
//                complexSearchService.dropView(oldView);
//                System.out.println("drop viewName:"+oldView);
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        httpSession.setAttribute("viewName",viewName);
//        return viewName;
//    }

    @ResponseBody
    @RequestMapping(value = "/groupStatistics",produces = "application/json;charset=cp936")
    public String getGroupStatistics(@RequestParam("qwjs")String qwjs,
                                     @RequestParam("qwjsInput")String qwjsInput,
                                     @RequestParam("ay")String ay,
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
                                     @RequestParam("flyj")String flyj,
                                     @RequestParam("cpnf")String cpnf,
                                     @RequestParam("groupName")String groupName,
                                     @RequestParam("whereName")String whereName,
                                     @RequestParam("whereValue")String whereValue){
        HashMap<String, Integer> hashMap=null;
//        try {
//            hashMap=complexSearchService.getGroupStatistics(groupName, viewName, whereName, URLDecoder.decode(whereValue,"utf-8").trim());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }

        HashMap<String,String> preciseConditions=new HashMap<>();
        HashMap<String,String> ambiguousConditions=new HashMap<>();

        String cprqbeginUtf8=null;
        String cprqendUtf8=null;

        try {
            if(qwjsInput.trim().length()!=0){
                String qwjsInputUtf8=URLDecoder.decode(qwjsInput,"utf-8");
                ambiguousConditions.put(qwjs,qwjsInputUtf8.trim());
            }
            if(ah.trim().length()!=0){
                String ahUtf8=URLDecoder.decode(ah,"utf-8");
                ambiguousConditions.put("ah",ahUtf8.trim());
            }
            if(ajmc.trim().length()!=0){
                String ajmcUtf8=URLDecoder.decode(ajmc,"utf-8");
                ambiguousConditions.put("wsmc",ajmcUtf8.trim());
            }
            if(fycj.trim().length()>0){
                String fycjUtf8=URLDecoder.decode(fycj,"utf-8").trim();
                preciseConditions.put("fycj",fycjUtf8.trim());
            }
            if(ajlx.trim().length()!=0){
                String ajlxUtf8=URLDecoder.decode(ajlx,"utf-8");
                preciseConditions.put("ajlx",ajlxUtf8.trim());
            }
            if(spcx.trim().length()!=0){
                String spcxUtf8=URLDecoder.decode(spcx,"utf-8");
                preciseConditions.put("spcx",spcxUtf8.trim());
            }
            if(wslx.trim().length()!=0){
                String wslxUtf8=URLDecoder.decode(wslx,"utf-8");
                preciseConditions.put("wslx",wslxUtf8.trim());
            }
            if(cpry.trim().length()!=0){
                String cpryUtf8=URLDecoder.decode(cpry,"utf-8");
                ambiguousConditions.put("spry",cpryUtf8.trim());
            }
            if(flyj.trim().length()!=0){
                String flyjUtf8=URLDecoder.decode(flyj,"utf-8");
                ambiguousConditions.put("flyj",flyjUtf8.trim());
            }
            if(cpnf.trim().length()!=0){
                String cpnfUtf8=URLDecoder.decode(cpnf,"utf-8");
                preciseConditions.put("cpnf",cpnfUtf8.trim());
            }
            if(ay.trim().length()!=0){
                String ayUtf8=URLDecoder.decode(ay,"utf-8").trim();
                preciseConditions.put("ay", ayUtf8);
            }
            if(dsr.trim().length()!=0){
                String dsrUtf8=URLDecoder.decode(dsr,"utf-8").trim();
                ambiguousConditions.put("dsr",dsrUtf8);
            }
            if(fymc.trim().length()!=0){
                String fymcUtf8=URLDecoder.decode(fymc,"utf-8").trim();
                ambiguousConditions.put("fymc",fymcUtf8);
            }
            cprqbeginUtf8=URLDecoder.decode(cprqbegin,"utf-8").trim();
            cprqendUtf8=URLDecoder.decode(cprqend,"utf-8").trim();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        hashMap=esService.getGroupStatistics(preciseConditions, ambiguousConditions, cprqbeginUtf8.trim(), cprqend.trim(), groupName, whereName, whereValue);
//        hashMap=new HashMap<>();
//        hashMap.put("测试数据1",1);
//        hashMap.put("测试数据1",2);
//        hashMap.put("测试数据1",3);
        String str=JSON.toJSONString(hashMap);
        System.out.println(str);
        return str;
    }


    @RequestMapping("/test")
    public String test(){
        complexSearchService.getAll();
        return null;
    }

}
