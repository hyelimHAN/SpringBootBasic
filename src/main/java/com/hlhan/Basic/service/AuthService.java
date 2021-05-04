package com.hlhan.Basic.service;

import com.hlhan.Basic.dao.local.AuthDao;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;

public interface AuthService extends UserDetailsService {

	Collection<GrantedAuthority> getAuthorities(String username);
	public AuthDao readUser(String username);
	public PasswordEncoder passwordEncoder();
}
