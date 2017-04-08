package com.wssearch.controller;

import com.wssearch.util.DownloadHelper;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by cristph on 2017/4/7.
 */

@Controller
public class DownloadController {

    @RequestMapping(value="/singleDownload")
    public String singleDownload(@RequestParam("path")String path,
                                 @RequestParam("fileName")String fileName,
                                 HttpServletRequest request,
                                 HttpServletResponse response)throws Exception{
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        String fileNameUtf8=URLDecoder.decode(fileName,"utf-8");
        response.setHeader("Content-Disposition", "attachment;fileName="+ new String(fileNameUtf8.getBytes("UTF-8"),"ISO-8859-1"));
        String realPath = request.getSession().getServletContext().getRealPath("/");
        System.out.println("realPath:"+realPath);
//        String path = realPath+"upload/";
//        File file = new File(path+ File.separator + fileName);
        File file = new File(path);
        downloadFile(file, response, false);
        return null;
    }

    @RequestMapping(value = "/downloadZip")
    public String downloadFiles(@RequestParam("paths")String paths,
                                HttpServletRequest request,
                                HttpServletResponse response) throws ServletException, IOException {
        List<File> files = new ArrayList<File>();
//        File Allfile = new File(request.getSession().getServletContext().getRealPath("/") + "upload/");
        String pathsUtf8=URLDecoder.decode(paths,"utf-8");
        String path[]=pathsUtf8.split("\\|");
        for(String str:path){
            System.out.println("filePath:"+str);
            File temp=new File(str);
            if(!temp.exists()){
               System.out.println("Not exists! --- "+str);
            }
            files.add(temp);
        }
//        if (Allfile.exists()) {
//            File[] fileArr = Allfile.listFiles();
//            for (File file2 : fileArr) {
//                files.add(file2);
//            }
//        }

//        String fileName = UUID.randomUUID().toString() + ".zip";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String fileName = sdf.format(new Date())+".zip";
        // 在服务器端创建打包下载的临时文件
        String outFilePath = request.getSession().getServletContext().getRealPath("/") + "upload/";

        File fileZip = new File(outFilePath + fileName);
        // 文件输出流
        FileOutputStream outStream = new FileOutputStream(fileZip);
        // 压缩流
        ZipOutputStream toClient = new ZipOutputStream(outStream);
        //  toClient.setEncoding("gbk");
        zipFile(files, toClient);
        toClient.close();
        outStream.close();
        this.downloadFile(fileZip, response, true);
        return "Download Success";
    }

    public static void zipFile(List<File> files, ZipOutputStream outputStream) throws IOException, ServletException {
        try {
            int size = files.size();
            // 压缩列表中的文件
            for (int i = 0; i < size; i++) {
                File file = files.get(i);
                zipFile(file, outputStream);
            }
        } catch (IOException e) {
            throw e;
        }
    }
    public static void zipFile(File inputFile, ZipOutputStream outputstream) throws IOException, ServletException {
        try {
            if (inputFile.exists()) {
                if (inputFile.isFile()) {
                    FileInputStream inStream = new FileInputStream(inputFile);
                    BufferedInputStream bInStream = new BufferedInputStream(inStream);
                    ZipEntry entry = new ZipEntry(inputFile.getName());
                    outputstream.putNextEntry(entry);

                    final int MAX_BYTE = 10 * 1024 * 1024; // 最大的流为10M
                    long streamTotal = 0; // 接受流的容量
                    int streamNum = 0; // 流需要分开的数量
                    int leaveByte = 0; // 文件剩下的字符数
                    byte[] inOutbyte; // byte数组接受文件的数据

                    streamTotal = bInStream.available(); // 通过available方法取得流的最大字符数
                    streamNum = (int) Math.floor(streamTotal / MAX_BYTE); // 取得流文件需要分开的数量
                    leaveByte = (int) streamTotal % MAX_BYTE; // 分开文件之后,剩余的数量

                    if (streamNum > 0) {
                        for (int j = 0; j < streamNum; ++j) {
                            inOutbyte = new byte[MAX_BYTE];
                            // 读入流,保存在byte数组
                            bInStream.read(inOutbyte, 0, MAX_BYTE);
                            outputstream.write(inOutbyte, 0, MAX_BYTE); // 写出流
                        }
                    }
                    // 写出剩下的流数据
                    inOutbyte = new byte[leaveByte];
                    bInStream.read(inOutbyte, 0, leaveByte);
                    outputstream.write(inOutbyte);
                    outputstream.closeEntry(); // Closes the current ZIP entry
                    // and positions the stream for
                    // writing the next entry
                    bInStream.close(); // 关闭
                    inStream.close();
                }
            } else {
                throw new ServletException("文件不存在！");
            }
        } catch (IOException e) {
            throw e;
        }
    }

    public void downloadFile(File file,HttpServletResponse response,boolean isDelete) {
        try {
            // 以流的形式下载文件。
            BufferedInputStream fis = new BufferedInputStream(new FileInputStream(file.getPath()));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment;filename=" + new String(file.getName().getBytes("UTF-8"),"ISO-8859-1"));
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
            if(isDelete)
            {
                file.delete();        //是否将生成的服务器端文件删除
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
