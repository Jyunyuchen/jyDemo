package com.example.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

/*@Entity
@Table(name = "t_roles")*/
public class RolesOneToOne {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="roleid")
	private Integer roleId;
	
	@Column(name="rolename")
	private String roleName;
	
	// mappedBy表示被維護的一方，要將哪個對象關聯進來
	@OneToOne(mappedBy = "roles")
	private UsersOneToOne users;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public UsersOneToOne getUsers() {
		return users;
	}

	public void setUsers(UsersOneToOne users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "RolesOne [roleId=" + roleId + ", roleName=" + roleName + "]";
	}
	
	
	
}
