package com.example.demo.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "t_users")
public class UsersOneToOne {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="userid")
	private Integer userId;
	
	@Column(name="username")
	private String userName;
	
	@Column(name="userage")
	private String userAge;
	
	// 表示Users跟Roles是一對一的關係
	/* cascade表示:
	 * 因使用操作UsersOneRepository保存UsersOne資料，
	 * 理當只能保存UsersOne這個物件本身的資料，
	 * 但因為有關聯關係，關係到RolesOne，
	 * 所以必須開啟cascade連帶保存RolesOne物件的資料
	 */
	@OneToOne(cascade = CascadeType.PERSIST)
	// 維護一個外鍵。在t_users建立一個外鍵，該外鍵叫做roles_id
	@JoinColumn(name = "roles_id") 
	private RolesOneToOne roles;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAge() {
		return userAge;
	}

	public void setUserAge(String userAge) {
		this.userAge = userAge;
	}

	public RolesOneToOne getRoles() {
		return roles;
	}

	public void setRoles(RolesOneToOne roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "UsersOne [userId=" + userId + ", userName=" + userName + ", userAge=" + userAge + ", roles=" + roles
				+ "]";
	}
	
	

}
