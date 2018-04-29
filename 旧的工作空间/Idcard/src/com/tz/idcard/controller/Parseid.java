package com.tz.idcard.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.baidu.aip.ocr.AipOcr;

@WebServlet("/parse")
public class Parseid extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	
	String path=request.getParameter("path");
	
	@SuppressWarnings("deprecation")
	String realpath=request.getRealPath(path);
	
	AipOcr aipOcr= new AipOcr("10130559","NUxG17ktjtIXorzUDQrTM8LP","Cy9PayZuxI4fnyowSlh0o1kvgZEMH9HO");
	JSONObject result=aipOcr.idcard(realpath, true, new HashMap<String,String>());
	System.out.println(result);
	response.getWriter().println(result);
	
	
	
	}

}
