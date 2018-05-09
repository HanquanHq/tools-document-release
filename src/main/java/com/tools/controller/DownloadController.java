package com.tools.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by jianghaijun on 2018/5/8.
 */
@Controller
@RequestMapping("/download")
public class DownloadController {
    @Autowired
    private Environment env;

    @RequestMapping(value = "/rocketmq")
    @ResponseBody
    public void download(String version, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String filename = env.getProperty("publish.path") + "/rocketmq/" + version + "/apache-rocketmq.zip";
        File file = new File(filename);
        if (!file.exists()) {
            return;
        }
        //设置Content-Disposition
        response.setHeader("Content-Disposition", "attachment;filename=apache-rocketmq.zip");
        //读取目标文件，通过response将目标文件写到客户端
        //读取文件
        InputStream in = new FileInputStream(filename);
        OutputStream out = null;
        try {
            out = response.getOutputStream();
            //写文件
            int b;
            while ((b = in.read()) != -1) {
                out.write(b);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            in.close();
            if (out != null) {
                out.close();
            }
        }
    }

    @RequestMapping(value = "/share")
    @ResponseBody
    public void share(String fileName, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String filename = env.getProperty("publish.path") + "/" + fileName;
        File file = new File(filename);
        if (!file.exists()) {
            return;
        }
        //设置Content-Disposition
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        //读取目标文件，通过response将目标文件写到客户端
        //读取文件
        InputStream in = new FileInputStream(filename);
        OutputStream out = null;
        try {
            out = response.getOutputStream();
            //写文件
            int b;
            while ((b = in.read()) != -1) {
                out.write(b);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            in.close();
            if (out != null) {
                out.close();
            }
        }
    }
}
