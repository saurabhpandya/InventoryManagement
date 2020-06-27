package com.inventorymanagement.jwt;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.google.common.net.HttpHeaders;

@ConfigurationProperties(prefix = "application.jwt")
@Component
public class JwtConfig {
	private String secretKey;
	private String tokenPrefix;
	private Integer tokenExpirationAfterDays;

	public JwtConfig() {

	}

//	public JwtConfig jwtConfig() {		
//		JwtConfig jwtConfig = new JwtConfig();
//		jwtConfig.secretKey = secretKey;
//		jwtConfig.tokenPrefix = tokenPrefix;
//		jwtConfig.tokenExpirationAfterDays = tokenExpirationAfterDays;
//		return jwtConfig;
//	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public String getTokenPrefix() {
		return tokenPrefix;
	}

	public void setTokenPrefix(String tokenPrefix) {
		this.tokenPrefix = tokenPrefix;
	}

	public Integer getTokenExpirationDays() {
		return tokenExpirationAfterDays;
	}

	public void setTokenExpirationDays(Integer tokenExpirationDays) {
		this.tokenExpirationAfterDays = tokenExpirationDays;
	}

	public String getAuthorizationHeader() {
		return HttpHeaders.AUTHORIZATION;
	}

}
