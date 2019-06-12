package com.pluralsight.mvc.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pluralsight.mvc.entity.RegisteredUser;
import com.pluralsight.mvc.entity.UserRoleValidity;
import com.pluralsight.mvc.repository.AppUserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	private AppUserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		final RegisteredUser currentUser = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User : " + username + " doesn't exist in DB"));
		log.info("Current User :: {}", currentUser);
		return new User(currentUser.getUsername(), currentUser.getPassword(), getAuthorities(currentUser));
	}

	private Set<GrantedAuthority> getAuthorities(RegisteredUser user) {
		Set<GrantedAuthority> authorities = new HashSet<>();
		for (UserRoleValidity roleValidity : user.getUserRoles()) {
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(
					roleValidity.getRegisteredUserRole().getRole());
			authorities.add(grantedAuthority);
		}
		return authorities;
	}

}
