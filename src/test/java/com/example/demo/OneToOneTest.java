package com.example.demo;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Entity.RolesOneToOne;
import com.example.demo.Entity.UsersOneToOne;
import com.example.demo.Repository.UsersOneRepository;

@SpringBootTest
public class OneToOneTest {
	
	@Autowired
	UsersOneRepository usersOneRepository;
	
	/**
	 * 級聯插入數據
	 */
	@Test
	void test01() {
		
		//創建角色
		RolesOneToOne rolesOne = new RolesOneToOne();
		rolesOne.setRoleName("管理員");
		
		//創建使用者
		UsersOneToOne usersOne = new UsersOneToOne();
		usersOne.setUserName("趙小剛");
		usersOne.setUserAge("22");
		
		//建立關係
		usersOne.setRoles(rolesOne);
		
		usersOneRepository.save(usersOne);
	}
	
	/**
	 * 根據用戶ID查詢用戶
	 */
	@Test
	void test02() {
		
		Optional<UsersOneToOne> usersOne = usersOneRepository.findById(1);
		
		System.out.println("======>\n" + usersOne.get());
		
	}

}
