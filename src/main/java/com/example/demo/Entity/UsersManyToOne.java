package com.example.demo.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

/*@Entity
@Table(name = "t_users_many_to_one")*/
public class UsersManyToOne {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="userid")
	private Integer userId;
	
	@Column(name="username")
	private String userName;
	
	@Column(name="userage")
	private String userAge;
	
	@ManyToOne
	// 維護一個外鍵。在t_users_many_to_one表建立一個外鍵，該外鍵叫做roles_id
	@JoinColumn(name = "reles_id")
	private RolesOneToMany roles;
	

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

	@Override
	public String toString() {
		return "UsersOne [userId=" + userId + ", userName=" + userName + ", userAge=" + userAge + ", roles=" + roles
				+ "]";
	}
	
	

}
