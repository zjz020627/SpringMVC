package com.study.mvc.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @author RenAshbell
 * @create 2022-05-09-23:30
 */
@Controller
public class FileUpAndDownController {

    @RequestMapping("/testDown")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
        //获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        //获取服务器中文件的真实路径
        String realPath = servletContext.getRealPath("/static/img/1.jpg");
        //创建输入流
        InputStream is = new FileInputStream(realPath);
        //创建字节数组
        byte[] bytes = new byte[is.available()];
        //将流读到字节数组中
        is.read(bytes);
        //创建HttpHeaders对象设置响应头信息
        MultiValueMap<String, String> headers = new HttpHeaders();
        //设置要下载方式以及下载文件的名字
        headers.add("Content-Disposition", "attachment;filename=1.jpg");
        //设置响应状态码
        HttpStatus statusCode = HttpStatus.OK;
        //创建ResponseEntity对象
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, statusCode);
        //关闭输入流
        is.close();
        return responseEntity;
    }

    @RequestMapping("/testUp")
    public String testUp(MultipartFile photo,HttpSession session) throws IOException {
        // 获取上传的文件的文件名
        String filename = photo.getOriginalFilename();
        // 获取上传文件的后缀名
        String suffixName = filename.substring(filename.lastIndexOf("."));
        // 将uuid作为文件名
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        // 将uuid和后缀名拼接后的结果作为最终的文件名
        filename = uuid + suffixName;
        // 通过servletContext获取服务器中photo目录的路径
        ServletContext servletContext = session.getServletContext();
        String photoPath = servletContext.getRealPath("photo");
        System.out.println(photoPath);// F:\SpringMVC\springMVC-demo4\target\springMVC-demo4-1.0-SNAPSHOT\photo
        File file = new File(photoPath);
        // 判断photoPath所对应路径是否存在
        if (!file.exists()){
            // 若不存在则创建目录
            file.mkdir();
        }
        String finalPath = photoPath + File.separator + filename;
        photo.transferTo(new File(finalPath));
        return "success";
    }

}
