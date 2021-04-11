package com.twolak.emusicstore.services.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.twolak.emusicstore.model.User;
import com.twolak.emusicstore.repositories.AuthoritiesRepository;
import com.twolak.emusicstore.repositories.UserRepository;

@Service
public class SecurityServiceImpl implements UserDetailsService {
	
	private final UserRepository userRepository;
	private final AuthoritiesRepository authoritiesRepository;
	
	public SecurityServiceImpl(UserRepository userRepository, AuthoritiesRepository authoritiesRepository) {
		this.userRepository = userRepository;
		this.authoritiesRepository = authoritiesRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = this.userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found.");
        }
        return new UserDetailsImpl(user, authoritiesRepository);
	}

}
