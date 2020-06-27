package com.inventorymanagement.auth;

import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.inventorymanagement.model.UsersMaster;

public class UserPrincipal implements UserDetails {

	private UsersMaster userMaster;
	private final Set<? extends GrantedAuthority> grantedAuthorities;

	public UserPrincipal(UsersMaster userMaster, 
						Set<? extends GrantedAuthority> grantedAuthorities) {
		this.grantedAuthorities = grantedAuthorities;
		this.userMaster = userMaster;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return grantedAuthorities;
	}

	@Override
	public String getPassword() {
		return userMaster.getPassword();
	}

	@Override
	public String getUsername() {
		return userMaster.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
