package com.pluralsight.mvc.entity;

import java.time.LocalDateTime;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "user_roles", schema = "ride_tracker")
public class UserRoleValidity {

	@EmbeddedId
	private UserRoleValidityKey id;

	@ManyToOne
	@MapsId("userId")
	@JoinColumn(name = "userId")
	private RegisteredUser registeredUser;

	@ManyToOne
	@MapsId("roleId")
	@JoinColumn(name = "roleId")
	private RegisteredUserRole registeredUserRole;

	private LocalDateTime createdAt;
	private LocalDateTime expiresAt;

	public UserRoleValidityKey getId() {
		return id;
	}

	public void setId(UserRoleValidityKey id) {
		this.id = id;
	}

	public RegisteredUser getRegisteredUser() {
		return registeredUser;
	}

	public void setRegisteredUser(RegisteredUser registeredUser) {
		this.registeredUser = registeredUser;
	}

	public RegisteredUserRole getRegisteredUserRole() {
		return registeredUserRole;
	}

	public void setRegisteredUserRole(RegisteredUserRole registeredUserRole) {
		this.registeredUserRole = registeredUserRole;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getExpiresAt() {
		return expiresAt;
	}

	public void setExpiresAt(LocalDateTime expiresAt) {
		this.expiresAt = expiresAt;
	}
}
