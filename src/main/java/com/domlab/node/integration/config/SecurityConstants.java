package com.domlab.node.integration.config;

public class SecurityConstants {

    public static final String SECRET = "test";
    public static final long EXPIRATION_TIME = 864_000_000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/api/v1/auth/sign-up";
}
