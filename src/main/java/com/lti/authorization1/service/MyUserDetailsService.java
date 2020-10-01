package com.lti.authorization1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lti.authorization1.Model.User1;
import com.lti.authorization1.Repository.UserRepository;



@Service
public class MyUserDetailsService implements UserDetailsService{

	 @Autowired
	    UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
            	.commaSeparatedStringToAuthorityList("ROLE_" + User1.getRoles());
		
		return new User(User1.getUserName(), User1.getPassword(), grantedAuthorities);
	}

}
