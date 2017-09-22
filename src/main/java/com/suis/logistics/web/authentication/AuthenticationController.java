package com.suis.logistics.web.authentication;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.suis.logistics.model.Auth;
import com.suis.logistics.service.authentication.AuthenticationService;
import com.suis.logistics.web.BaseController;


@RestController
@RequestMapping("/authentication")
public class AuthenticationController extends BaseController {
	@Resource
	AuthenticationService	authenticationService;
	@Transactional
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	 public ResponseEntity<AuthDto> login(@RequestHeader("username") String username, @RequestHeader("password") String password){
		AuthDto authDtoResponse = null;
		HttpStatus httpStatus = HttpStatus.OK;
		Auth auth = authenticationService.login(username, password);
		if(auth != null) {
		 authDtoResponse = converterUtil.convertAuthToDto(auth);
		}else {
			httpStatus = HttpStatus.UNAUTHORIZED;
		}
		return new ResponseEntity<AuthDto>(authDtoResponse, httpStatus);
	 }
	public void logout() {}
	public boolean isAuthenticated() {
		return false;
	} 

}
