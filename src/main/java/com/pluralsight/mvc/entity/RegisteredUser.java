package com.pluralsight.mvc.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.ToString;

@Entity
@Table(name = "users", schema = "ride_tracker")
@ToString
public class RegisteredUser {

	@Id
	@GeneratedValue
	private long userId;

	@Column(nullable = false, unique = true)
	private String username;

	@Column(nullable = false)
	private String password;

	private boolean enabled;

	@OneToMany(mappedBy = "registeredUser", fetch = FetchType.EAGER)
	private Set<UserRoleValidity> userRoles;

	public Set<UserRoleValidity> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRoleValidity> userRoles) {
		this.userRoles = userRoles;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}
