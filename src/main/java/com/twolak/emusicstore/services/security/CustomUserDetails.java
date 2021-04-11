package com.twolak.emusicstore.services.security;

import com.twolak.emusicstore.model.User;

public interface CustomUserDetails {
	User getAuthenticatedUser();
}
