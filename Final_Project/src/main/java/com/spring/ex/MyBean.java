package com.spring.ex;

import java.io.File;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

public class MyBean implements InitializingBean{

	@Autowired
	ServletContext servletContext;
	
	@PostConstruct
	public void init() {
		System.out.println("------init-----()");
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("------afterPropertiesSet-----");
		String uploadPath = servletContext.getRealPath("/resources/");
		System.out.println("uploadPath: " + uploadPath);
		File destination = new File(uploadPath);
		
		String str = "C:/tempUpload"; 
		File destination_local = new File(str); //폴더로 만듬
		
		FileUtils.copyDirectory(destination_local, destination); //폴더쨰 카피
	}
	
}
