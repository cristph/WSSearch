package com.wssearch.controller;

import com.wssearch.util.DownloadHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * Created by cristph on 2017/4/7.
 */

@Controller
public class DownloadController {

    @ResponseBody
    @RequestMapping(value="/download")
    public String download(@RequestParam("paths")String paths){
        DownloadHelper downloadHelper=new DownloadHelper();
        String path[]=paths.split("\\|");
//        try {
//            downloadHelper.Download(path,"D:\\Users\\XML-EXCEL\\resources\\out_ceshi");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return "success!";
    }
}
