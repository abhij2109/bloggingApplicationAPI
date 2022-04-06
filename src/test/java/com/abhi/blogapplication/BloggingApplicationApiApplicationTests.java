package com.abhi.blogapplication;

import com.abhi.blogapplication.dto.UserDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BloggingApplicationApiApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void testCreateUser() throws ResourceAccessException {
		RestTemplate restTemplate=new RestTemplate();
		UserDTO userDTO=new UserDTO();
		userDTO.setId(10);
		userDTO.setUserName("Ravi Bhangi");
		userDTO.setUserEmail("bhangiravi@gmail.com");
		userDTO.setUserPassword("Abc@234");
		userDTO.setAbout("He is Bhangi");
		UserDTO userDTO1= restTemplate.postForObject("http://localhost:9090/blogging/users/", userDTO, UserDTO.class);
		assertNotNull(userDTO1);
		assertNotNull(userDTO1.getId());
		assertEquals("Ravi Bhangi",userDTO1.getUserName());
		System.out.println("Test Successfully ran");
	}

}
