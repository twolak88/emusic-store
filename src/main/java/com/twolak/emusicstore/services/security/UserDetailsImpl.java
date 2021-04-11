package com.twolak.emusicstore.services.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.twolak.emusicstore.model.User;
import com.twolak.emusicstore.repositories.AuthoritiesRepository;

public class UserDetailsImpl implements UserDetails, CustomUserDetails {
	
	private static final long serialVersionUID = -6172428148585970866L;
	
	private final User user;
	private final AuthoritiesRepository authoritiesRepository;
	
	public UserDetailsImpl(User user, AuthoritiesRepository authoritiesRepository) {
		this.user = user;
		this.authoritiesRepository = authoritiesRepository;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authoritiesRepository.findByUsername(this.user.getUsername())
				.stream()
				.map(authority -> new SimpleGrantedAuthority(authority.getAuthority()))
				.collect(Collectors.toSet());
	}

	@Override
	public String getPassword() {
		return this.user.getPassword();
	}

	@Override
	public String getUsername() {
		return this.user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		return this.user.isEnabled();
	}

	@Override
	public User getAuthenticatedUser() {
		return this.user;
	}

}
