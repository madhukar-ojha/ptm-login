package com.ptm.login.reqprocessor;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ptm.common.service.ErrorResponse;
import com.ptm.common.service.ServiceException;
import com.ptm.common.service.ServiceResponse;
import com.ptm.common.service.SuccessResponse;
import com.ptm.login.service.LoginService;
import com.ptm.login.vo.LoginVO;
import com.ptm.login.vo.UserDetailVO;

@Component
public class LoginReqProcessor {
	
	@Autowired private LoginService loginService;
		
	/*
	 * public <T> ResponseEntity<ServiceResponse> login(@Valid LoginVO request) {
	 * LoginVO loginVO = (LoginVO) request; UserDetailVO userDetailVO =
	 * loginService.login(loginVO); SuccessResponse successResponse = new
	 * SuccessResponse(); successResponse.setSuccessResponse(userDetailVO); //
	 * ServiceResponse response = new ServiceResponse(successResponse,
	 * HttpStatus.OK); ServiceResponse response = new ServiceResponse();
	 * response.setHttpStatus(HttpStatus.OK);
	 * response.setSuccessResponse(successResponse); ObjectMapper mapper = new
	 * ObjectMapper(); String res = null; try { mapper.writeValue(new
	 * File("login.json"), response); res = mapper.writeValueAsString(response); //
	 * ServiceResponse sr = mapper.readValue(res, ServiceResponse.class); } catch
	 * (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); }
	 * // response.setSuccessResponse(successResponse); //
	 * response.setHttpStatus(HttpStatus.OK ); return ResponseEntity.ok(response); }
	 */
	
	public <T> ResponseEntity<ServiceResponse> login(@Valid LoginVO loginVO) {
		UserDetailVO userDetailVO = loginService.login(loginVO);
		SuccessResponse successResponse = new SuccessResponse(userDetailVO);
		ServiceException exception = new ServiceException("102", "absent msg", "long msg", new HashMap());
		ErrorResponse errorResponse = new ErrorResponse(exception);
		ServiceResponse response = new ServiceResponse(successResponse, errorResponse,HttpStatus.OK);
		return ResponseEntity.ok(response);
	}
			
}
