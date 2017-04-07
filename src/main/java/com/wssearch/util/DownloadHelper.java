package com.wssearch.util;

import org.dom4j.DocumentException;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by cristph on 2017/4/7.
 */
public class DownloadHelper {

    public void fileCopy(String path,String path2,String file2) throws IOException {
        FileInputStream fis=new FileInputStream(path);
        FileOutputStream fos=new FileOutputStream(path2+"\\"+file2);
        int len=0;
        byte[] buf=new byte[1024];
        while((len=fis.read(buf))!=-1){
            fos.write(buf,0,len);
        }
        fis.close();
        fos.close();
    }

    public void copy_one(String resource_path,String goal_path) throws IOException{
        //resource_path具体到了某一个xml或者doc的绝对路径，goal_path即为要存放的文件夹名字
        //D:\Users\XML-EXCEL\resources\out\0.xml
        String tempResult[];
        System.out.println(resource_path);
        tempResult=resource_path.split("\\\\");
        int n=tempResult.length;
        System.out.println(n);
        String temp0=tempResult[n-2];
        String temp1=tempResult[n-1];
        fileCopy(resource_path,goal_path,temp0+"_"+temp1);
    }

    public void Download(String[] path,String goal_path) throws IOException{
        for(int i=0;i<path.length;i++){
            copy_one(path[i],goal_path);
        }
    }

    public static void main(String[] args) throws DocumentException, IOException {
        String[] path={"D:\\Users\\XML-EXCEL\\resources\\in\\(1999)二中民一初字第35号民事判决书（一审民事案件用）.rtf.xml",
                "D:\\Users\\XML-EXCEL\\resources\\in\\(2007)汉民初字第143号民事判决书（一审民事案件用）.doc.xml",
                "E:\\JavaProject1\\DOM_4j\\testXML\\9.xml",
                "E:\\葛老师任务\\文书筛选数据库表设计\\附件7 案由代码.doc"};
        String goal_path="D:\\Users\\XML-EXCEL\\resources\\out_ceshi";//最后面的目录为子文件夹名字
        new DownloadHelper().Download(path,goal_path);
    }
}
