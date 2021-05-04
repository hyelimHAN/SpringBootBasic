package com.hlhan.Basic.service;

import com.hlhan.Basic.dao.local.AuthDao;
import com.hlhan.Basic.mapper.local.AuthMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private AuthMapper authMapper;
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		AuthDao authDao = authMapper.readUser(username);
		authDao.setAuthorities(getAuthorities(username));
 		return authDao;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities(String username) {
		
		List<String> string_authorities = authMapper.readAuthority(username);
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (String authority : string_authorities) {
             authorities.add(new SimpleGrantedAuthority(authority));
        }
        return authorities;
	}

	@Override
	public AuthDao readUser(String username) {
		
		AuthDao authDao = authMapper.readUser(username);
		authDao.setAuthorities(getAuthorities(username));
		return authDao;
	}

	@Override
	public PasswordEncoder passwordEncoder() {
		
		return this.passwordEncoder;
	}
}
