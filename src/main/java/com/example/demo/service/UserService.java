package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {

	public String getUserName(int id) {
		
		Map<Integer,String> userMap = new HashMap<>();
		userMap.put(1, "rahul");
		userMap.put(2, "ajay");
		userMap.put(3, "varsha");
		userMap.put(4, "priyanka");
		userMap.put(5, "vishnu");
		
		if (!userMap.containsKey(id))
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "key not found / pipeline implemented /"
					+ "docker image from jenkins");
		else
		   return userMap.get(id);
	}

}
