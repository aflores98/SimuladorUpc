package com.simulador.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simulador.app.model.dao.IUserRepository;
import com.simulador.app.model.entity.Role;
import com.simulador.app.model.entity.Users;




@Service
public class UserService implements UserDetailsService {

	@Autowired
	private IUserRepository userRepository;
	
	//UserDetails es parte del modulo de seguridad de Spring
		@Override
		@Transactional(readOnly = true)
		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			Users user = userRepository.findByUsername(username);

			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

			for (Role role : user.getRoles()) {
				authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
			}

			return new User(user.getUsername(), user.getPassword(), user.getEnabled(), true, true, true, authorities);
		}
}
