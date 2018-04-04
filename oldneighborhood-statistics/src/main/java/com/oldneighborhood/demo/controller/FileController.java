package com.oldneighborhood.demo.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/file")
public class FileController {
	//日志记录
	private static final Logger logger = LoggerFactory.getLogger(FileController.class);
	
	@Value("${file.upload.path}")
	private String uploadpath;
	
	@RequestMapping("/upload")
	public String upload(@RequestParam("upload") MultipartFile file) {
		
		if (file.isEmpty()) {//空文件
			return "{\"result\":\"null\"}";
		}
		//获取文件名
		String fileName = file.getOriginalFilename();
		logger.info("上传文件为： " + fileName);
		//获取文件后缀名
		String suffix = fileName.substring(fileName.lastIndexOf("."));
		logger.info("上传文件格式为：" + suffix);
		
		if (!suffix.equals("xls") && !suffix.equals("xlsx")) {//错误格式文件
			return "{\"result\":\"wrongformat\"}";
		}
		//文件上传后的路径在application中配置
		File dest = new File(uploadpath + fileName);
		//检测是否存在目录
		if (!dest.getParentFile().exists()) {
			dest.getParentFile().mkdirs();
		}
		//存储文件到指定目录
		try {
			file.transferTo(dest);
			return "{\"result\":\"success\"}";
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		return "{\"result\":\"error\"}";
	}

	@RequestMapping("/download")
	public String download(HttpServletRequest request, HttpServletResponse response) {
		String fileName = "model.xlsx";
		if (fileName != null) {
			//?路径是否正确
			String realPath = request.getServletContext().getRealPath("/resources/static/file");
			System.out.println(realPath);
			
			File file = new File(realPath, fileName);
			if (file.exists()) {
				response.setContentType("application/force-download");
				response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);
				
				 byte[] buffer = new byte[1024];
	                FileInputStream fis = null;
	                BufferedInputStream bis = null;
	                try {
	                    fis = new FileInputStream(file);
	                    bis = new BufferedInputStream(fis);
	                    OutputStream os = response.getOutputStream();
	                    int i = bis.read(buffer);
	                    while (i != -1) {
	                        os.write(buffer, 0, i);
	                        i = bis.read(buffer);
	                    }
	                    System.out.println("success");
	                    return "{\"result\":\"success\"}";
	                } catch (Exception e) {
	                    e.printStackTrace();
	                } finally {
	                    if (bis != null) {
	                        try {
	                            bis.close();
	                        } catch (IOException e) {
	                            e.printStackTrace();
	                        }
	                    }
	                    if (fis != null) {
	                        try {
	                            fis.close();
	                        } catch (IOException e) {
	                            e.printStackTrace();
	                        }
	                    }
	                }
	                
			}else {//找不到下载的文件
				return "{\"result\":\"null\"}";
			}
		}
		return "{\"result\":\"error\"}";
	}
}
