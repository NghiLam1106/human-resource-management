package com.example.back_end.security;

public class SecurityConstants {
    public static final long JWT_EXPIRATION = 24 * 60 * 60 * 1000; // 1 day

    public static final long JWT_REFRESH_EXPIRATION = 7 * 24 * 60 * 60 * 1000; // 7 days

    public static final String HEADER_STRING = "Authorization";
}
