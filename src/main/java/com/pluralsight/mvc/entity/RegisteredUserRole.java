package com.pluralsight.mvc.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roles", schema = "ride_tracker")
public class RegisteredUserRole {

	@Id
	@GeneratedValue
	private long roleId;

	@Column(nullable = false)
	private String role;

	@OneToMany(mappedBy = "registeredUserRole")
	private Set<UserRoleValidity> userRoles;

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set<UserRoleValidity> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRoleValidity> userRoles) {
		this.userRoles = userRoles;
	}

}
