package com.study.spring.security.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.google.gson.Gson;
import com.study.spring.dto.MemberDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class APILoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		log.info("######################################");
		log.info(authentication);
		log.info("######################################");
		
//		response.getWriter().write("Login Successful");
		
		MemberDTO memberDTO = (MemberDTO) authentication.getPrincipal();
		
		// we extract out authentication results as json
		
		Map<String, Object> claims = memberDTO.getClaims();
		
		claims.put("accessToken","");
		claims.put("refreshToken","");
		
		// Gson makes json data
		Gson gson = new Gson();
		
		String jsonStr = gson.toJson(claims);
		response.setContentType("application/json;charset=utf-8");
		
		PrintWriter printWriter = response.getWriter();
		printWriter.print(jsonStr);
		printWriter.close();
	}

}