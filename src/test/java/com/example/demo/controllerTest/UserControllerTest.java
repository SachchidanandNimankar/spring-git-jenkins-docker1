package com.example.demo.controllerTest;

import static org.mockito.Mockito.when;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.controller.UserController;
import com.example.demo.service.UserService;

@WebMvcTest(value = UserController.class)
class UserControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private UserService userService;

	@Test
	void getUserValidInput() throws Exception {
		
		int id = 1;
		String name = "rahul";
		
		when(userService.getUserName(id)).thenReturn(name);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("http://localhost:8080/user/1");

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());

	}
	
//	@Test
//	void getUserInvalidInput() throws Exception {
//		
//		int id = 1;
//		String name = "rahul";
//		
//		when(userService.getUserName(id)).thenReturn(name);
//		
//		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("http://localhost:8080/user/6");
//		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//		MockHttpServletResponse response = result.getResponse();
//		assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatus());
//
//	}
}
