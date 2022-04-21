package com.example.demo;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;

import junit.framework.Assert;

@SpringBootTest
public class SpringMockitoTest {
	
	@Mock
	UserDao userDao;
	
	@Test
	public void test01() {
		when(userDao.test()).thenReturn("ok");
		 String result = userDao.test();
		 System.out.println("===> " + result);
		 Assert.assertEquals("ok", result);
	}
	

}

@Repository
class UserDao{
	
	public String test() {
		return "error";
	}
	
}