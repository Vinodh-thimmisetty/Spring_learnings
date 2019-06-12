package com.pluralsight.mvc.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class UserRoleValidityKey implements Serializable {

	private static final long serialVersionUID = 4823635805472417643L;

	private long userId;
	private long roleId;
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getRoleId() {
		return roleId;
	}
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}	

}
