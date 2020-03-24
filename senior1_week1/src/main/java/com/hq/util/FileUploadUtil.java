package com.hq.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtil {
	
	public static String  load(HttpSession session,MultipartFile file,String toPath) {
		String originalFilename = file.getOriginalFilename();
		int indexOf = originalFilename.indexOf(".");
		String houzhui = originalFilename.substring(indexOf);
		String string = UUID.randomUUID().toString();
		
		String realPath = session.getServletContext().getRealPath("/"+toPath);
		
		String path=realPath+File.separator+string+houzhui;
		
		// �ϴ��ļ�
		File file2 = new File(path);
		try {
			file.transferTo(file2);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return string+houzhui;
	}

	
	
	public static  void down(String fileName,String toPath,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("multipart/form-data");
		// �������ڵ�ͷ�ļ�  ��ʽ
		response.setHeader("Content-Disposition", "attachment;fileName="
				+ fileName);
		// ��ȡ�ļ��� ����·��
		String realPath = request.getSession().getServletContext().getRealPath("/"+toPath+"/");
		realPath=realPath+File.separator+fileName;
		try {
			FileInputStream fis=new FileInputStream(realPath);
			OutputStream outputStream = response.getOutputStream();
			int read=0;
			while((read=fis.read())!=-1) {
				outputStream.write(read);
			}
			
			close(fis,outputStream);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public  static void  close(InputStream is,OutputStream os) {
		try {
			if(is!=null) {
				is.close();
			}
			if(os!=null) {
				os.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
