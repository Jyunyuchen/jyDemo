package com.example.demo.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

/**
 * 從角色到用戶是一對多的關係
 * @author jy
 *
 */
/*@Entity
@Table(name = "t_roles_one_to_many")*/
public class RolesOneToMany {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="roleid")
	private Integer roleId;
	
	@Column(name="rolename")
	private String roleName;
	
	
	@OneToMany(mappedBy = "roles")
	// 使用set表示users是多方
	private Set<UsersManyToOne> users = new HashSet<>();
	
	

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "RolesOne [roleId=" + roleId + ", roleName=" + roleName + "]";
	}
	
	
	
}
