package com.suis.logistics.web.user;

import javax.annotation.Resource;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.suis.logistics.service.user.UserService;
import com.suis.logistics.web.BaseController;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController{
	
	@Resource
	UserService userService;
		
	@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> addUser(@RequestBody UserDto userDto, UriComponentsBuilder ucBuilder){
        
        userService.createUser(converterUtil.convertUserDtoToEntity(userDto));

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(1).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
	
	@RequestMapping(value = "{userName}", method = RequestMethod.GET)
	@Transactional
    public ResponseEntity<UserDto> getUser(@PathVariable("userName") String userName){
        UserDto userDto = converterUtil.convertUserToDto(userService.getUserByUserName(userName));
        return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
    }
	
}
