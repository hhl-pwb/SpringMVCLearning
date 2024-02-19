package com.atguigu.mvc.controller;

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
import java.util.UUID;

@Controller
public class FileUpAndDownController {
    @RequestMapping(value = "/testDown")
    // ResponseEntity<byte[]>作为当前控制器方法的返回值，表示当前响应到浏览器的响应报文。
    // 使用ResponseEntity可以自定义一个响应报文，向浏览器响应。
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
        //获取ServletContext对象,ServletContext对象表示当前的整个工程
        ServletContext servletContext = session.getServletContext();
        //获取服务器中文件的真实路径
        //（获取服务器中的部署路径，如果有字符串参数，则表示当前这个文件在服务器中的位置）
        String realPath = servletContext.getRealPath("/static/img/image01.JPG");
        System.out.println(realPath);
        //文件上传下载都是文件复制的过程，文件复制就是先读再写的过程，读到内存中，然后写到磁盘
        //创建输入流
        FileInputStream is = new FileInputStream(realPath);
        //创建字节数组
        //is.available()是获取输入流文件所有的字节数
        byte[] bytes = new byte[is.available()];
        //将流读入字节数组中
        is.read(bytes);
        //创建HttpHeaders对象设置响应头信息
        MultiValueMap<String, String> headers = new HttpHeaders();
        //设置下载方式以及下载文件的名字，attachment表示以附件的方式下载
        //除了Image01.JPG可以修改外，其他都是固定的
        headers.add("Content-Disposition", "attachment;filename=image01.JPG");
        //设置响应状态码
        HttpStatus statusCode = HttpStatus.OK;
        //创建ResponseEntity对象
        //bytes-响应体  headers-响应头 statusCode-响应状态
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, statusCode);
        //关闭流
        is.close();
        return responseEntity;
    }

    @RequestMapping(value = "/testUp")
    public String testUp(MultipartFile photo, HttpSession session) throws IOException {
        //获取上传文件的文件名
        String fileName = photo.getOriginalFilename();
        // 获取上传文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //将UUID作为文件名
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        // 将UUID和后缀名拼接后的结果作为最终的文件名
        fileName = uuid + suffixName;
        //通过ServletContext获取服务器中photo目录的路径
        ServletContext servletContext = session.getServletContext();
        String photoPath = servletContext.getRealPath("photo");
        File file = new File(photoPath);
        //判断photoPath所对应的路径是否存在
        if (!file.exists()) {
            //若不存在，则创建
            file.mkdir();
        }
        String finalPath = photoPath + File.separator + fileName;
        photo.transferTo(new File(finalPath));
        return "success";
    }
}
