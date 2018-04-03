package com.oldneighborhood.demo.service.impl;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DealWithFile {
	
//	private String path = "/file";
	/**
	 * @Title: downloadFile 
	 * @Description: 下载文件
	 * @return String 
	 * @throws
	 */
	public String downloadFile(HttpServletRequest request, HttpServletResponse response) {
		//?
		String realpath = request.getServletContext().getRealPath("//WEB-INF//");
		String filename = "model.xlsx";
		File file = new File(realpath, filename);
		if (file.exists()) {
			response.setContentType("application/force-download");//设置强制下载不打开
			response.addHeader("content-Disposition", "attachment;filename=" + filename);
			//设置文件名
			
			byte[] buffer = new byte[1024];
			FileInputStream fis = null;
			BufferedInputStream bis = null;
			
			try {
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				OutputStream os = response.getOutputStream();
				int i = bis.read(buffer);
				while (i != -1) {//not end
					os.write(buffer, 0, i);
					i = bis.read(buffer);
				}
				System.out.println("success");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {//关闭流
				if (bis != null) {
					try {
						bis.close();
					} catch (IOException e2) {
						e2.printStackTrace();
					}
				}
				
				if (fis != null) {
					try {
						fis.close();
					} catch (IOException e3) {
						e3.printStackTrace();
					}
				}
			}
			
		}
		return null;
	}

	
}
