package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.model.SiteUser;
import com.springboot.model.SiteUserDao;

// UserDetailsService
// Core interface which loads user-specific data. 
// 

@Service
public class SiteUserService implements UserDetailsService {

	@Autowired
	private SiteUserDao siteUserDao;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public SiteUser findByEmail(String email) {
		return siteUserDao.findByEmail(email);
	}

	public void saveSiteUser(SiteUser siteUser) {
		siteUser.setRole("ROLE_USER");
		siteUser.setPassword(passwordEncoder.encode(siteUser.getPassword()));
		siteUserDao.save(siteUser);
	}

	// loadUserByUsername
	// Locates the user based on the username. In the actual implementation, the
	// search may possibly be case sensitive, or case insensitive depending on
	// how the implementation instance is configured. In this case, the
	// UserDetails object that comes back may have a username that is of a
	// different case than what was actually requested..
	//

	public UserDetails loadUserByUsername(String email)
			throws UsernameNotFoundException {

		SiteUser siteUser = siteUserDao.findByEmail(email);

		if (siteUser == null) {
			return null;
		}

		// GrantedAuthority is a role in spring
		// Usually a user has a role/authority associated with it, or several of
		// them. I'm not sure if it's possible to have a user that is not
		// associated with any role; perhaps it is, and an empty list would work
		// here. But later on we'll want to create users with various roles; at
		// least administrator users and "normal" users. So it comes in handy.

		// The roles of a user specify what that user is allowed to do on your
		// site. This is something you implement yourself, making up any role
		// name you like as long as it begins with ROLE_ . But there are various
		// bits of stuff to help you implement access control using roles.

		// ROLE_USER - USER (Spring appended ROLE)
		// Creates a array of GrantedAuthority objects from a comma-separated
		// string representation
		// (e.g. "ROLE_A, ROLE_B, ROLE_C").

		List<GrantedAuthority> auth = AuthorityUtils
				.commaSeparatedStringToAuthorityList(siteUser.getRole());

		String password = siteUser.getPassword();

		return new User(email, password, auth);

	}

}
